package peaksoft.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "courses")
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = "lessons")


public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "course_name")
    private String courseName;

    private int duration;
    @Column(name = "create_at")
    private LocalDate createAt;
    @Column(name = "image_link")
    private String imageLink;
    private String description;
    @ManyToMany(//mappedBy = "courses",
            cascade = {CascadeType.PERSIST,
                    CascadeType.REFRESH,
//            CascadeType.REMOVE,
                    CascadeType.MERGE,
                    CascadeType.DETACH},
            fetch = FetchType.EAGER)
    @JoinTable(name = "instructor_courses",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "instructor_id"))

    private List<Instructor> instructors;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "courses", cascade = {CascadeType.PERSIST,
            CascadeType.REFRESH,
//            CascadeType.REMOVE,
            CascadeType.MERGE,
            CascadeType.DETACH})
    private List<Lesson> lessons;

    public Course(String courseName, int duration, LocalDate createAt,
                  String imageLink, String description) {
        this.courseName = courseName;
        this.duration = duration;
        this.createAt = createAt;
        this.imageLink = imageLink;
        this.description = description;
    }
}
