package peaksoft;

import peaksoft.config.HibernateConfiguration;
import peaksoft.entities.Course;
import peaksoft.entities.Instructor;
import peaksoft.entities.Lesson;
import peaksoft.entities.Task;
import peaksoft.repository.InstructorRepository;
import peaksoft.repository.InstructorRepositoryImpl;
import peaksoft.service.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        CourseService courseService = new CourseServiceImpl();
        InstructorService instructorService = new InstructorServiceImpl();
        LessonService lessonService = new LessonServiceImpl();
        TaskService taskService = new TaskServiceImpl();

        Instructor instructor1 = new Instructor("Aijamal", "Asangazieva",
                "aijamal@gmail.com", "+996777888999");
        Instructor instructor2 = new Instructor("Chyngyz", "Sharshekeev",
                "chyngyz@gmail.com", "+996700999999");
        List<Instructor> instructorList = new ArrayList<>();
        instructorList.add(instructor1);
        instructorList.add(instructor2);
        Instructor instructor3 = new Instructor("Muhammed", "Asantegin",
                "m@gmail.com", "+996777888999");
        Instructor instructor4 = new Instructor("Rahim", "Bazarbaev",
                "r@gmail.com", "+996700999999");
        List<Instructor> instructorList2 = new ArrayList<>();
        instructorList.add(instructor3);
        instructorList.add(instructor4);

        Course course1 = new Course("JS7", 9, LocalDate.of(2022, 07, 01),
                "smile", "good course");
        Course course2 = new Course("JS8", 9, LocalDate.of(2022, 10, 01),
                "fffffff", "excellent course");
        Set<Course> courseSet = new HashSet<>();
        courseSet.add(course1);
        courseSet.add(course2);
        Lesson lesson1 = new Lesson("JDBC", "Video link");
        Lesson lesson2 = new Lesson("Hibernate", "https://www.youtube.com/watch?v=-nhlFBDLjaI");

        Task task1 = new Task("Task 1",
                LocalDateTime.of(2023, 01, 30, 11, 00, 00),
                "Task of teacher 2");
        Task task2 = new Task("Task 2",
                LocalDateTime.of(2022, 11, 30, 13, 00, 00),
                "Task of teacher 1");


        System.out.println("\n~~~~~~~~~~~~~~~~~~Commands~~~~~~~~~~~~~~~~~~~~~~" +
                "\n1== save instructor1" +
                "\n21== save instructor2" +
                "\n2== get Course By Id 1L" +
                "\n22==get All Course" +
                "\n3== update Course 1L" +
                "\n4== delete Course By Id 2L" +
//                "\n5==get Instructors" +
                "\n7==get Course By Name" +
                "\n8==update Instructor 1L" +
                "\n9==get Instructor By Id 1L" +
                "\n10==get Instructors By Course Id" +
                "\n11==delete Instructor By Id" +
                "\n12==assign Instructor To Course" +
                "\n13==save Lesson" +
                "\n14==update Lesson" +
                "\n15==get Lesson By Id" +
                "\n16==assign Lesson To Course" +
                "\n17==get Lessons By Course Id" +
                "\n18==save Task" +
                "\n19=update Task" +
                "\n20==get All Task By Lesson Id"

        );
        int number = new Scanner(System.in).nextInt();
        switch (number) {
            case 1 -> {
                instructor1.setCourses(courseSet);
                System.out.println(instructorService.saveInstructor(instructor1));
            }
            case 21 -> {
                instructor2.setCourses(courseSet);
                System.out.println(instructorService.saveInstructor(instructor2));
            }
            case 2 -> {
                System.out.print("White course id: ");
                System.out.println(courseService.getCourseById(new Scanner(System.in).nextLong()));
            }
            case 22 -> courseService.getAllCourse().forEach(System.out::println);

            case 3 -> {
                System.out.print("White course id: ");
                System.out.println(courseService.updateCourse(new Scanner(System.in).nextLong(), "JavaScript"));
            }
            case 4 -> {
                System.out.print("White course id: ");

                System.out.println(courseService.deleteCourseById(new Scanner(System.in).nextLong()));
            }
//            case 5 -> System.out.println(course1.getInstructors().add(instructor1));
            case 7 -> {System.out.print("White course name: ");
                System.out.println(courseService.getCourseByName(new Scanner(System.in).next().toUpperCase()));
            }
            case 8 -> {
                System.out.print("White instructor id: ");
                System.out.println(instructorService.updateInstructor(new Scanner(System.in).nextLong(), "Aijamal"));
            }
            case 9 -> {
                System.out.print("White instructor id: ");
                System.out.println(instructorService.getInstructorById(new Scanner(System.in).nextLong()));
            }
            case 10 -> {
                System.out.print("White course id: ");
                instructorService.getInstructorsByCourseId(new Scanner(System.in).nextLong()).forEach(System.out::println);
            }
            case 11 -> {
                System.out.print("White instructor id: ");
                System.out.println(instructorService.deleteInstructorById(new Scanner(System.in).nextLong()));
            }
            case 12 -> {
                System.out.print("White instructor id : ");
                System.out.print("White course id : ");
                System.out.println(instructorService.assignInstructorToCourse(new Scanner(System.in).nextLong(), new Scanner(System.in).nextLong()));
            }
            case 13 -> {
                System.out.print("White course id : ");
                System.out.println(lessonService.saveLesson(lesson1, new Scanner(System.in).nextLong()));
            }
            case 14 -> {
                System.out.print("White lesson id: ");
                System.out.print("White course id: ");
                System.out.println(lessonService.updateLesson(new Scanner(System.in).nextLong(), new Lesson("Hibernate", "https://www.youtube.com/watch?v=kmDdy6SBM9Y")));
            }
            case 15 -> {
                System.out.print("White lesson id: ");
                System.out.println(lessonService.getLessonById(new Scanner(System.in).nextLong()));
            }
            case 16 -> {
                System.out.print("White lesson id : ");
                System.out.print("White course id : ");
                System.out.println(lessonService.assignLessonToCourse(new Scanner(System.in).nextLong(), new Scanner(System.in).nextLong()));
            }
            case 17 -> {
                System.out.print("White corse id: ");
                lessonService.getLessonsByCourseId(new Scanner(System.in).nextLong()).forEach(System.out::println);
            }
            case 18 -> {
                System.out.print("White lesson id: ");
                System.out.println(taskService.saveTask(task2, new Scanner(System.in).nextLong()));
            }
            case 19 -> {
                System.out.print("White task id: ");
                System.out.println(taskService.updateTask(new Scanner(System.in).nextLong(), new Task("Git", LocalDateTime.of(2023, 01, 30, 11, 00, 00), "task 3")));
            }
            case 20 -> {
                System.out.print("White lesson id: ");
                taskService.getAllTaskByLessonId(new Scanner(System.in).nextLong()).forEach(System.out::println);
            }

        }
    }
}


