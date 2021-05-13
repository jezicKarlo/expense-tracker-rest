package com.example.expensetrackerrest.repositories;

import com.example.expensetrackerrest.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    List<Category> getAllBy();
}
