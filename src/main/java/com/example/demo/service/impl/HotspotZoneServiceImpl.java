package com.example.demo.service.impl;

import com.example.demo.model.HotspotZone;
import com.example.demo.repository.HotspotZoneRepository;
import com.example.demo.service.HotspotZoneService;
import com.example.demo.util.CoordinateValidator;

import java.util.List;

public class HotspotZoneServiceImpl implements HotspotZoneService {

    private final HotspotZoneRepository zoneRepository;

    public HotspotZoneServiceImpl(HotspotZoneRepository zoneRepository) {
        this.zoneRepository = zoneRepository;
    }

    @Override
    public HotspotZone addZone(HotspotZone zone) {

        if (zoneRepository.findByZoneName(zone.getZoneName()) != null) {
            throw new RuntimeException("Zone name already exists");
        }
        if (!CoordinateValidator.isValidLatitude(zone.getCenterLat())) {
            throw new RuntimeException("Invalid latitude");
        }
        if (!CoordinateValidator.isValidLongitude(zone.getCenterLong())) {
            throw new RuntimeException("Invalid longitude");
        }

        zone.setSeverityLevel("LOW");
        return zoneRepository.save(zone);
    }

    @Override
    public List<HotspotZone> getAllZones() {
        return zoneRepository.findAll();
    }
}
