package com.ingeocimyc.lab.web.controller;

import com.ingeocimyc.lab.persistence.entity.SolicitanteEntity;
import com.ingeocimyc.lab.service.SolicitanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/solicitante")
public class SolicitanteController {
    private final SolicitanteService solicitanteService;
    @Autowired
    public SolicitanteController(SolicitanteService solicitanteService) {
        this.solicitanteService = solicitanteService;
    }
    @GetMapping
    public ResponseEntity<Page<SolicitanteEntity>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "6") int elements
    ) {
        return ResponseEntity.ok(solicitanteService.getAll(page,elements));
    }
    @GetMapping("/name")
    public ResponseEntity<List<SolicitanteEntity>> getByName(
            @RequestParam() String nombre
    ) {
        return ResponseEntity.ok(solicitanteService.getByName(nombre));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<SolicitanteEntity>> getById(@PathVariable String id) {
        return ResponseEntity.ok(solicitanteService.getById(id));
    }
    @PostMapping
    public ResponseEntity<SolicitanteEntity> createSolicitante(@RequestBody SolicitanteEntity solicitante) {
        SolicitanteEntity createdProject = solicitanteService.create(solicitante);
        return new ResponseEntity<SolicitanteEntity>(createdProject, HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<SolicitanteEntity> update(@RequestBody SolicitanteEntity solicitante) {
        return ResponseEntity.ok(solicitanteService.update(solicitante));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        solicitanteService.delete(id);
        return ResponseEntity.ok().build();
    }

}
