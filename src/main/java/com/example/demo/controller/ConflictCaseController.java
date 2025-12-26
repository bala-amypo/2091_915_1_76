package com.example.demo.controller;

import com.example.demo.model.ConflictCase;
import com.example.demo.service.ConflictCaseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conflict-cases")
public class ConflictCaseController {

    private final ConflictCaseService service;

    public ConflictCaseController(ConflictCaseService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ConflictCase create(@RequestBody ConflictCase conflictCase) {
        return service.createCase(conflictCase);
    }

    @PutMapping("/status/{id}")
    public ConflictCase updateStatus(
            @PathVariable Long id,
            @RequestParam String status) {
        return service.updateCaseStatus(id, status);
    }

    @GetMapping("/person/{personId}")
    public List<ConflictCase> getByPerson(@PathVariable Long personId) {
        return service.getCasesByPerson(personId);
    }

    @GetMapping("/all")
    public List<ConflictCase> getAll() {
        return service.getAllCases();
    }
}
