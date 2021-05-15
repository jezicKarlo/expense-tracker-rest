package com.example.expensetrackerrest.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.ZonedDateTime;

@Data
public class ExpenseDTO {

    private Integer id;
    private String name;
    private double value;
    private Integer category;
    private Integer subcategory;
    private Integer type;
    private LocalDate issuedAt;
}
