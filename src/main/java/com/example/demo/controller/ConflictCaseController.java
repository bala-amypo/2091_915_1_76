package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.ConflictCase;
import com.example.demo.service.ConflictCaseService;

@RestController
@RequestMapping("/conflictCases")
public class ConflictCaseController {

    @Autowired
    ConflictCaseService service;

    @PostMapping("/create")
    public ConflictCase createCase(@RequestBody ConflictCase conflictCase) {
        return service.createCase(conflictCase);
    }

    @PutMapping("/status/{id}")
    public ConflictCase updateStatus(
            @PathVariable Long id,
            @RequestParam String status) {
        return service.updateCaseStatus(id, status);
    }

    @GetMapping("/person/{personId}")
    public List<ConflictCase> getByPerson(
            @PathVariable Long personId) {
        return service.getCasesByPerson(personId);
    }

    @GetMapping("/get/{id}")
    public ConflictCase getById(@PathVariable Long id) {
        return service.getCaseById(id);
    }

    @GetMapping("/getAll")
    public List<ConflictCase> getAll() {
        return service.getAllCases();
    }
}
