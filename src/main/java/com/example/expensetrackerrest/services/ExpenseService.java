package com.example.expensetrackerrest.services;

import com.example.expensetrackerrest.converters.ExpenseConverter;
import com.example.expensetrackerrest.converters.ExpenseTypeConverter;
import com.example.expensetrackerrest.dto.ExpenseDTO;
import com.example.expensetrackerrest.entities.Expense;
import com.example.expensetrackerrest.repositories.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    private final ExpenseRepository repository;

    public ExpenseService(ExpenseRepository repository) {
        this.repository = repository;
    }

    public List<ExpenseDTO> fetchAll() {
        List<Expense> expenses = repository.findAll();
        return ExpenseConverter.fromExpenses(expenses);
    }

    public Integer insertExpense(ExpenseDTO dto) {
        Expense expense = ExpenseConverter.fromDto(dto);
        Expense save = repository.save(expense);
        return save.getPrimaryKey();
    }

    public ExpenseDTO fetchByKey(Integer key) {
        Expense expense = repository.getOne(key);
        return ExpenseConverter.fromExpense(expense);
    }

    public void deleteExpense(Integer key) {
        repository.deleteById(key);
    }

    public ExpenseDTO editExpense(Integer key, ExpenseDTO dto) {
        Expense toEdit = repository.getOne(key);
        toEdit.edit(ExpenseConverter.fromDto(dto));
        repository.save(toEdit);
        return ExpenseConverter.fromExpense(toEdit);
    }

    public List<Expense> fetchByCategory(Integer key) {
        return repository.findByCategory(key);
    }

    public List<Expense> fetchByExpenseType(Integer key) {
        return repository.findByType(key);
    }

}
