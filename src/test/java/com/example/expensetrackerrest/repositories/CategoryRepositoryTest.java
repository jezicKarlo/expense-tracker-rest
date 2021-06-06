package com.example.expensetrackerrest.repositories;

import com.example.expensetrackerrest.entities.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository repository;

    @Test
    public void createTest() {
        Optional<Category> byId = repository.findById(1);
        assertTrue(byId.isEmpty());

        Category category = new Category();
        category.setCategoryName("category");
        repository.save(category);

        byId = repository.findById(1);

        assertFalse(byId.isEmpty());
    }
}