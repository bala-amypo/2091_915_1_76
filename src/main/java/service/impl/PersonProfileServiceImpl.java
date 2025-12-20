package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ApiException;
import com.example.demo.model.PersonProfile;
import com.example.demo.repository.PersonProfileRepository;
import com.example.demo.service.PersonProfileService;

@Service
public class PersonProfileServiceImpl implements PersonProfileService {

    @Autowired
    PersonProfileRepository repository;

    @Override
    public PersonProfile createPerson(PersonProfile person) {

        Optional<PersonProfile> emailCheck =
                repository.findByEmail(person.getEmail());
        if (emailCheck.isPresent()) {
            throw new ApiException("email already exists");
        }

        Optional<PersonProfile> refCheck =
                repository.findByReferenceId(person.getReferenceId());
        if (refCheck.isPresent()) {
            throw new ApiException("reference already exists");
        }

        return repository.save(person);
    }

    @Override
    public PersonProfile getPersonById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ApiException("person not found"));
    }

    @Override
    public List<PersonProfile> getAllPersons() {
        return repository.findAll();
    }

    @Override
    public PersonProfile findByReferenceId(String referenceId) {
        return repository.findByReferenceId(referenceId)
                .orElseThrow(() -> new ApiException("person not found"));
    }

    @Override
    public PersonProfile updateRelationshipDeclared(Long id, boolean declared) {
        PersonProfile person = getPersonById(id);
        person.setRelationshipDeclared(declared);
        return repository.save(person);
    }
}
