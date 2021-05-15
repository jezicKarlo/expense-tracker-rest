package com.example.expensetrackerrest.controllers;

import com.example.expensetrackerrest.dto.CategoryDTO;
import com.example.expensetrackerrest.response.Response;
import com.example.expensetrackerrest.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CategoryController {

    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @GetMapping("categories")
    public ResponseEntity<Response> getCategories() {
        List<CategoryDTO> categories = service.fetchCategories();
        Response response = makeResponse("categories", categories);
        return ResponseEntity.ok(response);
    }

    @PostMapping("categories")
    public ResponseEntity<Response> postCategory(@RequestBody CategoryDTO category) {
        Integer key = service.insertCategory(category);
        Response response = makeResponse("categoryKey", key);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("categories/{key}")
    public ResponseEntity<Response> deleteCategory(@PathVariable("key") Integer key) {
        CategoryDTO toDelete = service.fetchByKey(key);
        service.deleteCategory(key);
        Response response = makeResponse("deleted", toDelete);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }

    @PutMapping("categories/{key}")
    public ResponseEntity<Response> editCategory(@PathVariable("key") Integer key,
                                                 @RequestBody CategoryDTO body) {
        CategoryDTO dto = service.editCategory(key, body);
        Response response = makeResponse("category", dto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }

    private Response makeResponse(String fieldName, Object data) {
        Map<String, Object> m = new HashMap<>();
        m.put(fieldName, data);
        Response response = new Response();
        response.setData(m);
        return response;
    }
}
