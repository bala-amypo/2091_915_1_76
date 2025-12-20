package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.RelationshipDeclaration;
import com.example.demo.service.RelationshipDeclarationService;

@RestController
@RequestMapping("/relationships")
public class RelationshipDeclarationController {

    @Autowired
    RelationshipDeclarationService service;

    @PostMapping("/declare")
    public RelationshipDeclaration declare(
            @RequestBody RelationshipDeclaration declaration) {
        return service.declareRelationship(declaration);
    }

    @GetMapping("/person/{personId}")
    public List<RelationshipDeclaration> getByPerson(
            @PathVariable Long personId) {
        return service.getDeclarationsByPerson(personId);
    }

    @PutMapping("/verify/{id}")
    public RelationshipDeclaration verify(
            @PathVariable Long id,
            @RequestParam boolean verified) {
        return service.verifyDeclaration(id, verified);
    }

    @GetMapping("/getAll")
    public List<RelationshipDeclaration> getAll() {
        return service.getAllDeclarations();
    }
}
