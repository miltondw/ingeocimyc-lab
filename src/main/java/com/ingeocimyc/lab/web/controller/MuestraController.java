package com.ingeocimyc.lab.web.controller;

import com.ingeocimyc.lab.persistence.entity.MuestraEntity;
import com.ingeocimyc.lab.service.MuestraService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/muestra")
public class MuestraController {
    private final MuestraService muestraService;

    public MuestraController(MuestraService muestraService) {
        this.muestraService = muestraService;
    }
    @GetMapping
    public ResponseEntity<MuestraEntity> get(@RequestParam Integer projectId,
                                                             @RequestParam Integer probe,
                                                             @RequestParam Integer muestra) {
        return ResponseEntity.ok(this.muestraService.get(projectId,probe,muestra));
    }
    @PostMapping
    public ResponseEntity<MuestraEntity> create(@RequestBody MuestraEntity muestra){
        return new ResponseEntity<MuestraEntity>(muestraService.create(muestra), HttpStatus.CREATED);
    }
}
