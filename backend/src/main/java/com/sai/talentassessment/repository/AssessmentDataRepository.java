package com.sai.talentassessment.repository;

import com.sai.talentassessment.model.AssessmentData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * JPA Repository for AssessmentData entities.
 * Includes custom query to find all assessments for a specific athlete.
 */
@Repository
public interface AssessmentDataRepository extends JpaRepository<AssessmentData, Long> {
    List<AssessmentData> findByAthleteId(String athleteId);
}