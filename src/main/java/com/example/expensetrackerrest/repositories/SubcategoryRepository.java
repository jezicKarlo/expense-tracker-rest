package com.example.expensetrackerrest.repositories;

import com.example.expensetrackerrest.entities.Subcategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubcategoryRepository extends JpaRepository<Subcategory, Integer> {
}
