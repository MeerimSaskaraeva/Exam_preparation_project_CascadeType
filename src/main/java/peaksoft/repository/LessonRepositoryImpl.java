package peaksoft.repository;

import jakarta.persistence.EntityManager;
import peaksoft.config.HibernateConfiguration;
import peaksoft.entities.Course;
import peaksoft.entities.Lesson;

import java.util.List;

public class LessonRepositoryImpl implements LessonRepository{
    EntityManager entityManager= HibernateConfiguration.getEntityManager();
    @Override
    public String saveLesson(Lesson lesson, Long courseId) {
        entityManager.getTransaction().begin();
        entityManager.persist(lesson);
        Course course = entityManager.find(Course.class, courseId);
        lesson.setCourses(course);
        entityManager.getTransaction().commit();
        entityManager.close();
        return lesson+" is saved";
    }

    @Override
    public Lesson updateLesson(Long id, Lesson lesson) {
        entityManager.getTransaction().begin();
        Lesson lesson1 = entityManager.find(Lesson.class, id);

        lesson1.setLessonName(lesson.getLessonName());
        lesson1.setVideoLink(lesson.getVideoLink());
        lesson1.setCourses(lesson.getCourses());
        entityManager.merge(lesson1);
        entityManager.getTransaction().commit();
        entityManager.close();
        return lesson1;
    }

    @Override
    public Lesson getLessonById(Long id) {
        entityManager.getTransaction().begin();
        Lesson lesson = entityManager.find(Lesson.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return lesson;
    }

    @Override
    public List<Lesson> getLessonsByCourseId(Long courseId) {
        entityManager.getTransaction().begin();
        List<Lesson> lessons = entityManager.find(Course.class, courseId).getLessons();
        entityManager.getTransaction().commit();
        entityManager.close();
        return lessons;
    }

    @Override
    public String assignLessonToCourse(Long lessonId, Long courseId) {
        entityManager.getTransaction().begin();
        Lesson lesson = entityManager.find(Lesson.class, lessonId);
        Course course = entityManager.find(Course.class, courseId);
        lesson.setCourses(course);
        entityManager.getTransaction().commit();
        entityManager.close();
        return lesson+" is assign "+ course;
    }
}
