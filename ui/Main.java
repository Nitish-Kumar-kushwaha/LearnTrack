package ui;

import entity.Course;
import entity.Enrollment;
import entity.Student;
import exception.EntityNotFoundException;
import service.CourseService;
import service.EnrollmentService;
import service.StudentService;
import util.IdGenerator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StudentService studentService = new StudentService();
        CourseService courseService = new CourseService();
        EnrollmentService enrollmentService = new EnrollmentService();

        while (true) {
            System.out.println("\n===== LearnTrack Menu =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Add Course");
            System.out.println("4. View Courses");
            System.out.println("5. Enroll Student in Course");
            System.out.println("6. View Enrollments by Student");
            System.out.println("7. Exit");
            System.out.print("Choose option: ");

            try {
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {

                    case 1:
                        System.out.print("First Name: ");
                        String fn = sc.nextLine();

                        System.out.print("Last Name: ");
                        String ln = sc.nextLine();

                        System.out.print("Email: ");
                        String email = sc.nextLine();

                        System.out.print("Batch: ");
                        String batch = sc.nextLine();

                        Student student = new Student(
                                IdGenerator.getNextStudentId(),
                                fn, ln, email, batch
                        );

                        studentService.addStudent(student);
                        System.out.println("Student added successfully");
                        break;

                    case 2:
                        System.out.println("\n--- Students List ---");
                        for (Student s : studentService.getAllStudents()) {
                            System.out.println(
                                    s.getId() + " | " +
                                    s.getDisplayName() + " | Batch: " +
                                    s.getBatch()
                            );
                        }
                        break;

                    case 3:
                        System.out.print("Course Name: ");
                        String cname = sc.nextLine();

                        System.out.print("Description: ");
                        String desc = sc.nextLine();

                        System.out.print("Duration (weeks): ");
                        int duration = Integer.parseInt(sc.nextLine());

                        Course course = new Course(
                                IdGenerator.getNextCourseId(),
                                cname, desc, duration
                        );

                        courseService.addCourse(course);
                        System.out.println(" Course added successfully");
                        break;

                    case 4:
                        System.out.println("\n--- Courses List ---");
                        for (Course c : courseService.getAllCourses()) {
                            System.out.println(
                                    c.getId() + " | " +
                                    c.getCourseName() +
                                    " | Active: " + c.isActive()
                            );
                        }
                        break;

                    case 5:
                        System.out.print("Student ID: ");
                        int sid = Integer.parseInt(sc.nextLine());

                        System.out.print("Course ID: ");
                        int cid = Integer.parseInt(sc.nextLine());

                        Enrollment enrollment = new Enrollment(
                                IdGenerator.getNextEnrollmentId(),
                                sid, cid
                        );

                        enrollmentService.enrollStudent(enrollment);
                        System.out.println(" Student enrolled successfully");
                        break;

                    case 6:
                        System.out.print("Student ID: ");
                        int stuId = Integer.parseInt(sc.nextLine());

                        System.out.println("\n--- Enrollments ---");
                        for (Enrollment e :
                                enrollmentService.getEnrollmentsByStudentId(stuId)) {

                            System.out.println(
                                    "Enrollment ID: " + e.getId() +
                                    " | Course ID: " + e.getCourseId() +
                                    " | Status: " + e.getStatus()
                            );
                        }
                        break;

                    case 7:
                        System.out.println("Exiting LearnTrack...");
                        System.exit(0);

                    default:
                        System.out.println(" Invalid option");
                }

            } catch (NumberFormatException e) {
                System.out.println(" Please enter a valid number");
            } catch (EntityNotFoundException e) {
                System.out.println(" " + e.getMessage());
            } catch (Exception e) {
                System.out.println(" Something went wrong");
            }
        }
    }
}
