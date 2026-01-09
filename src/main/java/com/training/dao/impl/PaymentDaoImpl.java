package com.training.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.training.config.HibernateUtil;
import com.training.dao.PaymentDao;
import com.training.entity.Payment;

public class PaymentDaoImpl implements PaymentDao {

    @Override
    public void save(Payment payment) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.persist(payment);
            tx.commit();
        } catch(Exception e) {
            if(tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void update(Payment payment) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
             session.merge(payment);
            tx.commit();
        } catch(Exception e) {
            if(tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Payment payment) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
             session.remove(payment);
            tx.commit();
        } catch(Exception e) {
            if(tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public Payment findById(long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.find(Payment.class, id);
        }
    }

    @Override
    public List<Payment> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Payment", Payment.class).list();
        }
    }

    @Override
    public List<Payment> findByUserId(int userId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Payment p where p.user.id = :uid", Payment.class)
                          .setParameter("uid", userId)
                          .list();
        }
    }
}
