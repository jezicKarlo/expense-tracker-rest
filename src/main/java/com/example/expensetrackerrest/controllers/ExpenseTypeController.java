package com.example.expensetrackerrest.controllers;

import com.example.expensetrackerrest.dto.ExpenseTypeDTO;
import com.example.expensetrackerrest.response.Response;
import com.example.expensetrackerrest.services.ExpenseTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("expenseTypes")
public class ExpenseTypeController {

    private final ExpenseTypeService service;

    public ExpenseTypeController(ExpenseTypeService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Response> getExpenseTypes() {
        List<ExpenseTypeDTO> dtos = service.fetchExpenseTypes();
        return ResponseEntity.ok(Response.makeResponse("expenseTypes", dtos));
    }

    @PostMapping
    public ResponseEntity<Response> createExpenseType(@RequestBody ExpenseTypeDTO body) {
        Integer key = service.insertExpenseType(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(Response.makeResponse("expenseTypeId", key));
    }

    @DeleteMapping("{key}")
    public ResponseEntity<Response> deleteExpenseType(@PathVariable("key") Integer key) {
        ExpenseTypeDTO dto = service.fetchByKey(key);
        service.deleteExpenseType(key);
        return ResponseEntity.accepted().body(Response.makeResponse("expenseType", dto));
    }

    @PutMapping("{key}")
    public ResponseEntity<Response> editExpenseType(@PathVariable("key") Integer key,
                                                    @RequestBody ExpenseTypeDTO body) {
        ExpenseTypeDTO dto = service.editExpenseType(key, body);
        return ResponseEntity.ok(Response.makeResponse("expenseType", dto));
    }
}
