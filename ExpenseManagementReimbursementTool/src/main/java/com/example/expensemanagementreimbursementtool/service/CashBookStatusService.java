package com.example.expensemanagementreimbursementtool.service;

import com.example.expensemanagementreimbursementtool.constants.Status;
import com.example.expensemanagementreimbursementtool.entity.CashBookStatus;
import com.example.expensemanagementreimbursementtool.repo.CashBookStatusRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Optional;
@Service
public class CashBookStatusService {
    @Autowired
    private CashBookStatusRepo cashBookStatusRepo;

    public CashBookStatus updateCashBookStatus(Long id, Status newStatus) {
        Optional<CashBookStatus> cashBookStatusOptional = cashBookStatusRepo.findById(id);
        if (cashBookStatusOptional.isPresent()) {
            CashBookStatus cashBookStatus = cashBookStatusOptional.get();
            cashBookStatus.setUpdateAt(new Timestamp(System.currentTimeMillis()));
            cashBookStatus.setStatus(newStatus);
            return cashBookStatusRepo.save(cashBookStatus);
        }
        return null;
    }
}
