package com.example.expensetrackerrest.dto;

import lombok.Data;

import java.util.List;

@Data
public class CategoryDTO {
    private String name;
    private List<SubCategory> subCategories;
    private List<ExpenseDTO> expenses;
}
