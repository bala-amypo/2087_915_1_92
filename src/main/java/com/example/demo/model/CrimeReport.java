package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class CrimeReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String crimeType;

    // ✅ Many CrimeReports → One Zone
    @ManyToOne
    @JoinColumn(name = "zone_id") // foreign key column
    private HotspotZone zone;

    // ===== GETTERS & SETTERS =====
    public Long getId() {
        return id;
    }

    public String getCrimeType() {
        return crimeType;
    }

    public void setCrimeType(String crimeType) {
        this.crimeType = crimeType;
    }

    public HotspotZone getZone() {
        return zone;
    }

    public void setZone(HotspotZone zone) {
        this.zone = zone;
    }
}
