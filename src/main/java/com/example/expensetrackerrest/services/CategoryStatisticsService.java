package com.example.expensetrackerrest.services;

import com.example.expensetrackerrest.entities.CategoryStatistics;
import com.example.expensetrackerrest.entities.Expense;
import com.example.expensetrackerrest.repositories.CategoryStatisticsRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryStatisticsService {

    private final CategoryStatisticsRepository repository;
    private final ExpenseService expensesService;

    public CategoryStatisticsService(CategoryStatisticsRepository repository, ExpenseService expensesService) {
        this.repository = repository;
        this.expensesService = expensesService;
    }

    public CategoryStatistics generateStatistics(Integer key, String since, String until) {
        LocalDate sinceDate = LocalDate.parse(since);
        LocalDate untilDate = LocalDate.parse(until);

        CategoryStatistics exists = repository.findByCategoryAndSinceAndUntil(key, sinceDate, untilDate);
        CategoryStatistics statistics;
        if (exists != null) {
            statistics = exists;
        } else {
            statistics = new CategoryStatistics();
        }

        List<Expense> expenses = expensesService.fetchByCategory(key);
        List<Expense> expensesInRange = new ArrayList<>();
        for (Expense expense : expenses) {
            if (sinceDate.isBefore(expense.getIssuedAt()) && untilDate.isAfter(expense.getIssuedAt())) {
                expensesInRange.add(expense);
            }
        }
        statistics.setSince(LocalDate.parse(since));
        statistics.setUntil(LocalDate.parse(until));
        statistics.setCategory(key);
        double sum = 0;
        for (Expense expense : expensesInRange) {
            sum += expense.getValue();
        }
        statistics.setValue(sum);
        return repository.save(statistics);
    }
}
