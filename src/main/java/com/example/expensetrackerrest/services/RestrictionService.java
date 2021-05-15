package com.example.expensetrackerrest.services;

import com.example.expensetrackerrest.entities.Restriction;
import com.example.expensetrackerrest.repositories.RestrictionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestrictionService {

    private final RestrictionRepository repository;

    public RestrictionService(RestrictionRepository repository) {
        this.repository = repository;
    }

    public List<Restriction> fetchRestrictions() {
        return repository.findAll();
    }

    public Integer insertRestriction(Restriction restriction) {
        Restriction saved = repository.save(restriction);
        return saved.getPrimaryKey();
    }

    public Restriction findByKey(Integer key) {
        return repository.getOne(key);
    }

    public void delete(Integer key) {
        repository.deleteById(key);
    }

    public Restriction edit(Integer key, Restriction edit) {
        Restriction toEdit = repository.getOne(key);
        toEdit.edit(edit);
        return repository.save(toEdit);
    }
}
