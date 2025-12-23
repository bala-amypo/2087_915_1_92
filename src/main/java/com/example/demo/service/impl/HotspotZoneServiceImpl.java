package com.example.demo.service.impl;

import com.example.demo.model.HotspotZone;
import com.example.demo.repository.HotspotZoneRepository;
import com.example.demo.service.HotspotZoneService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotspotZoneServiceImpl implements HotspotZoneService {

    private final HotspotZoneRepository zoneRepo;

    public HotspotZoneServiceImpl(HotspotZoneRepository zoneRepo) {
        this.zoneRepo = zoneRepo;
    }

    @Override
    public HotspotZone addZone(HotspotZone zone) {
        if(zoneRepo.existsByZoneName(zone.getZoneName())) throw new RuntimeException("Zone name exists");
        if(zone.getCenterLat()<-90 || zone.getCenterLat()>90 || zone.getCenterLong()<-180 || zone.getCenterLong()>180)
            throw new RuntimeException("Latitude or Longitude out of range");
        return zoneRepo.save(zone);
    }

    @Override
    public List<HotspotZone> getAllZones() {
        return zoneRepo.findAll();
    }

    @Override
    public HotspotZone getZoneById(Long id) {
        return zoneRepo.findById(id).orElseThrow(() -> new RuntimeException("Zone not found"));
    }
}
