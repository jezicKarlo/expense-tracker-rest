package com.example.expensetrackerrest.controllers;

import com.example.expensetrackerrest.dto.CategoryDTO;
import com.example.expensetrackerrest.response.Response;
import com.example.expensetrackerrest.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categories")
public class CategoryController {

    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Response> getCategories() {
        List<CategoryDTO> categories = service.fetchCategories();
        Response response = Response.makeResponse("categories", categories);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Response> postCategory(@RequestBody CategoryDTO category) {
        Integer key = service.insertCategory(category);
        Response response = Response.makeResponse("categoryKey", key);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{key}")
    public ResponseEntity<Response> deleteCategory(@PathVariable("key") Integer key) {
        CategoryDTO toDelete = service.fetchByKey(key);
        service.deleteCategory(key);
        Response response = Response.makeResponse("deleted", toDelete);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }

    @PutMapping("/{key}")
    public ResponseEntity<Response> editCategory(@PathVariable("key") Integer key,
                                                 @RequestBody CategoryDTO body) {
        CategoryDTO dto = service.editCategory(key, body);
        Response response = Response.makeResponse("category", dto);
        return ResponseEntity.ok(response);
    }
}
