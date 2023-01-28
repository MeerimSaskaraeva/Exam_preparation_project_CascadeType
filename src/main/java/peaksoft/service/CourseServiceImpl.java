package peaksoft.service;

import peaksoft.entities.Course;
import peaksoft.repository.CourseRepository;
import peaksoft.repository.CourseRepositoryImpl;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CourseServiceImpl implements CourseService {
    CourseRepository courseRepository = new CourseRepositoryImpl();

    @Override
    public String saveCourse(Course course) {
        courseRepository.saveCourse(course);
        return "\n" + course + " successfully saved";
    }

    @Override
    public Course getCourseById(Long id) {
        return courseRepository.getCourseById(id);

    }

    @Override
    public List<Course> getAllCourse() {
        System.out.println("Write asc or desc");
        String asc=new Scanner(System.in).next();
        if (asc.equals("asc")){
        return courseRepository.getAllCourse().stream().
                sorted(Comparator.comparing(Course::getCreateAt)).collect(Collectors.toList());}


        return courseRepository.getAllCourse().stream().
                sorted(Comparator.comparing(Course::getCreateAt).reversed()).collect(Collectors.toList());
    }

    @Override
    public Course updateCourse(Long id, String name) {
        return courseRepository.updateCourse(id,name);
    }

    @Override
    public String deleteCourseById(Long id) {
        return courseRepository.deleteCourseById(id);

    }

    @Override
    public List <Course> getCourseByName(String name) {

        return courseRepository.getCourseByName(name);
    }
}
