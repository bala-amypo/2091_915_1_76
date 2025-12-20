package com.example.demo.service.impl;

import com.example.demo.exception.ApiException;
import com.example.demo.model.ConflictFlag;
import com.example.demo.repository.ConflictCaseRepository;
import com.example.demo.repository.ConflictFlagRepository;
import com.example.demo.service.ConflictFlagService;

import java.util.List;

@Service
public class ConflictFlagServiceImpl
        implements ConflictFlagService {

    private final ConflictFlagRepository repo;
    private final ConflictCaseRepository caseRepo;

    public ConflictFlagServiceImpl(
            ConflictFlagRepository repo,
            ConflictCaseRepository caseRepo) {
        this.repo = repo;
        this.caseRepo = caseRepo;
    }

    public ConflictFlag addFlag(ConflictFlag f) {
        if (caseRepo.findById(f.getCaseId()).isEmpty())
            throw new ApiException("case");
        return repo.save(f);
    }

    public List<ConflictFlag> getFlagsByCase(Long caseId) {
        return repo.findByCaseId(caseId);
    }

    public ConflictFlag getFlagById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ApiException("flag not found"));
    }

    public List<ConflictFlag> getAllFlags() {
        return repo.findAll();
    }
}
