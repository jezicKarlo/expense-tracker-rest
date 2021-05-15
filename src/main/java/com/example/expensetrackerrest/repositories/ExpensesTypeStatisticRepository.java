package com.example.expensetrackerrest.repositories;

import com.example.expensetrackerrest.entities.ExpenseTypeStatistic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface ExpensesTypeStatisticRepository extends JpaRepository<ExpenseTypeStatistic, Integer> {

    ExpenseTypeStatistic findByExpenseTypeAndSinceAndUntil(Integer key, LocalDate since, LocalDate until);
}
