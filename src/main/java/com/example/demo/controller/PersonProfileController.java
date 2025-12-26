package com.example.demo.controller;

import com.example.demo.model.PersonProfile;
import com.example.demo.service.PersonProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persons")
public class PersonProfileController {

    private final PersonProfileService service;

    public PersonProfileController(PersonProfileService service) {
        this.service = service;
    }

    // ✅ tests call: controller.create(person)
    public ResponseEntity<PersonProfile> create(PersonProfile person) {
        PersonProfile saved = service.createPerson(person);
        return ResponseEntity.ok(saved);
    }

    // optional REST endpoint (won’t break tests)
    @PostMapping("/create")
    public PersonProfile createPerson(@RequestBody PersonProfile person) {
        return service.createPerson(person);
    }

    @GetMapping("/getAll")
    public java.util.List<PersonProfile> getAllPersons() {
        return service.getAllPersons();
    }

    @GetMapping("/get/{id}")
    public PersonProfile getPersonById(@PathVariable Long id) {
        return service.getPersonById(id);
    }

    // ✅ tests call: controller.lookup("REF")
    public ResponseEntity<PersonProfile> lookup(String refId) {
        return service.findByReferenceId(refId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/relationship/{id}")
    public PersonProfile updateRelationshipDeclared(
            @PathVariable Long id,
            @RequestParam boolean declared) {
        return service.updateRelationshipDeclared(id, declared);
    }
}
