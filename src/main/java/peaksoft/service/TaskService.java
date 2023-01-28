package peaksoft.service;

import peaksoft.entities.Task;

import java.util.List;

public interface TaskService {
    String saveTask(Task task,Long lessonId);
    Task updateTask(Long id, Task task);
    List<Task> getAllTaskByLessonId(Long lessonId);
}
