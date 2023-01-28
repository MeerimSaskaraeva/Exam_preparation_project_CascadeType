package peaksoft.service;

import peaksoft.entities.Course;

import java.util.List;

public interface CourseService {
    String saveCourse(Course course);
    Course getCourseById(Long id);
    List<Course> getAllCourse();
    Course updateCourse(Long id,String name);
    String deleteCourseById(Long id);
    List <Course> getCourseByName(String name);
}
