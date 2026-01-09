package com.training.menu;

import com.training.service.CourseService;
import com.training.service.impl.CourseServiceImpl;
import com.training.util.InputUtil;


public class CourseMenu {

    private static CourseService courseService = new CourseServiceImpl();

    public static void show() {
        while (true) {
            System.out.println("\n--- Course Menu ---");
            System.out.println("1. Create Course");
            System.out.println("2. Update Course");
            System.out.println("3. View Course");
            System.out.println("4. List All Courses");
            System.out.println("5. View Enrolled Students");
            System.out.println("6. Delete Course");
            System.out.println("0. Back");

            int choice = InputUtil.readInt("Enter choice: ");
            switch (choice) {
                case 1 -> courseService.createCourse();
                case 2 -> courseService.updateCourse();
                case 3 -> courseService.viewCourse();
                case 4 -> courseService.listCourses();
                case 5 -> courseService.viewEnrolledStudents();
                case 6 -> courseService.deleteCourse();
                case 0 -> { return; }
                default -> System.out.println("Invalid choice");
            }
        }
    }
   
}
