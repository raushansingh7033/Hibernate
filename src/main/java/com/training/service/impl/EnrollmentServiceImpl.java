package com.training.service.impl;

import com.training.dao.CourseDao;
import com.training.dao.impl.CourseDaoImpl;
import com.training.dao.UserDao;
import com.training.dao.impl.UserDaoImpl;
import com.training.entity.Course;
import com.training.entity.User;
import com.training.service.EnrollmentService;
import com.training.util.InputUtil;

public class EnrollmentServiceImpl implements EnrollmentService {

    private UserDao userDao = new UserDaoImpl();
    private CourseDao courseDao = new CourseDaoImpl();

    @Override
    public void enrollStudent() {
        int userId = InputUtil.readInt("Student ID: ");
        int courseId = InputUtil.readInt("Course ID: ");

        User user = userDao.findById(userId);
        Course course = courseDao.findById(courseId);

        if (user != null && course != null) {
            user.enrollCourse(course);
            userDao.update(user);
            System.out.println("Enrollment successful!");
        } else {
            System.out.println("Invalid User or Course ID");
        }
    }

    @Override
    public void viewStudentEnrollments() {
        int userId = InputUtil.readInt("Student ID: ");
        User user = userDao.findById(userId);
        if (user != null && user.getCourses() != null) {
            System.out.println("Student is enrolled in:");
            user.getCourses().forEach(
                c -> System.out.println(c.getId() + " : " + c.getTitle())
            );
        } else {
            System.out.println("No enrollments found or invalid User ID");
        }
    }

    @Override
    public void viewCourseEnrollments() {
        int courseId = InputUtil.readInt("Course ID: ");
        Course course = courseDao.findById(courseId);
        if (course != null && course.getUsers() != null) {
            System.out.println("Course has enrolled students:");
            course.getUsers().forEach(
                u -> System.out.println(u.getId() + " : " + u.getEmail())
            );
        } else {
            System.out.println("No students enrolled or invalid Course ID");
        }
    }

    @Override
    public void removeEnrollment() {
        int userId = InputUtil.readInt("Student ID: ");
        int courseId = InputUtil.readInt("Course ID: ");

        User user = userDao.findById(userId);
        Course course = courseDao.findById(courseId);

        if (user != null && course != null) {
            user.removeCourse(course);
            userDao.update(user);
            System.out.println("Enrollment removed successfully!");
        } else {
            System.out.println("Invalid User or Course ID");
        }
    }
}
