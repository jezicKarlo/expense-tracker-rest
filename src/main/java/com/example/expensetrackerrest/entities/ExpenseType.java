package com.example.expensetrackerrest.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class ExpenseType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "expense_type_pk")
    private Integer primaryKey;
    @Column(name = "expense_type_name")
    private String name;

    public void edit(ExpenseType edit) {
        this.name = edit.getName();
    }
}
