package com.training.service.impl;

import com.training.dao.CourseDao;
import com.training.dao.impl.CourseDaoImpl;
import com.training.entity.Course;
import com.training.service.CourseService;
import com.training.util.InputUtil;

import java.util.List;

public class CourseServiceImpl implements CourseService {

    private CourseDao courseDao = new CourseDaoImpl();

    @Override
    public void createCourse() {
        String title = InputUtil.readString("Title: ");
        String description = InputUtil.readString("Description: ");
        double price = InputUtil.readDouble("Price: ");
        String level = InputUtil.readString("Level: ");
        String language = InputUtil.readString("Language: ");

        Course course = new Course();
        course.setTitle(title);
        course.setDescription(description);
        course.setPrice(price);
        course.setLevel(level);
        course.setLanguage(language);

        courseDao.save(course);
        System.out.println("Course created successfully!");
    }

    @Override
    public void updateCourse() {
        int id = InputUtil.readInt("Course ID to update: ");
        Course course = courseDao.findById(id);
        if (course == null) {
            System.out.println("Course not found!");
            return;
        }
        course.setTitle(InputUtil.readString("Title: "));
        course.setDescription(InputUtil.readString("Description: "));
        course.setPrice(InputUtil.readDouble("Price: "));
        course.setLevel(InputUtil.readString("Level: "));
        course.setLanguage(InputUtil.readString("Language: "));

        courseDao.update(course);
        System.out.println("Course updated successfully!");
    }

    @Override
    public void viewCourse() {
        int id = InputUtil.readInt("Course ID: ");
        Course course = courseDao.findById(id);
        if (course != null) {
            System.out.println("ID: " + course.getId());
            System.out.println("Title: " + course.getTitle());
            System.out.println("Description: " + course.getDescription());
            System.out.println("Price: " + course.getPrice());
            System.out.println("Level: " + course.getLevel());
            System.out.println("Language: " + course.getLanguage());
        } else {
            System.out.println("Course not found!");
        }
    }

    @Override
    public void listCourses() {
        List<Course> courses = courseDao.findAll();
        courses.forEach(
            c -> System.out.println(c.getId() + " : " + c.getTitle() + " (" + c.getLevel() + ")")
        );
    }

    @Override
    public void viewEnrolledStudents() {
        int id = InputUtil.readInt("Course ID: ");
        Course course = courseDao.findById(id);
        if (course != null && course.getUsers() != null) {
            System.out.println("Enrolled Students:");
            course.getUsers().forEach(
                u -> System.out.println(u.getId() + " : " + u.getEmail())
            );
        } else {
            System.out.println("No students enrolled or course not found!");
        }
    }

    @Override
    public void deleteCourse() {
        int id = InputUtil.readInt("Course ID to delete: ");
        Course course = courseDao.findById(id);
        if (course != null) {
            courseDao.delete(course);
            System.out.println("Course deleted successfully!");
        } else {
            System.out.println("Course not found!");
        }
    }
}
