package peaksoft.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name="lessons")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="lesson_name")
    private String lessonName;
    @Column(name="video_link")
    private String videoLink;
    @ManyToOne(cascade = {CascadeType.PERSIST,
            CascadeType.REFRESH,
            CascadeType.MERGE,
            CascadeType.DETACH},fetch = FetchType.EAGER)
    @JoinColumn(name="course_id")
    private Course courses;
    @OneToMany(cascade = {CascadeType.PERSIST,
            CascadeType.REFRESH,
            CascadeType.MERGE,
            CascadeType.DETACH},fetch = FetchType.EAGER)
    private List<Task> tasks;


    public Lesson(String lessonName, String videoLink) {
        this.lessonName = lessonName;
        this.videoLink = videoLink;
    }

    public Lesson(String lessonName, String videoLink, Course course) {
        this.lessonName = lessonName;
        this.videoLink = videoLink;
        this.courses = course;
    }
}
