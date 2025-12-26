package com.example.demo.service.impl;

import com.example.demo.exception.ApiException;
import com.example.demo.model.PersonProfile;
import com.example.demo.model.RelationshipDeclaration;
import com.example.demo.repository.PersonProfileRepository;
import com.example.demo.repository.RelationshipDeclarationRepository;
import com.example.demo.service.RelationshipDeclarationService;

import java.util.List;

@Service
public class RelationshipDeclarationServiceImpl implements RelationshipDeclarationService {

    private final RelationshipDeclarationRepository relationshipRepo;
    private final PersonProfileRepository personRepo;

    public RelationshipDeclarationServiceImpl(
            RelationshipDeclarationRepository relationshipRepo,
            PersonProfileRepository personRepo) {

        this.relationshipRepo = relationshipRepo;
        this.personRepo = personRepo;
    }

    @Override
    public RelationshipDeclaration declareRelationship(RelationshipDeclaration declaration) {

        PersonProfile person = personRepo.findById(declaration.getPersonId())
                .orElseThrow(() -> new ApiException("person"));

        person.setRelationshipDeclared(true);
        personRepo.save(person);

        return relationshipRepo.save(declaration);
    }

    @Override
    public RelationshipDeclaration verifyDeclaration(Long declarationId, boolean verified) {

        RelationshipDeclaration declaration =
                relationshipRepo.findById(declarationId)
                        .orElseThrow(() -> new ApiException("declaration"));

        declaration.setIsVerified(verified);
        return relationshipRepo.save(declaration);
    }

    @Override
    public List<RelationshipDeclaration> getDeclarationsByPerson(Long personId) {
        return relationshipRepo.findByPersonId(personId);
    }

    @Override
    public List<RelationshipDeclaration> getAllDeclarations() {
        return relationshipRepo.findAll();
    }
}
