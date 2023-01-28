package peaksoft.repository;

import jakarta.persistence.QueryHint;
import peaksoft.entities.Course;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public interface CourseRepository {
    void saveCourse(Course course);
    Course getCourseById(Long id);
    List<Course> getAllCourse();
    Course updateCourse(Long id,String name);

    String deleteCourseById(Long id);
    List <Course> getCourseByName(String name);

}
