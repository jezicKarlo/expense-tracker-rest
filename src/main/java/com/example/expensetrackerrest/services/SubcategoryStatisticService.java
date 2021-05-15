package com.example.expensetrackerrest.services;

import com.example.expensetrackerrest.entities.Expense;
import com.example.expensetrackerrest.entities.SubcategoryStatistic;
import com.example.expensetrackerrest.repositories.SubcategoryStatisticRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SubcategoryStatisticService {

    private final SubcategoryStatisticRepository repository;
    private final ExpenseService expenseService;

    public SubcategoryStatisticService(SubcategoryStatisticRepository repository, ExpenseService expenseService) {
        this.repository = repository;
        this.expenseService = expenseService;
    }

    public SubcategoryStatistic generateStatistic(Integer key, String since, String until) {
        LocalDate sinceDate = LocalDate.parse(since);
        LocalDate untilDate = LocalDate.parse(until);

        SubcategoryStatistic exists = repository.findBySubcategoryAndSinceAndUntil(key, sinceDate, untilDate);
        SubcategoryStatistic statistic;
        if (exists != null) {
            statistic = exists;
        } else {
            statistic = new SubcategoryStatistic();
        }

        List<Expense> expenses = expenseService.fetchBySubcategory(key);
        List<Expense> expensesInRange = ServiceUtils.findExpensesInRange(sinceDate, untilDate, expenses);
        double sum = ServiceUtils.sumExpenses(expensesInRange);
        statistic.setValue(sum);
        statistic.setSince(LocalDate.parse(since));
        statistic.setUntil(LocalDate.parse(until));
        statistic.setSubcategory(key);
        return repository.save(statistic);
    }
}
