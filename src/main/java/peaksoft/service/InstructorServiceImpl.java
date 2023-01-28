package peaksoft.service;

import peaksoft.entities.Course;
import peaksoft.entities.Instructor;
import peaksoft.repository.InstructorRepository;
import peaksoft.repository.InstructorRepositoryImpl;

import java.util.List;
import java.util.Set;

public class InstructorServiceImpl implements InstructorService{
    InstructorRepository instructorRepository=new InstructorRepositoryImpl();
    @Override
    public String saveInstructor(Instructor instructor) {
        return instructorRepository.saveInstructor(instructor);
    }

    @Override
    public Instructor updateInstructor(Long id, String name) {
        return instructorRepository.updateInstructor(id,name);
    }

    @Override
    public Instructor getInstructorById(Long id) {
        return instructorRepository.getInstructorById(id);
    }

    @Override
    public List<Instructor>  getInstructorsByCourseId(Long courseId) {

        return instructorRepository.getInstructorsByCourseId(courseId);
    }

    @Override
    public String deleteInstructorById(Long id) {
        return instructorRepository.deleteInstructorById(id);
    }

    @Override
    public String assignInstructorToCourse(Long instructorId,Long courseId) {

        return instructorRepository.assignInstructorToCourse(instructorId,courseId);
    }
}
