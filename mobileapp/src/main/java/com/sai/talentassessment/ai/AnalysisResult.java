package com.sai.talentassessment.ai;

/**
 * Data class to hold the results from the on-device AI analysis.
 */
public class AnalysisResult {
    private final double value;
    private final String unit;
    private final boolean hasAnomalies; // From cheat detection
    private final String anomalyDetails;

    public AnalysisResult(double value, String unit, boolean hasAnomalies, String anomalyDetails) {
        this.value = value;
        this.unit = unit;
        this.hasAnomalies = hasAnomalies;
        this.anomalyDetails = anomalyDetails;
    }

    public double getValue() {
        return value;
    }

    public String getUnit() {
        return unit;
    }

    public boolean hasAnomalies() {
        return hasAnomalies;
    }

    public String getAnomalyDetails() {
        return anomalyDetails;
    }
}