package com.ingeocimyc.lab.service;

import com.ingeocimyc.lab.persistence.entity.MuestraEntity;
import com.ingeocimyc.lab.persistence.repository.MuestraRepository;
import org.springframework.stereotype.Service;

@Service
public class MuestraService {
    public final MuestraRepository muestraRepository;

    public MuestraService(MuestraRepository muestraRepository) {
        this.muestraRepository = muestraRepository;
    }
    public MuestraEntity get(int projectId,int probe,int muestra){
        return this.muestraRepository.get(projectId, probe, muestra);
    }
    public MuestraEntity create(MuestraEntity muestra){
        return this.muestraRepository.save(muestra);
    }
}
