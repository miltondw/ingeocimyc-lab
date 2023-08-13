package com.ingeocimyc.lab.service;

import com.ingeocimyc.lab.persistence.entity.GranulometriaEntity;
import com.ingeocimyc.lab.persistence.repository.GranulometriaRepository;
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
}
