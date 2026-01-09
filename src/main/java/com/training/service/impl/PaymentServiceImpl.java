package com.training.service.impl;

import com.training.dao.PaymentDao;
import com.training.dao.impl.PaymentDaoImpl;
import com.training.dao.UserDao;
import com.training.dao.impl.UserDaoImpl;
import com.training.entity.Payment;
import com.training.entity.User;
import com.training.service.PaymentService;
import com.training.util.InputUtil;

import java.time.LocalDateTime;
import java.util.List;

public class PaymentServiceImpl implements PaymentService {

    private PaymentDao paymentDao = new PaymentDaoImpl();
    private UserDao userDao = new UserDaoImpl();

    @Override
    public void makePayment() {
        int userId = InputUtil.readInt("Student ID: ");
        double amount = InputUtil.readDouble("Amount: ");
        String method = InputUtil.readString("Payment Method: ");
        User user = userDao.findById(userId);

        if (user != null) {
            Payment payment = new Payment();
            payment.setAmount(amount);
            payment.setPaymentMethod(method);
            payment.setStatus("COMPLETED");
            payment.setCreatedAt(LocalDateTime.now());
            payment.setUser(user);

            paymentDao.save(payment);
            System.out.println("Payment successful!");
        } else {
            System.out.println("Invalid Student ID");
        }
    }

    @Override
    public void viewPaymentById() {
        long paymentId = InputUtil.readLong("Payment ID: ");
        Payment payment = paymentDao.findById(paymentId);
        if (payment != null) {
            System.out.println("Payment ID: " + payment.getId());
            System.out.println("Student: " + payment.getUser().getEmail());
            System.out.println("Amount: " + payment.getAmount());
            System.out.println("Method: " + payment.getPaymentMethod());
            System.out.println("Status: " + payment.getStatus());
            System.out.println("Created At: " + payment.getCreatedAt());
        } else {
            System.out.println("Payment not found!");
        }
    }

    @Override
    public void viewPaymentsOfStudent() {
        int userId = InputUtil.readInt("Student ID: ");
        List<Payment> payments = paymentDao.findByUserId(userId);
        if (payments != null && !payments.isEmpty()) {
            payments.forEach(
                p -> System.out.println(
                    "ID: " + p.getId() +
                    ", Amount: " + p.getAmount() +
                    ", Status: " + p.getStatus()
                )
            );
        } else {
            System.out.println("No payments found for this student");
        }
    }

    @Override
    public void updatePaymentStatus() {
        long paymentId = InputUtil.readLong("Payment ID: ");
        Payment payment = paymentDao.findById(paymentId);
        if (payment != null) {
            String newStatus = InputUtil.readString(
                "Enter new status (PENDING/COMPLETED/FAILED): "
            );
            payment.setStatus(newStatus);
            paymentDao.update(payment);
            System.out.println("Payment status updated!");
        } else {
            System.out.println("Payment not found!");
        }
    }

    @Override
    public void deletePayment() {
        long paymentId = InputUtil.readLong("Payment ID: ");
        Payment payment = paymentDao.findById(paymentId);
        if (payment != null) {
            paymentDao.delete(payment);
            System.out.println("Payment deleted!");
        } else {
            System.out.println("Payment not found!");
        }
    }
}
