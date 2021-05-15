package com.example.expensetrackerrest.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Subcategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subcategory_pk")
    private Integer primaryKey;
    @Column(name = "category_fk")
    private Integer categoryKey;
    @Column(name = "subcategory_name")
    private String name;

    public void edit(Subcategory edit) {
        this.name = edit.getName();
        this.categoryKey = edit.getCategoryKey();
    }
}
