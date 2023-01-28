package peaksoft.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "instructors")
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = "courses")
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(unique = true)
    private String email;
    @Column(name = "phone_number", length = 13)
    private String phoneNumber;
    @ManyToMany(cascade = {CascadeType.PERSIST,
            CascadeType.REFRESH,
//            CascadeType.REMOVE,
            CascadeType.MERGE,
            CascadeType.DETACH},
            fetch = FetchType.EAGER)
    @JoinTable(name = "instructor_courses",
            joinColumns = @JoinColumn(name = "instructor_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))

    private Set<Course> courses;

    public Instructor(String firstName, String lastName,
                      String email, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
