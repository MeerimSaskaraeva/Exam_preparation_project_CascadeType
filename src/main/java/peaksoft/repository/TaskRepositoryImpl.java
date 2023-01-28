package peaksoft.repository;

import jakarta.persistence.EntityManager;
import peaksoft.config.HibernateConfiguration;
import peaksoft.entities.Lesson;
import peaksoft.entities.Task;

import java.util.List;

public class TaskRepositoryImpl implements TaskRepository{
    EntityManager entityManager= HibernateConfiguration.getEntityManager();
    @Override
    public String saveTask(Task task,Long lessonId) {
        entityManager.getTransaction().begin();
        entityManager.persist(task);
        Lesson lesson = entityManager.find(Lesson.class, lessonId);
        lesson.getTasks().add(task);
        entityManager.getTransaction().commit();
        entityManager.close();
        return task+" is saved.........";
    }

    @Override
    public Task updateTask(Long id, Task task) {
        entityManager.getTransaction().begin();
        Task task1 = entityManager.find(Task.class, id);
        task1.setTaskName(task.getTaskName());
        task1.setDeadline(task.getDeadline());
        task1.setTask(task.getTask());
        entityManager.merge(task1);
        entityManager.getTransaction().commit();
        entityManager.close();
        return task1;
    }

    @Override
    public List<Task> getAllTaskByLessonId(Long lessonId) {
        entityManager.getTransaction().begin();
        List<Task> tasks = entityManager.find(Lesson.class, lessonId).getTasks();
        entityManager.getTransaction().commit();
        entityManager.close();
        return tasks;
    }
}
