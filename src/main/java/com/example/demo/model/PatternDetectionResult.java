package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class PatternDetectionResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String patternType;
    private LocalDate analysisDate;

    @ManyToOne
    @JoinColumn(name = "zone_id")
    private HotspotZone zone;

    // ===== getters & setters =====
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getPatternType() { return patternType; }
    public void setPatternType(String patternType) { this.patternType = patternType; }

    public LocalDate getAnalysisDate() { return analysisDate; }
    public void setAnalysisDate(LocalDate analysisDate) { this.analysisDate = analysisDate; }

    public HotspotZone getZone() { return zone; }
    public void setZone(HotspotZone zone) { this.zone = zone; }
}
