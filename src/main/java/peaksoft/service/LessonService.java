package peaksoft.service;

import peaksoft.entities.Course;
import peaksoft.entities.Lesson;
import peaksoft.repository.LessonRepository;

import java.util.List;

public interface LessonService {
    String saveLesson(Lesson lesson, Long courseId);
    Lesson updateLesson(Long id,Lesson lesson);
    Lesson getLessonById(Long id);
    List<Lesson> getLessonsByCourseId(Long courseId);
    String assignLessonToCourse(Long lessonId,Long courseId);
}
