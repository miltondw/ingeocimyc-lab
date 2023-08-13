package com.ingeocimyc.lab.web.controller;

import com.ingeocimyc.lab.persistence.entity.PlasticoEntity;
import com.ingeocimyc.lab.service.PlasticoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/plastico")
public class PlasticoController {
    private final PlasticoService plasticoService;

    public PlasticoController(PlasticoService plasticoService) {
        this.plasticoService = plasticoService;
    }

    @GetMapping
    public ResponseEntity<List<PlasticoEntity>> get(@RequestParam Integer muestraId) {
        return ResponseEntity.ok(this.plasticoService.get(muestraId));
    }
    @PostMapping
    public ResponseEntity<PlasticoEntity> create(@RequestBody PlasticoEntity plastico) {
        PlasticoEntity createdPlastico = plasticoService.create(plastico);
        return new ResponseEntity<PlasticoEntity>(createdPlastico, HttpStatus.CREATED);
    }
}
