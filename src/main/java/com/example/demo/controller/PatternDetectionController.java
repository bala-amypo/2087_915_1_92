package com.example.demo.controller;

import com.example.demo.model.PatternDetectionResult;
import com.example.demo.service.PatternDetectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/patterns")
public class PatternDetectionController {
    
    @Autowired
    private PatternDetectionService patternDetectionService;
    
    @PostMapping("/detect/{zoneId}")
    public PatternDetectionResult detectPattern(@PathVariable Long zoneId) {
        return patternDetectionService.detectPattern(zoneId);
    }
    
    @GetMapping("/zone/{zoneId}")
    public List<PatternDetectionResult> getResultsByZone(@PathVariable Long zoneId) {
        return patternDetectionService.getResultsByZone(zoneId);
    }
}