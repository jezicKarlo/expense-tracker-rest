package com.example.expensetrackerrest.repositories;

import com.example.expensetrackerrest.entities.CategoryStatistic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface CategoryStatisticRepository extends JpaRepository<CategoryStatistic, Integer> {
    CategoryStatistic findByCategoryAndSinceAndUntil(Integer category, LocalDate since, LocalDate until);
}
