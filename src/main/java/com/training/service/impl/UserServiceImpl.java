package com.training.service.impl;

import com.training.dao.UserDao;
import com.training.dao.impl.UserDaoImpl;
import com.training.entity.User;
import com.training.entity.UserProfile;
import com.training.service.UserService;
import com.training.util.InputUtil;

import java.time.LocalDate;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public void createUser() {
        String email = InputUtil.readString("Email: ");
        String password = InputUtil.readString("Password: ");
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        userDao.save(user);
        System.out.println("User created successfully!");
    }

    @Override
    public void createOrUpdateProfile() {
        int userId = InputUtil.readInt("User ID: ");
        User user = userDao.findById(userId);
        if (user == null) {
            System.out.println("User not found!");
            return;
        }

        String name = InputUtil.readString("Full Name: ");
        char gender = InputUtil.readChar("Gender (M/F/O): ");
        long contact = InputUtil.readLong("Contact Number: ");
        double feePaid = InputUtil.readDouble("Fee Paid: ");
        String occupation = InputUtil.readString("Occupation: ");
        LocalDate dob = InputUtil.readDate("DOB (yyyy-MM-dd): ");

        UserProfile profile =
                user.getProfile() != null ? user.getProfile() : new UserProfile();

        profile.setName(name);
        profile.setGender(gender);
        profile.setContactNo(contact);
        profile.setFeePaid(feePaid);
        profile.setOccupation(occupation);
        profile.setDob(dob);

        user.setProfile(profile);
        userDao.update(user);
        System.out.println("Profile updated successfully!");
    }

    @Override
    public void viewUser() {
        int userId = InputUtil.readInt("User ID: ");
        User user = userDao.findById(userId);
        if (user != null) {
            System.out.println("User: " + user.getEmail());
            if (user.getProfile() != null) {
                System.out.println("Profile: " + user.getProfile().getName());
            }
        } else {
            System.out.println("User not found!");
        }
    }

    @Override
    public void listUsers() {
        userDao.findAll()
               .forEach(u ->
                   System.out.println(u.getId() + " : " + u.getEmail())
               );
    }

    @Override
    public void deleteUser() {
        int userId = InputUtil.readInt("User ID to delete: ");
        User user = userDao.findById(userId);
        if (user != null) {
            userDao.delete(user);
            System.out.println("User deleted successfully!");
        } else {
            System.out.println("User not found!");
        }
    }
}
