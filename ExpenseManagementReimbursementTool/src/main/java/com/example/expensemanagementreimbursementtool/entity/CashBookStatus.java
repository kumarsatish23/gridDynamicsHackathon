package com.example.expensemanagementreimbursementtool.entity;

import com.example.expensemanagementreimbursementtool.constants.Status;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table
public class CashBookStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "cash_book_id_id", referencedColumnName = "id")
    private CashBook cashBookId;
    private Timestamp updateAt;
    private Status status;
}
