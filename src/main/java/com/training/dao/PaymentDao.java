package com.training.dao;

import java.util.List;
import com.training.entity.Payment;

public interface PaymentDao {
    void save(Payment payment);
    void update(Payment payment);
    void delete(Payment payment);
    Payment findById(long id);
    List<Payment> findAll();
    List<Payment> findByUserId(int userId);
}
