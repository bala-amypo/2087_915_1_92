package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class PatternDetectionResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long zoneId;
    private int crimeCount;
    private String detectedPattern;

    // ===== GETTERS =====
    public Long getId() {
        return id;
    }

    public Long getZoneId() {
        return zoneId;
    }

    public int getCrimeCount() {
        return crimeCount;
    }

    public String getDetectedPattern() {
        return detectedPattern;
    }

    // ===== SETTERS (IMPORTANT) =====
    public void setZoneId(Long zoneId) {
        this.zoneId = zoneId;
    }

    public void setCrimeCount(int crimeCount) {
        this.crimeCount = crimeCount;
    }

    public void setDetectedPattern(String detectedPattern) {
        this.detectedPattern = detectedPattern;
    }
}
