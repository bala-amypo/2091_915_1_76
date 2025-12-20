package com.example.demo.service.impl;

import com.example.demo.exception.ApiException;
import com.example.demo.model.ConflictCase;
import com.example.demo.repository.ConflictCaseRepository;
import com.example.demo.repository.ConflictFlagRepository;
import com.example.demo.service.ConflictCaseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConflictCaseServiceImpl
        implements ConflictCaseService {

    private final ConflictCaseRepository repo;
    private final ConflictFlagRepository flagRepo;

    public ConflictCaseServiceImpl(
            ConflictCaseRepository repo,
            ConflictFlagRepository flagRepo) {
        this.repo = repo;
        this.flagRepo = flagRepo;
    }

    public ConflictCase createCase(ConflictCase c) {
        return repo.save(c);
    }

    public ConflictCase updateCaseStatus(Long id, String status) {
        ConflictCase c = getCaseById(id);
        c.setStatus(status);
        return repo.save(c);
    }

    public List<ConflictCase> getCasesByPerson(Long id) {
        return repo.findByPrimaryPersonIdOrSecondaryPersonId(id, id);
    }

    public ConflictCase getCaseById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ApiException("case not found"));
    }

    public List<ConflictCase> getAllCases() {
        return repo.findAll();
    }
}
