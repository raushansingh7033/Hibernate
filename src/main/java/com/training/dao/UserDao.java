package com.training.dao;

import java.util.List;
import com.training.entity.User;

public interface UserDao {
    void save(User user);
    void update(User user);
    void delete(User user);
    User findById(int id);
    List<User> findAll();
}
