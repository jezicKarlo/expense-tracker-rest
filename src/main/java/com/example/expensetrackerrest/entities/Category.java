package com.example.expensetrackerrest.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_pk")
    private Integer primaryKey;

    @Column(name = "category_name")
    private String categoryName;

    public void editCategory(Category edit) {
        this.categoryName = (edit.getCategoryName());
    }
}
