package com.example.demo.repository;

import com.example.demo.model.HotspotZone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotspotZoneRepository extends JpaRepository<HotspotZone, Long> {

    HotspotZone findByZoneName(String zoneName);

    List<HotspotZone> findBySeverityLevel(String level);
}
