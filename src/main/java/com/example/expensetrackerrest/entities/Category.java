package com.example.expensetrackerrest.entities;

import com.example.expensetrackerrest.dto.CategoryDTO;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_pk")
    private Integer primaryKey;

    private String categoryName;

    public void editCategory(CategoryDTO edit) {
        this.categoryName = (edit.getName());
    }
}
