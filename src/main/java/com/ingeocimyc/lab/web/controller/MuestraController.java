package com.ingeocimyc.lab.web.controller;

import com.ingeocimyc.lab.persistence.entity.MuestraEntity;
import com.ingeocimyc.lab.service.MuestraService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/muestra")
public class MuestraController {
    private final MuestraService muestraService;

    public MuestraController(MuestraService muestraService) {
        this.muestraService = muestraService;
    }
    @GetMapping
    public ResponseEntity<MuestraEntity> get(@RequestParam Integer projectId,
                                                             @RequestParam Integer probeId,
                                                             @RequestParam Integer muestraId) {
        return ResponseEntity.ok(this.muestraService.get(projectId,probeId,muestraId));
    }
}
