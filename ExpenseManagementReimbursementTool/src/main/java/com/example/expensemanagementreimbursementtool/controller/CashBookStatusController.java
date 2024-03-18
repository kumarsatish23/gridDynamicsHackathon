package com.example.expensemanagementreimbursementtool.controller;

import com.example.expensemanagementreimbursementtool.constants.Status;
import com.example.expensemanagementreimbursementtool.entity.CashBookStatus;
import com.example.expensemanagementreimbursementtool.service.CashBookStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cashbookstatus")
public class CashBookStatusController {

    @Autowired
    private CashBookStatusService cashBookStatusService;

    @PutMapping("/{id}")
    public ResponseEntity<CashBookStatus> updateCashBookStatus(@PathVariable Long id, @RequestParam Status status) {
        CashBookStatus updatedCashBookStatus = cashBookStatusService.updateCashBookStatus(id, status);
        if (updatedCashBookStatus != null) {
            return ResponseEntity.ok(updatedCashBookStatus);
        }
        return ResponseEntity.notFound().build();
    }
}
