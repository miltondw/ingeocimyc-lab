package com.ingeocimyc.lab.service;

import com.ingeocimyc.lab.persistence.entity.PlasticoEntity;
import com.ingeocimyc.lab.persistence.repository.PlasticoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
}
