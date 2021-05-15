package com.example.expensetrackerrest.controllers;

import com.example.expensetrackerrest.dto.ExpenseDTO;
import com.example.expensetrackerrest.response.Response;
import com.example.expensetrackerrest.services.ExpenseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("expenses")
public class ExpenseController {

    private final ExpenseService service;

    public ExpenseController(ExpenseService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Response> getExpenses() {
        List<ExpenseDTO> dtos = service.fetchAll();
        return ResponseEntity.ok(Response.makeResponse("expenses", dtos));
    }

    @PostMapping
    public ResponseEntity<Response> createExpense(@RequestBody ExpenseDTO body) {
        Integer key = service.insertExpense(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(Response.makeResponse("expenseKey", key));
    }

    @DeleteMapping("{key}")
    public ResponseEntity<Response> deleteExpense(@PathVariable("key") Integer key) {
        ExpenseDTO deleted = service.fetchByKey(key);
        service.deleteExpense(key);
        return ResponseEntity.accepted().body(Response.makeResponse("expense", deleted));
    }

    @PutMapping("{key}")
    public ResponseEntity<Response> editExpense(@PathVariable("key") Integer key,
                                                @RequestBody ExpenseDTO body) {
        ExpenseDTO dto = service.editExpense(key, body);
        return ResponseEntity.ok(Response.makeResponse("expense", dto));
    }
}
