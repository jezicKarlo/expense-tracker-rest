package com.example.expensetrackerrest.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class SubcategoryStatistic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subcategory_statistics_pk")
    private Integer primaryKey;
    @Column(name = "subcategory_fk")
    private Integer subcategory;
    private double value;
    private LocalDate since;
    private LocalDate until;
}
