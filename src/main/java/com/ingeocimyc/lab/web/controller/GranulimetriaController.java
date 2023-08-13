package com.ingeocimyc.lab.web.controller;

import com.ingeocimyc.lab.persistence.entity.GranulometriaEntity;
import com.ingeocimyc.lab.service.GranulometriaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/granulometria")
public class GranulimetriaController {
    private final GranulometriaService granulometriaService;

    public GranulimetriaController(GranulometriaService granulometriaService) {
        this.granulometriaService = granulometriaService;
    }

    @GetMapping
    public ResponseEntity<Optional<GranulometriaEntity>> get( @RequestParam Integer muestraId) {
        return ResponseEntity.ok(this.granulometriaService.get(muestraId));
    }
    @PostMapping
    public ResponseEntity<GranulometriaEntity> create(@RequestBody GranulometriaEntity granulometria) {
        GranulometriaEntity createdGranulometria = granulometriaService.create(granulometria);
        return new ResponseEntity<GranulometriaEntity>(createdGranulometria, HttpStatus.CREATED);
    }
}
