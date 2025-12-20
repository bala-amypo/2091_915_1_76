package com.example.demo.service.impl;

import com.example.demo.exception.ApiException;
import com.example.demo.model.RelationshipDeclaration;
import com.example.demo.repository.PersonProfileRepository;
import com.example.demo.repository.RelationshipDeclarationRepository;
import com.example.demo.service.RelationshipDeclarationService;

import java.util.ArrayList;
import java.util.List;

public class RelationshipDeclarationServiceImpl
        implements RelationshipDeclarationService {

    private final RelationshipDeclarationRepository repo;
    private final PersonProfileRepository personRepo;

    public RelationshipDeclarationServiceImpl(
            RelationshipDeclarationRepository repo,
            PersonProfileRepository personRepo) {
        this.repo = repo;
        this.personRepo = personRepo;
    }

    public RelationshipDeclaration declareRelationship(RelationshipDeclaration d) {
        if (personRepo.findById(d.getPersonId()).isEmpty())
            throw new ApiException("person not found");
        return repo.save(d);
    }

    public List<RelationshipDeclaration> getDeclarationsByPerson(Long personId) {
        List<RelationshipDeclaration> all = repo.findAll();
        List<RelationshipDeclaration> result = new ArrayList<>();
        for (RelationshipDeclaration d : all) {
            if (d.getPersonId().equals(personId))
                result.add(d);
        }
        return result;
    }

    public RelationshipDeclaration verifyDeclaration(Long id, boolean verified) {
        RelationshipDeclaration d = repo.findById(id)
                .orElseThrow(() -> new ApiException("person"));
        d.setIsVerified(verified);
        return repo.save(d);
    }

    public List<RelationshipDeclaration> getAllDeclarations() {
        return repo.findAll();
    }
}
