package service;

import entity.Course;
import exception.EntityNotFoundException;

import java.util.ArrayList;

public class CourseService {

    private ArrayList<Course> courses = new ArrayList<>();

    public void addCourse(Course course) {
        courses.add(course);
    }

    public ArrayList<Course> getAllCourses() {
        return courses;
    }

    public Course findCourseById(int id) {
        for (Course c : courses) {
            if (c.getId() == id) {
                return c;
            }
        }
        throw new EntityNotFoundException("Course with ID " + id + " not found");
    }

    public void activateCourse(int id) {
        Course course = findCourseById(id);
        course.setActive(true);
    }

    public void deactivateCourse(int id) {
        Course course = findCourseById(id);
        course.setActive(false);
    }
}
