package com.example.demo.repository;

import com.example.demo.model.HotspotZone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotspotZoneRepository
        extends JpaRepository<HotspotZone, Long> {

    boolean existsByZoneName(String zoneName);

    List<HotspotZone> findBySeverityLevel(String severityLevel);
}
