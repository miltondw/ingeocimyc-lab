package com.ingeocimyc.lab.web.controller;

import com.ingeocimyc.lab.persistence.entity.HeaderEntity;
import com.ingeocimyc.lab.service.HeaderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/header")
public class HeaderController {
    public final HeaderService headerService;

    public HeaderController(HeaderService headerService) {
        this.headerService = headerService;
    }

    @GetMapping
    public ResponseEntity<Optional<HeaderEntity>> get(@RequestParam Integer muestraId) {
        return ResponseEntity.ok(this.headerService.get(muestraId));
    }
    @PostMapping
    public ResponseEntity<HeaderEntity> create(@RequestBody HeaderEntity granulometria) {
        HeaderEntity createdGranulometria = headerService.create(granulometria);
        return new ResponseEntity<HeaderEntity>(createdGranulometria, HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<HeaderEntity> update(@RequestBody HeaderEntity granulometria) {
        return ResponseEntity.ok(headerService.update(granulometria));
    }
}
