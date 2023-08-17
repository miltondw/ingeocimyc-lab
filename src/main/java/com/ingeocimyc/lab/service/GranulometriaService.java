package com.ingeocimyc.lab.service;

import com.ingeocimyc.lab.persistence.entity.GranulometriaEntity;
import com.ingeocimyc.lab.persistence.repository.GranulometriaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GranulometriaService {
    public final GranulometriaRepository granulometriaRepository;
    @Autowired
    public GranulometriaService(GranulometriaRepository granulometriaRepository) {
        this.granulometriaRepository = granulometriaRepository;
    }
    public Optional<GranulometriaEntity> get(int muestraId){
        return Optional.ofNullable(granulometriaRepository.get( muestraId));
    }
    public GranulometriaEntity create(GranulometriaEntity granulometria) {
        return granulometriaRepository.save(granulometria);
    }
    public GranulometriaEntity update(@NotNull GranulometriaEntity ensayo) {
        Integer id = ensayo.getMuestra_id();
        GranulometriaEntity existing = granulometriaRepository.findByMuestraId(id)
                .orElseThrow(() -> new EntityNotFoundException("not found with ID: " + id));
        existing.setTamices(ensayo.getTamices());
        existing.setTotal(ensayo.getTotal());
        existing.setRetenido(ensayo.getRetenido());
        existing.setAcum(ensayo.getAcum());
        existing.setPasa(ensayo.getPasa());
        existing.setGrava(ensayo.getGrava());
        existing.setArena(ensayo.getArena());
        existing.setFinos(ensayo.getFinos());
        existing.setSucs_data(ensayo.getSucs_data());
        return granulometriaRepository.save(existing);
    }
}
