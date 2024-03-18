package com.example.expensemanagementreimbursementtool.service;

import com.example.expensemanagementreimbursementtool.constants.UserType;
import com.example.expensemanagementreimbursementtool.entity.CashBook;
import com.example.expensemanagementreimbursementtool.entity.User;
import com.example.expensemanagementreimbursementtool.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    public User registerUser(String firstName, String lastName, String email, String password, UserType userType) {
        User newUser = new User();
        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);
        newUser.setEmail(email);
        newUser.setAccess(UserType.MANAGER==userType?UserType.MANAGER:UserType.TENANT);
        newUser.setPassword(password);
        return userRepo.save(newUser);
    }

    public User loginUser(String email, String password) {
        User user = userRepo.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    public User updateUser(Long id, String firstName, String lastName, String email) {
        User user = userRepo.findById(id).orElse(null);
        if (user != null) {
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setEmail(email);
            return userRepo.save(user);
        }
        return null;
    }

}
