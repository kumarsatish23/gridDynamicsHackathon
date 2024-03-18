package com.example.expensemanagementreimbursementtool.entity;

import com.example.expensemanagementreimbursementtool.constants.CashFlowType;
import com.example.expensemanagementreimbursementtool.constants.Priority;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table
public class CashBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private User user;
    private Timestamp createdAt;
    private CashFlowType cashFlow;
    private Priority priority;
    private String title;
    private String purpose;
    private Double minBudget;
    private Double maxBudget;
}
