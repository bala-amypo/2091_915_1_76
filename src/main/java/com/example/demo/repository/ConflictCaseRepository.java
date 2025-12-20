package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.example.demo.model.ConflictCase;

public interface ConflictCaseRepository extends JpaRepository<ConflictCase, Long> {
    List<ConflictCase> findByPrimaryPersonIdOrSecondaryPersonId(Long a, Long b);
}
