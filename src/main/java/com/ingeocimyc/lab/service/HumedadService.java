package com.ingeocimyc.lab.service;

import com.ingeocimyc.lab.persistence.entity.HumedadEntity;
import com.ingeocimyc.lab.persistence.repository.HumedadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HumedadService {
    public final HumedadRepository humedadRepository;
    @Autowired
    public HumedadService(HumedadRepository humedadRepository) {
        this.humedadRepository = humedadRepository;
    }
    public Optional<HumedadEntity> get(int muestraId){
        return Optional.ofNullable(humedadRepository.get( muestraId));
    }
    public HumedadEntity create(HumedadEntity granulometria) {
        return humedadRepository.save(granulometria);
    }
}
