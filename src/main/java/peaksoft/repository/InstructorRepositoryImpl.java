package peaksoft.repository;

import jakarta.persistence.EntityManager;
import peaksoft.config.HibernateConfiguration;
import peaksoft.entities.Course;
import peaksoft.entities.Instructor;

import java.util.List;
import java.util.Set;

public class InstructorRepositoryImpl implements InstructorRepository{
    EntityManager entityManager= HibernateConfiguration.getEntityManager();
    @Override
    public String saveInstructor(Instructor instructor) {
        entityManager.getTransaction().begin();
        entityManager.persist(instructor);
        entityManager.getTransaction().commit();
        entityManager.close();
        return instructor+" is saved";
    }

    @Override
    public Instructor updateInstructor(Long id, String name) {
            entityManager.getTransaction().begin();
            Instructor instructor = entityManager.find(Instructor.class, id);
            instructor.setFirstName(name);
            entityManager.getTransaction().commit();
            entityManager.close();
            return instructor;
        }

    @Override
    public Instructor getInstructorById(Long id) {
        entityManager.getTransaction().begin();
        Instructor instructor = entityManager.find(Instructor.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return instructor;
    }

    @Override
    public List<Instructor>  getInstructorsByCourseId(Long courseId) {
        entityManager.getTransaction().begin();
        List<Instructor> instructors = entityManager.find(Course.class, courseId).getInstructors();
        entityManager.getTransaction().commit();
        entityManager.close();
        return instructors;
    }

    @Override
    public String deleteInstructorById(Long id) {
        entityManager.getTransaction().begin();
        Instructor instructor = entityManager.find(Instructor.class, id);
        entityManager.remove(instructor);
        entityManager.getTransaction().commit();
        entityManager.close();
        return instructor+" is deleted..........";
    }

    @Override
    public String assignInstructorToCourse(Long instructorId, Long courseId) {
        entityManager.getTransaction().begin();
        Instructor instructor = entityManager.find(Instructor.class, instructorId);
        Course course = entityManager.find(Course.class, courseId);
        instructor.getCourses().add(course);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "assign "+instructor+" to course -->"+course;
    }

}
