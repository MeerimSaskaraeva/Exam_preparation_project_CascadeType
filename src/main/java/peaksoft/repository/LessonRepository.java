package peaksoft.repository;

import peaksoft.entities.Course;
import peaksoft.entities.Lesson;

import java.util.List;

public interface LessonRepository {
    String saveLesson(Lesson lesson, Long courseId);
    Lesson updateLesson(Long id,Lesson lesson);
    Lesson getLessonById(Long id);
    List<Lesson> getLessonsByCourseId(Long courseId);
    String assignLessonToCourse(Long lessonId,Long courseId);
}
