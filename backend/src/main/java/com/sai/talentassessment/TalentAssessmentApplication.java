package com.sai.talentassessment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main entry point for the Spring Boot backend application.
 * This application will manage and store athlete performance data submitted
 * by the mobile app.
 */
@SpringBootApplication
public class TalentAssessmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(TalentAssessmentApplication.class, args);
    }

}