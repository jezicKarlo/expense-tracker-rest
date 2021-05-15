package com.example.expensetrackerrest.services;

import com.example.expensetrackerrest.entities.Expense;
import lombok.experimental.UtilityClass;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class ServiceUtils {

    public List<Expense> findExpensesInRange(LocalDate sinceDate, LocalDate untilDate, List<Expense> expenses) {
        List<Expense> expensesInRange = new ArrayList<>();
        for (Expense expense : expenses) {
            if (sinceDate.isBefore(expense.getIssuedAt()) && untilDate.isAfter(expense.getIssuedAt())) {
                expensesInRange.add(expense);
            }
        }
        return expensesInRange;
    }

    public double sumExpenses(List<Expense> expenses) {
        double sum = 0;
        for (Expense expense : expenses) {
            sum += expense.getValue();
        }
        return sum;
    }
}
