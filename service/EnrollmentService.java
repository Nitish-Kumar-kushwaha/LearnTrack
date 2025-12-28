package service;

import entity.Enrollment;
import exception.EntityNotFoundException;

import java.util.ArrayList;

public class EnrollmentService {

    private ArrayList<Enrollment> enrollments = new ArrayList<>();

    public void enrollStudent(Enrollment enrollment) {
        enrollments.add(enrollment);
    }

    public ArrayList<Enrollment> getAllEnrollments() {
        return enrollments;
    }

    public ArrayList<Enrollment> getEnrollmentsByStudentId(int studentId) {
        ArrayList<Enrollment> result = new ArrayList<>();

        for (Enrollment e : enrollments) {
            if (e.getStudentId() == studentId) {
                result.add(e);
            }
        }

        return result;
    }

    public Enrollment findEnrollmentById(int id) {
        for (Enrollment e : enrollments) {
            if (e.getId() == id) {
                return e;
            }
        }
        throw new EntityNotFoundException("Enrollment with ID " + id + " not found");
    }

    public void markCompleted(int enrollmentId) {
        Enrollment enrollment = findEnrollmentById(enrollmentId);
        enrollment.setStatus("COMPLETED");
    }

    public void cancelEnrollment(int enrollmentId) {
        Enrollment enrollment = findEnrollmentById(enrollmentId);
        enrollment.setStatus("CANCELLED");
    }
}
