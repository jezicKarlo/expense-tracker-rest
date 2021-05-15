package com.example.expensetrackerrest.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class ExpenseTypeStatistic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "expenses_type_statistics_pk")
    private Integer primaryKey;
    @Column(name = "expenses_type_fk")
    private Integer expenseType;
    private double value;
    private LocalDate since;
    private LocalDate until;
}
