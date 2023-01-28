package peaksoft.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
@Entity
@Table(name="tasks")
@Getter
@Setter
@NoArgsConstructor
@ToString

public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="task_name")
    private String taskName;
    @Column(name="dead_line")
    private LocalDateTime deadline;
    private String task;


    public Task(String taskName, LocalDateTime deadline, String task) {
        this.taskName = taskName;
        this.deadline = deadline;
        this.task = task;
    }
}
