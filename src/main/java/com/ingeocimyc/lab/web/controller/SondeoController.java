package com.ingeocimyc.lab.web.controller;

import com.ingeocimyc.lab.persistence.projection.SondeoProjection;
import com.ingeocimyc.lab.service.SondeoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sondeo")
public class SondeoController {
    public final SondeoService sondeoService;

    public SondeoController(SondeoService sondeoService) {
        this.sondeoService = sondeoService;
    }

    @GetMapping
    public ResponseEntity<SondeoProjection> get(@RequestParam Integer projectId,
                                                @RequestParam Integer probe) {
        return ResponseEntity.ok(this.sondeoService.get(projectId,probe));
    }
}
