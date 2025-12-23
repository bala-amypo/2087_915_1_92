package com.example.demo.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class HotspotZone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String zoneName;

    // ✅ One Zone → Many CrimeReports
    @OneToMany(mappedBy = "zone", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CrimeReport> crimeReports;

    // ===== GETTERS & SETTERS =====
    public Long getId() {
        return id;
    }

    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    public List<CrimeReport> getCrimeReports() {
        return crimeReports;
    }

    public void setCrimeReports(List<CrimeReport> crimeReports) {
        this.crimeReports = crimeReports;
    }
}
