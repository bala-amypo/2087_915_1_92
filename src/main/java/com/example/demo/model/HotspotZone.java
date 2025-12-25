package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "hotspot_zones")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HotspotZone {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true, nullable = false)
    private String zoneName;
    
    @Column(nullable = false)
    private Double centerLat;
    
    @Column(nullable = false)
    private Double centerLong;
    
    private Double radius = 1.0;
    
    @Column(nullable = false)
    private String severityLevel = "LOW";
}