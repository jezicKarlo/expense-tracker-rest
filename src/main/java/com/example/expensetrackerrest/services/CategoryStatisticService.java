package com.example.expensetrackerrest.services;

import com.example.expensetrackerrest.entities.CategoryStatistic;
import com.example.expensetrackerrest.entities.Expense;
import com.example.expensetrackerrest.repositories.CategoryStatisticRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CategoryStatisticService {

    private final CategoryStatisticRepository repository;
    private final ExpenseService expensesService;

    public CategoryStatisticService(CategoryStatisticRepository repository, ExpenseService expensesService) {
        this.repository = repository;
        this.expensesService = expensesService;
    }

    public CategoryStatistic generateStatistics(Integer key, String since, String until) {
        LocalDate sinceDate = LocalDate.parse(since);
        LocalDate untilDate = LocalDate.parse(until);

        CategoryStatistic exists = repository.findByCategoryAndSinceAndUntil(key, sinceDate, untilDate);
        CategoryStatistic statistics;
        if (exists != null) {
            statistics = exists;
        } else {
            statistics = new CategoryStatistic();
        }

        List<Expense> expenses = expensesService.fetchByCategory(key);
        List<Expense> expensesInRange = ServiceUtils.findExpensesInRange(sinceDate, untilDate, expenses);
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
