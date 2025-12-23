package com.example.demo.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class HotspotZone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String zoneName;
    private double centerLat;
    private double centerLong;
    private String severityLevel;

    @OneToMany(mappedBy = "zone", cascade = CascadeType.ALL)
    private List<CrimeReport> crimeReports;

 
    public Long getId() {
         return id; 
         }
    public void setId(Long id) { 
    this.id = id;
     }

    public String getZoneName() { 
    return zoneName;
     }
    public void setZoneName(String zoneName) { 
    this.zoneName = zoneName; 
    }

    public double getCenterLat() { 
        return centerLat; 
        }
    public void setCenterLat(double centerLat) { 
        this.centerLat = centerLat;
         }

    public double getCenterLong() {
         return centerLong;
          }
    public void setCenterLong(double centerLong) { 
        this.centerLong = centerLong;
         }

    public String getSeverityLevel() {
         return severityLevel; 
         }
    public void setSeverityLevel(String severityLevel) { 
        this.severityLevel = severityLevel;
         }
}
