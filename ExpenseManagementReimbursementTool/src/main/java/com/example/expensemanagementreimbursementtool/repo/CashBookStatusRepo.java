package com.example.expensemanagementreimbursementtool.repo;

import com.example.expensemanagementreimbursementtool.entity.CashBookStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface CashBookStatusRepo extends JpaRepository<CashBookStatus, Serializable> {
}
