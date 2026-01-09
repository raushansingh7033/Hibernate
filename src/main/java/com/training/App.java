package com.training;

import com.training.menu.UserMenu;
import com.training.menu.CourseMenu;
import com.training.menu.EnrollmentMenu;
import com.training.menu.PaymentMenu;
import com.training.util.InputUtil;

public class App {
    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== LMS MAIN MENU =====");
            System.out.println("1. User Management");
            System.out.println("2. Course Management");
            System.out.println("3. Enrollment");
            System.out.println("4. Payment");
            System.out.println("0. Exit");

            int choice = InputUtil.readInt("Enter choice: ");

            switch (choice) {
                case 1 -> UserMenu.show();
                case 2 -> CourseMenu.show();
                case 3 -> EnrollmentMenu.show();
                case 4 -> PaymentMenu.show();
                case 0 -> {
                    System.out.println("Exiting LMS. Bye!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}
