package com.example.demo.model;


import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "analysis_logs")
public class AnalysisLog {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


private String message;

private LocalDateTime loggedAt;


@ManyToOne
private HotspotZone zone;


public AnalysisLog() {}


public AnalysisLog(String message, HotspotZone zone) {
this.message = message;
this.zone = zone;
}


@PrePersist
public void logTime() {
loggedAt = LocalDateTime.now();
}
}