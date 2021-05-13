package com.example.expensetrackerrest.controllers;

import com.example.expensetrackerrest.dto.CategoryDTO;
import com.example.expensetrackerrest.entities.Category;
import com.example.expensetrackerrest.response.Response;
import com.example.expensetrackerrest.services.CategoryService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class CategoryController {

    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @GetMapping("categories")
    public ResponseEntity<Response> getCategories() {
        List<CategoryDTO> categories = service.fetchCategories();
        Response response = new Response();
        response.setData(categories);
        return ResponseEntity.ok(response);
    }

    @PostMapping("categories")
    public ResponseEntity<Response> postCategory(@RequestBody CategoryDTO category) {
        Integer key = service.insertCategory(category);
        Response response = new Response();
        response.setData(key);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("categories/{key}")
    public ResponseEntity<Response> deleteCategory(@PathVariable("key") Integer key) {
        CategoryDTO toDelete = service.fetchByKey(key);
        service.deleteCategory(key);
        Response response = new Response();
        response.setData(toDelete);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }
}
