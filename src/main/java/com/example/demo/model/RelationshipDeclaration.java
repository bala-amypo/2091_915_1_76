package com.example.demo.model;

import java.time.LocalDateTime;
import jakarta.persistence.*;
@Entity
public class RelationshipDeclaration {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private Long personId;
    private String relatedPersonName;
    private String relationshipType;
    private String description;
    private LocalDateTime declaredAt;
    private Boolean isVerified;
    @PrePersist
    public void prePersist() {
        if (isVerified == null) {
            isVerified = false;
        }
    }
    public Long getId() {
        return id;
    }
    public Long getPersonId() {
        return personId;
    }
    public String getRelatedPersonName() {
        return relatedPersonName;
    }
    public String getRelationshipType() {
        return relationshipType;
    }
    public String getDescription() {
        return description;
    }
    public LocalDateTime getDeclaredAt() {
        return declaredAt;
    }
    public Boolean getIsVerified() {
        return isVerified;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setPersonId(Long personId) {
        this.personId = personId;
    }
    public void setRelatedPersonName(String relatedPersonName) {
        this.relatedPersonName = relatedPersonName;
    }
    public void setRelationshipType(String relationshipType) {
        this.relationshipType = relationshipType;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setDeclaredAt(LocalDateTime declaredAt) {
        this.declaredAt = declaredAt;
    }
    public void setIsVerified(Boolean isVerified) {
        this.isVerified = isVerified;
    }
    public RelationshipDeclaration(Long id, Long personId, String relatedPersonName, String relationshipType, String description,
            LocalDateTime declaredAt, Boolean isVerified) {
        this.id = id;
        this.personId = personId;
        this.relatedPersonName = relatedPersonName;
        this.relationshipType = relationshipType;
        this.description = description;
        this.declaredAt = declaredAt;
        this.isVerified = isVerified;
    }
    public RelationshipDeclaration() {
    }
}
