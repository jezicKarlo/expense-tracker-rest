package com.example.expensetrackerrest.repositories;

import com.example.expensetrackerrest.entities.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Integer> {

    List<Expense> findByCategory(Integer key);
    List<Expense> findByType(Integer key);
}
