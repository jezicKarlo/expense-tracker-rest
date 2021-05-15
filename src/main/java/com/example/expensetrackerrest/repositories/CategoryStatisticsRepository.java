package com.example.expensetrackerrest.repositories;

import com.example.expensetrackerrest.entities.CategoryStatistics;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface CategoryStatisticsRepository extends JpaRepository<CategoryStatistics, Integer> {
    CategoryStatistics findByCategoryAndSinceAndUntil(Integer category, LocalDate since, LocalDate until);
}
