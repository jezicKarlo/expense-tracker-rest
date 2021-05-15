package com.example.expensetrackerrest.converters;

import com.example.expensetrackerrest.dto.ExpenseDTO;
import com.example.expensetrackerrest.entities.Expense;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class ExpenseConverter {

    public List<ExpenseDTO> fromExpenses(List<Expense> expenses) {
        List<ExpenseDTO> dtos = new ArrayList<>();
        for (Expense expense : expenses) {
            ExpenseDTO dto = fromExpense(expense);
            dtos.add(dto);
        }
        return dtos;
    }

    public ExpenseDTO fromExpense(Expense expense) {
        ExpenseDTO dto = new ExpenseDTO();
        dto.setName(expense.getName());
        dto.setCategory(expense.getCategory());
        dto.setSubcategory(expense.getSubcategory());
        dto.setValue(expense.getValue());
        dto.setType(expense.getType());
        dto.setId(expense.getPrimaryKey());
        dto.setIssuedAt(expense.getIssuedAt());
        return dto;
    }

    public Expense fromDto(ExpenseDTO dto) {
        Expense expense = new Expense();
        expense.setName(dto.getName());
        expense.setCategory(dto.getCategory());
        expense.setSubcategory(dto.getSubcategory());
        expense.setValue(dto.getValue());
        expense.setType(dto.getType());
        expense.setIssuedAt(dto.getIssuedAt());
        return expense;
    }
}
