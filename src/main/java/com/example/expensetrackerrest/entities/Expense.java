package com.example.expensetrackerrest.entities;

import javax.persistence.*;

@Entity
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "expense_pk")
    private Integer primaryKey;

    private String name;
    private double value;
    private Integer category;
    private Integer subcategory;
    @Column(name = "expense_type")
    private Integer type;
}
