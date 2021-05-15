package com.example.expensetrackerrest.services;

import com.example.expensetrackerrest.converters.SubcategoryConverter;
import com.example.expensetrackerrest.dto.CategoryDTO;
import com.example.expensetrackerrest.dto.SubcategoryDTO;
import com.example.expensetrackerrest.entities.Subcategory;
import com.example.expensetrackerrest.repositories.SubcategoryRepository;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubcategoryService {

    private final SubcategoryRepository repository;

    public SubcategoryService(SubcategoryRepository repository) {
        this.repository = repository;
    }

    public List<SubcategoryDTO> fetchAllSubcategories() {
        List<Subcategory> subcategories = repository.findAll();
        return SubcategoryConverter.fromSubcategories(subcategories);
    }

    public Integer insertSubcategory(SubcategoryDTO toInsert) {
        Subcategory subcategory = SubcategoryConverter.fromDto(toInsert);
        Subcategory saved = repository.save(subcategory);
        return saved.getPrimaryKey();
    }

    public void deleteSubcategory(Integer key) {
        repository.deleteById(key);
    }

    public SubcategoryDTO fetchByKey(Integer key) {
        Subcategory subcategory = repository.getOne(key);
        return SubcategoryConverter.fromSubcategory(subcategory);
    }

    public SubcategoryDTO editSubcategory(Integer key, SubcategoryDTO editReq) {
        Subcategory toEdit = repository.getOne(key);
        Subcategory edit = SubcategoryConverter.fromDto(editReq);
        toEdit.edit(edit);
        repository.save(toEdit);
        return SubcategoryConverter.fromSubcategory(toEdit);
    }
}
