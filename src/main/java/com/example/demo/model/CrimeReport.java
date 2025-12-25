package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "crime_reports")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CrimeReport {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String crimeType;
    
    private String description;
    
    @Column(nullable = false)
    private Double latitude;
    
    @Column(nullable = false)
    private Double longitude;
    
    @Column(nullable = false)
    private LocalDateTime occurredAt;
    
    @Column(nullable = false)
    private LocalDateTime reportedAt = LocalDateTime.now();
}