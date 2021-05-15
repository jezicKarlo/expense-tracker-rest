package com.example.expensetrackerrest.services;

import com.example.expensetrackerrest.entities.Expense;
import com.example.expensetrackerrest.entities.ExpenseTypeStatistic;
import com.example.expensetrackerrest.repositories.ExpensesTypeStatisticRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExpenseTypeStatisticService {

    private final ExpensesTypeStatisticRepository repository;
    private final ExpenseService expenseService;

    public ExpenseTypeStatisticService(ExpensesTypeStatisticRepository repository, ExpenseService expenseService) {
        this.repository = repository;
        this.expenseService = expenseService;
    }

    public ExpenseTypeStatistic generateStatistic(Integer key, String since, String until) {
        LocalDate sinceDate = LocalDate.parse(since);
        LocalDate untilDate = LocalDate.parse(until);

        ExpenseTypeStatistic exists = repository.findByExpenseTypeAndSinceAndUntil(key, sinceDate, untilDate);
        ExpenseTypeStatistic statistic;
        if (exists != null) {
            statistic = exists;
        } else {
            statistic = new ExpenseTypeStatistic();
        }
        List<Expense> expenses = expenseService.fetchByExpenseType(key);
        List<Expense> expensesInRange = ServiceUtils.findExpensesInRange(sinceDate, untilDate, expenses);
        double sum = 0;
        for (Expense expense : expensesInRange) {
            sum += expense.getValue();
        }
        statistic.setValue(sum);
        statistic.setSince(LocalDate.parse(since));
        statistic.setUntil(LocalDate.parse(until));
        statistic.setExpenseType(key);
        return repository.save(statistic);
    }
}
