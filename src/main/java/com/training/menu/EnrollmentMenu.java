package com.training.menu;

import com.training.service.EnrollmentService;
import com.training.service.impl.EnrollmentServiceImpl;
import com.training.util.InputUtil;

public class EnrollmentMenu {

    private static EnrollmentService enrollmentService = new EnrollmentServiceImpl();

    public static void show() {
        while (true) {
            System.out.println("\n--- Enrollment Menu ---");
            System.out.println("1. Enroll Student in Course");
            System.out.println("2. View Student Enrollments");
            System.out.println("3. View Course Enrollments");
            System.out.println("4. Remove Enrollment");
            System.out.println("0. Back");

            int choice = InputUtil.readInt("Enter choice: ");
            switch (choice) {
                case 1 -> enrollmentService.enrollStudent();
                case 2 -> enrollmentService.viewStudentEnrollments();
                case 3 -> enrollmentService.viewCourseEnrollments();
                case 4 -> enrollmentService.removeEnrollment();
                case 0 -> { return; }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    
}
