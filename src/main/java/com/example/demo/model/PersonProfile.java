package com.example.demo.model;

import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
@Entity
@Table(
    name = "person_profile",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "email"),
        @UniqueConstraint(columnNames = "reference_id")
    }
)
public class PersonProfile {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String personType;
    private String referenceId;
    @NotBlank(message = "Full name is required")
    private String fullName; 
    @Email(message = "Email should be valid")  
    private String email;
    private String department;
    @PrePersist
    public void prePersist() {
    if (relationshipDeclared == null) {
        relationshipDeclared = false;
    }
}
    private Boolean relationshipDeclared;
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getPersonType() {
        return personType;
    }
    public void setPersonType(String personType) {
        this.personType = personType;
    }
    public String getReferenceId() {
        return referenceId;
    }
    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public Boolean getRelationshipDeclared() {
        return relationshipDeclared;
    }
    public void setRelationshipDeclared(Boolean relationshipDeclared) {
        this.relationshipDeclared = relationshipDeclared;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    public PersonProfile(Long id, String personType, String referenceId, String fullName, String email,
            String department, Boolean relationshipDeclared, LocalDateTime createdAt) {
        this.id = id;
        this.personType = personType;
        this.referenceId = referenceId;
        this.fullName = fullName;
        this.email = email;
        this.department = department;
        this.relationshipDeclared = relationshipDeclared;
        this.createdAt = createdAt;
    }
    public PersonProfile() {
    }

    
}
