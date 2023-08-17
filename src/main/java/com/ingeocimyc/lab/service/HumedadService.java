package com.ingeocimyc.lab.service;

import com.ingeocimyc.lab.persistence.entity.HumedadEntity;
import com.ingeocimyc.lab.persistence.repository.HumedadRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HumedadService {
    public final HumedadRepository humedadRepository;

    public HumedadService(HumedadRepository humedadRepository) {
        this.humedadRepository = humedadRepository;
    }
    public Optional<HumedadEntity> get(int muestraId){
        return Optional.ofNullable(humedadRepository.get( muestraId));
    }
    public HumedadEntity create(HumedadEntity ensayo) {
        return humedadRepository.save(ensayo);
    }
    public HumedadEntity update(@NotNull HumedadEntity ensayo) {
        Integer id = ensayo.getMuestra_id();
        HumedadEntity existing = humedadRepository.findByMuestraId(id)
                .orElseThrow(() -> new EntityNotFoundException(" not found with ID: " + id));
        existing.setTare_weight(ensayo.getTare_weight());
        existing.setTare_plus_wet_soil_weight(ensayo.getTare_plus_wet_soil_weight());
        existing.setTare_plus_dry_soil(ensayo.getTare_plus_dry_soil());
        existing.setDry_soil_weight(ensayo.getDry_soil_weight());
        existing.setWater_weight(ensayo.getWater_weight());
        existing.setHumidity(ensayo.getHumidity());
        existing.setCylinder(ensayo.getCylinder());
        existing.setDepth(ensayo.getDepth());
        return humedadRepository.save(existing);
    }
}
