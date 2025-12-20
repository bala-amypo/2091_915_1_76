package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.ConflictFlag;
import com.example.demo.service.ConflictFlagService;

@RestController
@RequestMapping("/conflictFlags")
public class ConflictFlagController {

    @Autowired
    ConflictFlagService service;

    @PostMapping("/add")
    public ConflictFlag addFlag(@RequestBody ConflictFlag flag) {
        return service.addFlag(flag);
    }

    @GetMapping("/case/{caseId}")
    public List<ConflictFlag> getByCase(
            @PathVariable Long caseId) {
        return service.getFlagsByCase(caseId);
    }

    @GetMapping("/get/{id}")
    public ConflictFlag getById(@PathVariable Long id) {
        return service.getFlagById(id);
    }

    @GetMapping("/getAll")
    public List<ConflictFlag> getAll() {
        return service.getAllFlags();
    }
}
