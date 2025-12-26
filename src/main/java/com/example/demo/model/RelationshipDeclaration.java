package com.example.demo.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "relationship_declaration")
public class RelationshipDeclaration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long personId;

    private String relatedPersonName;

    private String relationshipType;

    private String description;

    private Boolean isVerified;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime declaredAt;

    @PrePersist
    public void prePersist() {
        if (isVerified == null) {
            isVerified = false;
        }
    }

    // getters & setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getPersonId() { return personId; }
    public void setPersonId(Long personId) { this.personId = personId; }

    public String getRelatedPersonName() { return relatedPersonName; }
    public void setRelatedPersonName(String relatedPersonName) {
        this.relatedPersonName = relatedPersonName;
    }

    public String getRelationshipType() { return relationshipType; }
    public void setRelationshipType(String relationshipType) {
        this.relationshipType = relationshipType;
    }

    public String getDescription() { return description; }
    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIsVerified() { return isVerified; }
    public void setIsVerified(Boolean isVerified) { this.isVerified = isVerified; }

    public LocalDateTime getDeclaredAt() { return declaredAt; }
    public void setDeclaredAt(LocalDateTime declaredAt) {
        this.declaredAt = declaredAt;
    }

    public RelationshipDeclaration() {}

    public RelationshipDeclaration(Long id, Long personId, String relatedPersonName,
                                   String relationshipType, String description,
                                   Boolean isVerified, LocalDateTime declaredAt) {
        this.id = id;
        this.personId = personId;
        this.relatedPersonName = relatedPersonName;
        this.relationshipType = relationshipType;
        this.description = description;
        this.isVerified = isVerified;
        this.declaredAt = declaredAt;
    }
}
