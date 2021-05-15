package com.example.expensetrackerrest.entities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@Data
public class CategoryStatistics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_statistics")
    private Integer primaryKey;
    @Column(name = "category_fk")
    private Integer category;
    private double value;
    private LocalDate since;
    private LocalDate until;
}
