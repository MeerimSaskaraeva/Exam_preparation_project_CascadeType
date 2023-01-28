package peaksoft.repository;

import peaksoft.entities.Course;
import peaksoft.entities.Instructor;

import java.util.List;
import java.util.Set;

public interface InstructorRepository {
    String saveInstructor(Instructor instructor);
    Instructor updateInstructor(Long id,String name);
    Instructor getInstructorById(Long id);
    List<Instructor> getInstructorsByCourseId(Long courseId);
    String deleteInstructorById(Long id);
    String assignInstructorToCourse(Long instructorId,Long courseId);


}
