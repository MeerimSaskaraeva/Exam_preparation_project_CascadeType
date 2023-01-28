package peaksoft.service;

import peaksoft.entities.Task;
import peaksoft.repository.TaskRepository;
import peaksoft.repository.TaskRepositoryImpl;

import java.util.List;

public class TaskServiceImpl implements TaskService{
    TaskRepository taskRepository=new TaskRepositoryImpl();

    @Override
    public String saveTask(Task task,Long lessonId) {
        return taskRepository.saveTask(task,lessonId);
    }

    @Override
    public Task updateTask(Long id, Task task) {
        return taskRepository.updateTask(id,task);
    }

    @Override
    public List<Task> getAllTaskByLessonId(Long lessonId) {
        return taskRepository.getAllTaskByLessonId(lessonId);
    }
}
