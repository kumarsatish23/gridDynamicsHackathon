package com.example.expensemanagementreimbursementtool.controller;

import com.example.expensemanagementreimbursementtool.entity.CashBook;
import com.example.expensemanagementreimbursementtool.service.CashBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cashbook")
public class CashBookController {

    @Autowired
    private CashBookService cashBookService;

    @PostMapping("/create")
    public ResponseEntity<CashBook> createCashBook(@RequestBody CashBook cashBook) {
        CashBook newCashBook = cashBookService.createCashBook(
                cashBook.getUser(),
                cashBook.getCashFlow(),
                cashBook.getPriority(),
                cashBook.getTitle(),
                cashBook.getPurpose(),
                cashBook.getMinBudget(),
                cashBook.getMaxBudget()
        );
        return ResponseEntity.ok(newCashBook);
    }

    // Endpoint to update an existing CashBook entry
    @PutMapping("/update/{id}")
    public ResponseEntity<CashBook> updateCashBook(
            @PathVariable Long id,
            @RequestBody CashBook cashBook) {
        CashBook updatedCashBook = cashBookService.updateCashBook(
                id,
                cashBook.getPriority(),
                cashBook.getTitle(),
                cashBook.getPurpose(),
                cashBook.getMinBudget(),
                cashBook.getMaxBudget()
        );
        if (updatedCashBook != null) {
            return ResponseEntity.ok(updatedCashBook);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/fetch/{userId}")
    public ResponseEntity<List<CashBook>> fetchCashBooks(@PathVariable Integer userId) {
        List<CashBook> cashBooks = cashBookService.fetchCashBooks(userId);
        return ResponseEntity.ok(cashBooks);
    }
}
