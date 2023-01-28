package peaksoft.service;

import peaksoft.entities.Course;
import peaksoft.entities.Lesson;
import peaksoft.repository.LessonRepository;
import peaksoft.repository.LessonRepositoryImpl;

import java.util.List;

public class LessonServiceImpl implements LessonService{
    LessonRepository lessonRepository=new LessonRepositoryImpl();
    @Override
    public String saveLesson(Lesson lesson, Long courseId) {

        return lessonRepository.saveLesson(lesson,courseId);
    }

    @Override
    public Lesson updateLesson(Long id, Lesson lesson) {

        return lessonRepository.updateLesson(id,lesson);
    }

    @Override
    public Lesson getLessonById(Long id) {
        return lessonRepository.getLessonById(id);
    }

    @Override
    public List<Lesson> getLessonsByCourseId(Long courseId) {
        return lessonRepository.getLessonsByCourseId(courseId);
    }

    @Override
    public String assignLessonToCourse(Long lessonId, Long courseId) {
        return lessonRepository.assignLessonToCourse(lessonId,courseId);
    }
}
