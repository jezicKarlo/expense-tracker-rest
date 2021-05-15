package com.example.expensetrackerrest.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
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
    private LocalDate issuedAt;

    public void edit(Expense edit) {
        this.name = edit.getName();
        this.value = edit.getValue();
        this.category = edit.getCategory();
        this.subcategory = edit.getSubcategory();
        this.type = edit.type;
        this.issuedAt = edit.issuedAt;
    }
}
