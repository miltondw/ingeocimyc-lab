package com.ingeocimyc.lab.service;


import com.ingeocimyc.lab.persistence.entity.LiquidoEntity;
import com.ingeocimyc.lab.persistence.repository.LiquidoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LiquidoService {
    public final LiquidoRepository liquidoRepository;
    @Autowired
    public LiquidoService(LiquidoRepository liquidoRepository) {
        this.liquidoRepository = liquidoRepository;
    }
    public List<LiquidoEntity> get(int muestraId){
        return liquidoRepository.get( muestraId);
    }
    public LiquidoEntity create(LiquidoEntity liquido) {
        return liquidoRepository.save(liquido);
    }
    public LiquidoEntity update(@NotNull LiquidoEntity ensayo) {
        Integer id = ensayo.getId();
        LiquidoEntity existing = liquidoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(" not found with ID: " + id));
        existing.setNumber_of_strokes(ensayo.getNumber_of_strokes());
        existing.setTare_number(ensayo.getTare_number());
        existing.setTare_plus_wet_soil_weight(ensayo.getTare_plus_wet_soil_weight());
        existing.setTare_plus_dry_soil(ensayo.getTare_plus_dry_soil());
        existing.setDry_soil_weight(ensayo.getDry_soil_weight());
        existing.setWater_weight(ensayo.getWater_weight());
        existing.setHumidity(ensayo.getHumidity());
        existing.setLimite_liquido(ensayo.getLimite_liquido());
        existing.setTare_weight(ensayo.getTare_weight());
        existing.setNumero_prueba(ensayo.getNumero_prueba());
        return liquidoRepository.save(existing);
    }
}
