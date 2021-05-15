package com.example.expensetrackerrest.services;

import com.example.expensetrackerrest.converters.ExpenseTypeConverter;
import com.example.expensetrackerrest.dto.ExpenseTypeDTO;
import com.example.expensetrackerrest.entities.ExpenseType;
import com.example.expensetrackerrest.repositories.ExpenseTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseTypeService {

    private final ExpenseTypeRepository repository;

    public ExpenseTypeService(ExpenseTypeRepository repository) {
        this.repository = repository;
    }

    public List<ExpenseTypeDTO> fetchExpenseTypes() {
        List<ExpenseType> expenseTypes = repository.findAll();
        return ExpenseTypeConverter.fromExpenseTypes(expenseTypes);
    }

    public Integer insertExpenseType(ExpenseTypeDTO dto) {
        ExpenseType create = ExpenseTypeConverter.fromDto(dto);
        ExpenseType save = repository.save(create);
        return save.getPrimaryKey();
    }

    public ExpenseTypeDTO fetchByKey(Integer key) {
        ExpenseType expenseType = repository.getOne(key);
        return ExpenseTypeConverter.fromExpenseType(expenseType);
    }

    public void deleteExpenseType(Integer key) {
        repository.deleteById(key);
    }

    public ExpenseTypeDTO editExpenseType(Integer key, ExpenseTypeDTO requestBody) {
        ExpenseType edit = ExpenseTypeConverter.fromDto(requestBody);
        ExpenseType toEdit = repository.getOne(key);
        toEdit.edit(edit);
        repository.save(toEdit);
        return ExpenseTypeConverter.fromExpenseType(toEdit);
    }
}
