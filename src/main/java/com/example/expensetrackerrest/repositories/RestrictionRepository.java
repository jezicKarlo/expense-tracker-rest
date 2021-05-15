package com.example.expensetrackerrest.repositories;

import com.example.expensetrackerrest.entities.Restriction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestrictionRepository extends JpaRepository<Restriction, Integer> {
}
