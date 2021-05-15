package com.example.expensetrackerrest.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Restriction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restriction_pk")
    private Integer primaryKey;
    @Column(name = "restriction_name")
    private String name;
    @Column(name = "category_fk")
    private Integer category;
    @Column(name = "subcategory_fk")
    private Integer subcategory;
    @Column(name = "expense_type_fk")
    private Integer expenseType;
    private double value;

    public void edit(Restriction edit) {
        this.name = edit.getName();
        this.category = edit.getCategory();
        this.subcategory = edit.getSubcategory();
        this.expenseType = edit.getExpenseType();
        this.value = edit.getValue();
    }
}
