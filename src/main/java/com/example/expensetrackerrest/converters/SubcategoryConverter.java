package com.example.expensetrackerrest.converters;

import com.example.expensetrackerrest.dto.SubcategoryDTO;
import com.example.expensetrackerrest.entities.Subcategory;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class SubcategoryConverter {

    public List<SubcategoryDTO> fromSubcategories(List<Subcategory> subcategories) {
        List<SubcategoryDTO> dtos = new ArrayList<>();
        for (Subcategory subcategory : subcategories) {
            SubcategoryDTO dto = fromSubcategory(subcategory);
            dtos.add(dto);
        }
        return dtos;
    }

    public SubcategoryDTO fromSubcategory(Subcategory subcategory) {
        SubcategoryDTO dto = new SubcategoryDTO();
        dto.setId(subcategory.getPrimaryKey());
        dto.setName(subcategory.getName());
        dto.setCategoryId(subcategory.getCategoryKey());
        return dto;
    }

    public Subcategory fromDto(SubcategoryDTO dto) {
        Subcategory subcategory = new Subcategory();
        subcategory.setCategoryKey(dto.getCategoryId());
        subcategory.setName(dto.getName());
        return subcategory;
    }
}
