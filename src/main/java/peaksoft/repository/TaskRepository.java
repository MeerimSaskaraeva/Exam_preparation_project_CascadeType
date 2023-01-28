package peaksoft.repository;

import peaksoft.entities.Lesson;
import peaksoft.entities.Task;

import java.util.List;

public interface TaskRepository {
    String saveTask(Task task,Long lessonId);
    Task updateTask(Long id, Task task);
    List<Task> getAllTaskByLessonId(Long lessonId);
}
