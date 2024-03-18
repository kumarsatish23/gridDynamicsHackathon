package com.example.expensemanagementreimbursementtool.repo;

import com.example.expensemanagementreimbursementtool.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface UserRepo extends JpaRepository<User, Serializable> {
    User findByEmail(String email);
}
