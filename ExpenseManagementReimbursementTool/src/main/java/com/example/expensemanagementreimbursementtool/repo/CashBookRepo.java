package com.example.expensemanagementreimbursementtool.repo;

import com.example.expensemanagementreimbursementtool.entity.CashBook;
import com.example.expensemanagementreimbursementtool.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;

public interface CashBookRepo extends JpaRepository<CashBook, Serializable> {
    List<CashBook> findByUser(User user);
}
