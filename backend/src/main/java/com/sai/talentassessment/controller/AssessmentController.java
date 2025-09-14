package com.sai.talentassessment.controller;

import com.sai.talentassessment.model.AssessmentData;
import com.sai.talentassessment.model.AthleteProfile;
import com.sai.talentassessment.repository.AssessmentDataRepository;
import com.sai.talentassessment.repository.AthleteProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Controller to handle API requests from the mobile app and dashboard.
 */
@RestController
@RequestMapping("/api/v1")
public class AssessmentController {

    @Autowired
    private AthleteProfileRepository athleteProfileRepository;

    @Autowired
    private AssessmentDataRepository assessmentDataRepository;

    /**
     * Endpoint for the mobile app to create or update an athlete's profile.
     */
    @PostMapping("/athlete/profile")
    public ResponseEntity<AthleteProfile> createOrUpdateProfile(@RequestBody AthleteProfile profile) {
        AthleteProfile savedProfile = athleteProfileRepository.save(profile);
        return ResponseEntity.ok(savedProfile);
    }

    /**
     * Endpoint for the mobile app to submit a verified assessment result.
     */
    @PostMapping("/assessment/submit")
    public ResponseEntity<AssessmentData> submitAssessment(@RequestBody AssessmentData assessmentData) {
        // In a real application, you would handle video file upload separately (e.g., to S3)
        // and link the URL here.
        AssessmentData savedAssessment = assessmentDataRepository.save(assessmentData);
        return ResponseEntity.ok(savedAssessment);
    }

    /**
     * Endpoint for the officials' dashboard to view all athletes.
     */
    @GetMapping("/athletes")
    public ResponseEntity<List<AthleteProfile>> getAllAthletes() {
        return ResponseEntity.ok(athleteProfileRepository.findAll());
    }

    /**
     * Endpoint for the officials' dashboard to view all assessments for a specific athlete.
     */
    @GetMapping("/assessments/{athleteId}")
    public ResponseEntity<List<AssessmentData>> getAssessmentsForAthlete(@PathVariable String athleteId) {
        return ResponseEntity.ok(assessmentDataRepository.findByAthleteId(athleteId));
    }
}