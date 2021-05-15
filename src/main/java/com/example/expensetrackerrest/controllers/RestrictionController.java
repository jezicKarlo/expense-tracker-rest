package com.example.expensetrackerrest.controllers;

import com.example.expensetrackerrest.entities.Restriction;
import com.example.expensetrackerrest.response.Response;
import com.example.expensetrackerrest.services.RestrictionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("restrictions")
public class RestrictionController {

    private final RestrictionService service;

    public RestrictionController(RestrictionService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Response> getRestrictions() {
        List<Restriction> restrictions = service.fetchRestrictions();
        return ResponseEntity.ok(Response.makeResponse("restrictions", restrictions));
    }

    @PostMapping
    public ResponseEntity<Response> createRestriction(@RequestBody Restriction restriction) {
        Integer key = service.insertRestriction(restriction);
        return ResponseEntity.status(HttpStatus.CREATED).body(Response.makeResponse("restrictionKey", key));
    }

    @DeleteMapping("{key}")
    public ResponseEntity<Response> deleteRestriction(@PathVariable("key") Integer key) {
        service.delete(key);
        return ResponseEntity.ok(Response.makeResponse("msg", "restriction deleted"));
    }

    @PutMapping("{key}")
    public ResponseEntity<Response> editRestriction(@PathVariable("key") Integer key,
                                                    @RequestBody Restriction body) {
        Restriction edited = service.edit(key, body);
        return ResponseEntity.ok(Response.makeResponse("restriction", edited));
    }
}
