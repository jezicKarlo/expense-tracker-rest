package com.example.expensetrackerrest.converters;

import com.example.expensetrackerrest.dto.ExpenseTypeDTO;
import com.example.expensetrackerrest.entities.ExpenseType;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class ExpenseTypeConverter {

    public List<ExpenseTypeDTO> fromExpenseTypes(List<ExpenseType> expenseTypes) {
        List<ExpenseTypeDTO> dtos = new ArrayList<>();
        for (ExpenseType et : expenseTypes) {
            ExpenseTypeDTO dto = fromExpenseType(et);
            dtos.add(dto);
        }
        return dtos;
    }

    public ExpenseTypeDTO fromExpenseType(ExpenseType expenseType) {
        ExpenseTypeDTO dto = new ExpenseTypeDTO();
        dto.setId(expenseType.getPrimaryKey());
        dto.setName(expenseType.getName());
        return dto;
    }

    public ExpenseType fromDto(ExpenseTypeDTO dto) {
        ExpenseType expenseType = new ExpenseType();
        expenseType.setName(dto.getName());
        return expenseType;
    }
}
