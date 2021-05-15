package com.example.expensetrackerrest.repositories;

import com.example.expensetrackerrest.entities.SubcategoryStatistic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface SubcategoryStatisticRepository extends JpaRepository<SubcategoryStatistic, Integer> {

    SubcategoryStatistic findBySubcategoryAndSinceAndUntil(Integer key, LocalDate since, LocalDate until);
}
