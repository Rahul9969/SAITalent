package com.sai.talentassessment.repository;

import com.sai.talentassessment.model.AthleteProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * JPA Repository for AthleteProfile entities.
 * Provides standard database operations (CRUD).
 */
@Repository
public interface AthleteProfileRepository extends JpaRepository<AthleteProfile, String> {
}