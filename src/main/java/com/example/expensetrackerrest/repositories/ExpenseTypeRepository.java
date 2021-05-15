package com.example.expensetrackerrest.repositories;

import com.example.expensetrackerrest.entities.ExpenseType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseTypeRepository extends JpaRepository<ExpenseType, Integer> {
}
