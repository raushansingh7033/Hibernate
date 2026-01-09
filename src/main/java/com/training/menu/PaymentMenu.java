package com.training.menu;

import com.training.service.PaymentService;
import com.training.service.impl.PaymentServiceImpl;
import com.training.util.InputUtil;

public class PaymentMenu {
	private static PaymentService paymentService = new PaymentServiceImpl();

    
    public static void show() {
        while(true) {
            System.out.println("\n--- Payment Menu ---");
            System.out.println("1. Make Payment");
            System.out.println("2. View Payment by ID");
            System.out.println("3. View Payments of Student");
            System.out.println("4. Update Payment Status");
            System.out.println("5. Delete Payment");
            System.out.println("0. Back");

            int choice = InputUtil.readInt("Enter choice: ");
            switch(choice) {
                case 1 -> paymentService.makePayment();
                case 2 -> paymentService.viewPaymentById();
                case 3 -> paymentService.viewPaymentsOfStudent();
                case 4 -> paymentService.updatePaymentStatus();
                case 5 -> paymentService.deletePayment();
                case 0 -> { return; }
                default -> System.out.println("Invalid choice");
            }
        }
    }

    
}