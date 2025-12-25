package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "pattern_detection_results")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatternDetectionResult {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "zone_id")
    private HotspotZone zone;
    
    private String detectedPattern;
    
    private Integer crimeCount;
    
    private LocalDate analysisDate = LocalDate.now();
}