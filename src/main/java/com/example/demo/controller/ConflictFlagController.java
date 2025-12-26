package com.example.demo.controller;

import com.example.demo.model.ConflictFlag;
import com.example.demo.service.ConflictFlagService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conflict-flags")
public class ConflictFlagController {

    private final ConflictFlagService service;

    public ConflictFlagController(ConflictFlagService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public ConflictFlag add(@RequestBody ConflictFlag flag) {
        return service.addFlag(flag);
    }

    @GetMapping("/case/{caseId}")
    public List<ConflictFlag> getByCase(@PathVariable Long caseId) {
        return service.getFlagsByCase(caseId);
    }

    @GetMapping("/get/{id}")
    public ConflictFlag getById(@PathVariable Long id) {
        return service.getFlagById(id);
    }

    @GetMapping("/all")
    public List<ConflictFlag> getAll() {
        return service.getAllFlags();
    }
}
