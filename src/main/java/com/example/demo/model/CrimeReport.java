package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class CrimeReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String crimeType;
    private String description;

    private double latitude;
    private double longitude;

    private LocalDateTime occurredAt;

    @ManyToOne
    @JoinColumn(name = "zone_id")
    private HotspotZone zone;

    // ===== getters & setters =====
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCrimeType() { return crimeType; }
    public void setCrimeType(String crimeType) { this.crimeType = crimeType; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public double getLatitude() { return latitude; }
    public void setLatitude(double latitude) { this.latitude = latitude; }

    public double getLongitude() { return longitude; }
    public void setLongitude(double longitude) { this.longitude = longitude; }

    public LocalDateTime getOccurredAt() { return occurredAt; }
    public void setOccurredAt(LocalDateTime occurredAt) { this.occurredAt = occurredAt; }

    public HotspotZone getZone() { return zone; }
    public void setZone(HotspotZone zone) { this.zone = zone; }
}
