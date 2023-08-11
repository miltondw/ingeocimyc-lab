package com.ingeocimyc.lab.web.controller;

import com.ingeocimyc.lab.persistence.entity.ProjectEntity;
import com.ingeocimyc.lab.persistence.entity.SolicitanteEntity;
import com.ingeocimyc.lab.service.SolicitanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @PostMapping
    public ResponseEntity<SolicitanteEntity> createSolicitante(@RequestBody SolicitanteEntity solicitante) {
        SolicitanteEntity createdProject = solicitanteService.createSolicitante(solicitante);
        return new ResponseEntity<SolicitanteEntity>(createdProject, HttpStatus.CREATED);
    }

}
