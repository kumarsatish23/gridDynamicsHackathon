package com.example.expensemanagementreimbursementtool.entity;

import com.example.expensemanagementreimbursementtool.constants.UserType;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users") // Renamed to avoid conflict with reserved keyword
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private UserType access;
    private String password;
}

