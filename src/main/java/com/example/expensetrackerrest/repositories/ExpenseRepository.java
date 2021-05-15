package com.example.expensetrackerrest.repositories;

import com.example.expensetrackerrest.entities.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Integer> {
}
