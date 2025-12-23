package com.example.demo.controller;

import com.example.demo.model.PatternDetectionResult;
import com.example.demo.service.PatternDetectionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patterns")
public class PatternDetectionController {

    private final PatternDetectionService patternDetectionService;

    public PatternDetectionController(PatternDetectionService patternDetectionService) {
        this.patternDetectionService = patternDetectionService;
    }

    // Detect patterns for a specific zone
    @PostMapping("/detect/{zoneId}")
    public ResponseEntity<PatternDetectionResult> detectPattern(@PathVariable Long zoneId) {
        PatternDetectionResult result = patternDetectionService.detectPattern(zoneId);
        if (result != null) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Get all pattern detection results for a specific zone
    @GetMapping("/zone/{zoneId}")
    public ResponseEntity<List<PatternDetectionResult>> getResultsByZone(@PathVariable Long zoneId) {
        List<PatternDetectionResult> results = patternDetectionService.getResultsByZone(zoneId);
        if (results.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(results);
    }
}
