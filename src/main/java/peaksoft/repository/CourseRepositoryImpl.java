package peaksoft.repository;

import jakarta.persistence.EntityManager;
import peaksoft.config.HibernateConfiguration;
import peaksoft.entities.Course;
import peaksoft.entities.Instructor;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CourseRepositoryImpl implements CourseRepository{
    private  final EntityManager entityManager= HibernateConfiguration.getEntityManager();
    @Override
    public void saveCourse(Course course) {
        entityManager.getTransaction().begin();
        entityManager.persist(course);
        entityManager.getTransaction().commit();
        entityManager.close();


    }

    @Override
    public Course getCourseById(Long id) {
        entityManager.getTransaction().begin();
        Course course = entityManager.find(Course.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return course;
    }

    @Override
    public List<Course> getAllCourse() {
        entityManager.getTransaction().begin();
        List<Course> selectCFromCourseC = entityManager.createQuery("select c from Course c", Course.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return selectCFromCourseC;
    }

    @Override
    public Course updateCourse(Long id, String name) {
        entityManager.getTransaction().begin();
        Course course = entityManager.find(Course.class, id);
        course.setCourseName(name);
        entityManager.getTransaction().commit();
        entityManager.close();
        return course;
    }

    @Override
    public String deleteCourseById(Long courseId) {
        entityManager.getTransaction().begin();
        Course course = entityManager.find(Course.class, courseId);
        entityManager.remove(course);
        entityManager.getTransaction().commit();
        entityManager.close();
        return course.getCourseName()+" is deleted ";
    }

    @Override
    public List <Course> getCourseByName(String name) {
        entityManager.getTransaction().begin();
        List <Course> courses = entityManager.createQuery("select c from Course c " +
                "where c.courseName=:name",Course.class).setParameter("name",name).
                getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();
        return courses;
    }
}
