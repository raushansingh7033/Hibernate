package com.training.dao;

import java.util.List;
import com.training.entity.Course;

public interface CourseDao {
    void save(Course course);
    void update(Course course);
    void delete(Course course);
    Course findById(int id);
    List<Course> findAll();
}
