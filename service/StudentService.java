package service;

import entity.Student;
import exception.EntityNotFoundException;

import java.util.ArrayList;

public class StudentService {

    private ArrayList<Student> students = new ArrayList<>();


    public void addStudent(Student student) {
        students.add(student);
    }

    
    public ArrayList<Student> getAllStudents() {
        return students;
    }


    public Student findStudentById(int id) {
        for (Student s : students) {
            if (s.getId() == id) {
                return s;
            }
        }
        throw new EntityNotFoundException("Student with ID " + id + " not found");
    }

    public void deactivateStudent(int id) {
        Student student = findStudentById(id);
        student.setActive(false);
    }
}
