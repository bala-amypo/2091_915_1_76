package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import com.example.demo.model.PersonProfile;
import com.example.demo.service.PersonProfileService;

@RestController
@RequestMapping("/persons")
public class PersonProfileController {

    @Autowired
    PersonProfileService service;

    @PostMapping("/create")
    public PersonProfile createPerson(@RequestBody PersonProfile person) {
        return service.createPerson(person);
    }

    @GetMapping("/getAll")
    public List<PersonProfile> getAllPersons() {
        return service.getAllPersons();
    }

    @GetMapping("/get/{id}")
    public PersonProfile getPersonById(@PathVariable Long id) {
        return service.getPersonById(id);
    }

    @GetMapping("/reference/{refId}")
    public PersonProfile getByReferenceId(@Valid @PathVariable String refId) {
        return service.findByReferenceId(refId);
    }

    @PutMapping("/relationship/{id}")
    public PersonProfile updateRelationshipDeclared(
            @PathVariable Long id,
            @RequestParam boolean declared) {
        return service.updateRelationshipDeclared(id, declared);
    }
}
