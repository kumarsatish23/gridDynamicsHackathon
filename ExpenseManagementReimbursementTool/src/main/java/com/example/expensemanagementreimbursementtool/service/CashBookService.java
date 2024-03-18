package com.example.expensemanagementreimbursementtool.service;

import com.example.expensemanagementreimbursementtool.constants.CashFlowType;
import com.example.expensemanagementreimbursementtool.constants.Priority;
import com.example.expensemanagementreimbursementtool.constants.Status;
import com.example.expensemanagementreimbursementtool.constants.UserType;
import com.example.expensemanagementreimbursementtool.entity.CashBook;
import com.example.expensemanagementreimbursementtool.entity.CashBookStatus;
import com.example.expensemanagementreimbursementtool.entity.User;
import com.example.expensemanagementreimbursementtool.repo.CashBookRepo;
import com.example.expensemanagementreimbursementtool.repo.CashBookStatusRepo;
import com.example.expensemanagementreimbursementtool.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CashBookService {
    @Autowired
    private CashBookRepo cashBookRepo;
    @Autowired
    private CashBookStatusRepo cashBookStatusRepo;
    @Autowired
    private UserRepo userRepo;

    // Create a new CashBook entry
    public CashBook createCashBook(User user, CashFlowType incomeOrExpense, Priority priority, String title, String purpose, Double minBudget, Double maxBudget) {
        CashBook newCashBook = new CashBook();
        newCashBook.setUser(user);
        newCashBook.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        newCashBook.setCashFlow(incomeOrExpense);
        newCashBook.setPriority(priority);
        newCashBook.setTitle(title);
        newCashBook.setPurpose(purpose);
        newCashBook.setMinBudget(minBudget);
        newCashBook.setMaxBudget(maxBudget);
        CashBook savedCashBook = cashBookRepo.save(newCashBook);

        CashBookStatus cashBookStatus = new CashBookStatus();
        cashBookStatus.setCashBookId(savedCashBook);
        cashBookStatus.setUpdateAt(new Timestamp(System.currentTimeMillis()));
        cashBookStatus.setStatus(Status.CREATED);
        cashBookStatusRepo.save(cashBookStatus);

        return savedCashBook;
    }

    public CashBook updateCashBook(Long id, Priority priority, String title, String purpose, Double minBudget, Double maxBudget) {
        Optional<CashBook> cashBookOptional = cashBookRepo.findById(id);
        if (cashBookOptional.isPresent()) {
            CashBook cashBook = cashBookOptional.get();
            cashBook.setPriority(priority);
            cashBook.setTitle(title);
            cashBook.setPurpose(purpose);
            cashBook.setMinBudget(minBudget);
            cashBook.setMaxBudget(maxBudget);
            return cashBookRepo.save(cashBook);
        }
        return null;
    }
    public List<CashBook> fetchCashBooks(Integer userId) {
        Optional<User> userOptional = userRepo.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (UserType.MANAGER.equals(user.getAccess())) {
                return cashBookRepo.findAll();
            } else if (UserType.TENANT.equals(user.getAccess())) {
                return cashBookRepo.findByUser(user);
            }
        }
        return Collections.emptyList();
    }
}
