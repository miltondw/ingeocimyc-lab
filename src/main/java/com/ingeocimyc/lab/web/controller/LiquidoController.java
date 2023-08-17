package com.ingeocimyc.lab.web.controller;

import com.ingeocimyc.lab.persistence.entity.LiquidoEntity;
import com.ingeocimyc.lab.service.LiquidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/liquido")
public class LiquidoController {
    private final LiquidoService liquidoService;

    public LiquidoController(LiquidoService liquidoService) {
        this.liquidoService = liquidoService;
    }

    @GetMapping
    public ResponseEntity<List<LiquidoEntity>> get(@RequestParam Integer muestraId) {
        return ResponseEntity.ok(this.liquidoService.get(muestraId));
    }
    @PostMapping
    public ResponseEntity<LiquidoEntity> create(@RequestBody LiquidoEntity liquido) {
        LiquidoEntity createdLiquido = liquidoService.create(liquido);
        return new ResponseEntity<LiquidoEntity>(createdLiquido, HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<LiquidoEntity> update(@RequestBody LiquidoEntity ensayo) {
        return ResponseEntity.ok(liquidoService.update(ensayo));
    }
}
