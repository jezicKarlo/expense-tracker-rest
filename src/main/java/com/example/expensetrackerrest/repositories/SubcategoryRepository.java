package com.example.expensetrackerrest.repositories;

import com.example.expensetrackerrest.entities.Subcategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubcategoryRepository extends JpaRepository<Subcategory, Integer> {

    List<Subcategory> findByCategoryKey(Integer key);
}
