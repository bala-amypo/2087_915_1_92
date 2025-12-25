package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "analysis_logs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnalysisLog {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "zone_id")
    private HotspotZone zone;
    
    private String message;
    
    @Column(nullable = false)
    private LocalDateTime loggedAt = LocalDateTime.now();
}