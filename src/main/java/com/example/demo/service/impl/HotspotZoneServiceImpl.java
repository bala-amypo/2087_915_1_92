package com.example.demo.service.impl;


import com.example.demo.model.HotspotZone;
import com.example.demo.repository.HotspotZoneRepository;
import com.example.demo.service.HotspotZoneService;
import com.example.demo.util.CoordinateValidator;
import org.springframework.stereotype.Service;


@Service
public class HotspotZoneServiceImpl implements HotspotZoneService {


private final HotspotZoneRepository repo;


public HotspotZoneServiceImpl(HotspotZoneRepository repo) {
this.repo = repo;
}
@Override
public HotspotZone createZone(HotspotZone zone) {
if (repo.existsByZoneName(zone.getZoneName())) {
throw new IllegalArgumentException("Zone already exists");
}
CoordinateValidator.validate(zone.getCenterLat(), zone.getCenterLong());
return repo.save(zone);
}
}