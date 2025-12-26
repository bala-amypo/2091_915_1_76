package com.example.demo.controller;

import com.example.demo.model.RelationshipDeclaration;
import com.example.demo.service.RelationshipDeclarationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/relationships")
public class RelationshipDeclarationController {

    private final RelationshipDeclarationService service;

    public RelationshipDeclarationController(RelationshipDeclarationService service) {
        this.service = service;
    }

    @PostMapping("/declare")
    public RelationshipDeclaration declare(@RequestBody RelationshipDeclaration declaration) {
        return service.declareRelationship(declaration);
    }

    @PutMapping("/verify/{id}")
    public RelationshipDeclaration verify(
            @PathVariable Long id,
            @RequestParam boolean verified) {
        return service.verifyDeclaration(id, verified);
    }

    @GetMapping("/person/{personId}")
    public List<RelationshipDeclaration> getByPerson(@PathVariable Long personId) {
        return service.getDeclarationsByPerson(personId);
    }

    @GetMapping("/all")
    public List<RelationshipDeclaration> getAll() {
        return service.getAllDeclarations();
    }
}
