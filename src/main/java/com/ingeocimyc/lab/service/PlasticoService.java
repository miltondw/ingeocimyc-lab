package com.ingeocimyc.lab.service;

import com.ingeocimyc.lab.persistence.entity.PlasticoEntity;
import com.ingeocimyc.lab.persistence.repository.PlasticoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlasticoService {
    public final PlasticoRepository plasticoRepository;
    @Autowired
    public PlasticoService(PlasticoRepository plasticoRepository) {
        this.plasticoRepository = plasticoRepository;
    }
    public List<PlasticoEntity> get(int muestraId){
        return plasticoRepository.get( muestraId);
    }
    public PlasticoEntity create(PlasticoEntity plastico) {
        return plasticoRepository.save(plastico);
    }
    public PlasticoEntity update(@NotNull PlasticoEntity ensayo) {
        Integer id = ensayo.getId();
        PlasticoEntity existing = plasticoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(" not found with ID: " + id));
        existing.setTare_number(ensayo.getTare_number());
        existing.setTare_weight(ensayo.getTare_weight());
        existing.setTare_plus_wet_soil_weight(ensayo.getTare_plus_wet_soil_weight());
        existing.setTare_plus_dry_soil(ensayo.getTare_plus_dry_soil());
        existing.setDry_soil_weight(ensayo.getDry_soil_weight());
        existing.setWater_weight(ensayo.getWater_weight());
        existing.setHumidity(ensayo.getHumidity());
        existing.setNumero_prueba(ensayo.getNumero_prueba());
        existing.setObservation(ensayo.getObservation());
        return plasticoRepository.save(existing);
    }
}
