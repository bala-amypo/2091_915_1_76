package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.example.demo.model.ConflictFlag;


public interface ConflictFlagRepository extends JpaRepository<ConflictFlag, Long> {
    List<ConflictFlag> findByCaseId(Long id);
}
