package com.example.demo.controller;

import com.example.demo.model.PatternDetectionResult;
import com.example.demo.service.PatternDetectionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patterns")
public class PatternDetectionController {

    private final PatternDetectionService detectionService;

    public PatternDetectionController(PatternDetectionService detectionService) {
        this.detectionService = detectionService;
    }

    @PostMapping("/detect/{zoneId}")
    public PatternDetectionResult detect(@PathVariable Long zoneId) {
        return detectionService.detectPattern(zoneId);
    }

    @GetMapping("/zone/{zoneId}")
    public List<PatternDetectionResult> getResultsByZone(@PathVariable Long zoneId) {
        return detectionService.getResultsByZone(zoneId);
    }
}
