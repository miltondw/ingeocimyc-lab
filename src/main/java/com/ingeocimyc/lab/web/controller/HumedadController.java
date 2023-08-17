package com.ingeocimyc.lab.web.controller;

import com.ingeocimyc.lab.persistence.entity.HumedadEntity;
import com.ingeocimyc.lab.service.HumedadService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/humedad")
public class HumedadController {
    public final HumedadService humedadService;

    public HumedadController(HumedadService humedadService) {
        this.humedadService = humedadService;
    }
    @GetMapping
    public ResponseEntity<Optional<HumedadEntity>> get(@RequestParam Integer muestraId) {
        return ResponseEntity.ok(this.humedadService.get(muestraId));
    }
    @PostMapping
    public ResponseEntity<HumedadEntity> create(@RequestBody HumedadEntity humedad) {
        HumedadEntity createdGranulometria = humedadService.create(humedad);
        return new ResponseEntity<HumedadEntity>(createdGranulometria, HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<HumedadEntity> update(@RequestBody HumedadEntity ensayo) {
        return ResponseEntity.ok(humedadService.update(ensayo));
    }
}
