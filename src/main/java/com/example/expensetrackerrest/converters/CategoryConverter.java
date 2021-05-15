package com.example.expensetrackerrest.converters;

import com.example.expensetrackerrest.dto.CategoryDTO;
import com.example.expensetrackerrest.entities.Category;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class CategoryConverter {

    public List<CategoryDTO> fromCategories(List<Category> categories) {
        List<CategoryDTO> dtos = new ArrayList<>();
        for (Category category : categories) {
            CategoryDTO categoryDTO = fromCategory(category);
            dtos.add(categoryDTO);
        }
        return dtos;
    }

    public CategoryDTO fromCategory(Category category) {
        CategoryDTO dto = new CategoryDTO();
        dto.setName(category.getCategoryName());
        dto.setId(category.getPrimaryKey());
        return dto;
    }

    public Category fromDto(CategoryDTO dto) {
        Category category = new Category();
        category.setCategoryName(dto.getName());
        return category;
    }
}
