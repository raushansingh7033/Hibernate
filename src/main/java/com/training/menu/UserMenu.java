package com.training.menu;

import com.training.service.UserService;
import com.training.service.impl.UserServiceImpl;
import com.training.util.InputUtil;


public class UserMenu {

    private static UserService userService = new UserServiceImpl();

    public static void show() {
        while (true) {
            System.out.println("\n--- User Menu ---");
            System.out.println("1. Create User");
            System.out.println("2. Create / Update User Profile");
            System.out.println("3. View User (Basic / Full Profile)");
            System.out.println("4. List All Users");
            System.out.println("5. Delete User");
            System.out.println("0. Back");

            int choice = InputUtil.readInt("Enter choice: ");

            switch (choice) {
                case 1 -> userService.createUser();
                case 2 -> userService.createOrUpdateProfile();
                case 3 -> userService.viewUser();
                case 4 -> userService.listUsers();
                case 5 -> userService.deleteUser();
                case 0 -> { return; }
                default -> System.out.println("Invalid choice");
            }
        }
    }

   
}
