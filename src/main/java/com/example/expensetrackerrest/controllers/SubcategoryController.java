package com.example.expensetrackerrest.controllers;

import com.example.expensetrackerrest.dto.SubcategoryDTO;
import com.example.expensetrackerrest.response.Response;
import com.example.expensetrackerrest.services.SubcategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("subcategories")
public class SubcategoryController {

    private final SubcategoryService service;

    public SubcategoryController(SubcategoryService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Response> getSubcategories() {
        List<SubcategoryDTO> dtos = service.fetchAllSubcategories();
        Response response = Response.makeResponse("subcategories", dtos);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Response> createSubcategory(@RequestBody SubcategoryDTO body) {
        Integer key = service.insertSubcategory(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(Response.makeResponse("subcategoryKey", key));
    }

    @DeleteMapping("{key}")
    public ResponseEntity<Response> deleteSubcategory(@PathVariable("key") Integer key) {
        SubcategoryDTO dto = service.fetchByKey(key);
        service.deleteSubcategory(key);
        return ResponseEntity.accepted().body(Response.makeResponse("subcategory", dto));
    }

    @PutMapping("{key}")
    public ResponseEntity<Response> editSubcategory(@PathVariable("key") Integer key,
                                                    @RequestBody SubcategoryDTO body) {
        SubcategoryDTO dto = service.editSubcategory(key, body);
        Response subcategory = Response.makeResponse("subcategory", dto);
        return ResponseEntity.ok(subcategory);

    }
}

