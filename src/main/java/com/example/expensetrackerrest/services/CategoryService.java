package com.example.expensetrackerrest.services;

import com.example.expensetrackerrest.converters.CategoryConverter;
import com.example.expensetrackerrest.dto.CategoryDTO;
import com.example.expensetrackerrest.entities.Category;
import com.example.expensetrackerrest.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public List<CategoryDTO> fetchCategories() {
        List<Category> categories = repository.findAll();
        return CategoryConverter.fromCategories(categories);
    }

    public Integer insertCategory(CategoryDTO categoryDTO) {
        Category category = CategoryConverter.fromDto(categoryDTO);
        Category save = repository.save(category);
        return save.getPrimaryKey();
    }

    public CategoryDTO fetchByKey(Integer key) {
        Category category = repository.getOne(key);
        return CategoryConverter.fromCategory(category);
    }

    public void deleteCategory(Integer key) {
        repository.deleteById(key);
    }

    public CategoryDTO editCategory(Integer key, CategoryDTO editReq) {
        Category toEdit = repository.getOne(key);
        Category edit = CategoryConverter.fromDto(editReq);
        toEdit.editCategory(edit);
        repository.save(toEdit);
        return CategoryConverter.fromCategory(toEdit);
    }
}
