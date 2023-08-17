package com.ingeocimyc.lab.service;

import com.ingeocimyc.lab.persistence.projection.SondeoProjection;
import com.ingeocimyc.lab.persistence.repository.SondeoRepository;
import org.springframework.stereotype.Service;

@Service
public class SondeoService {
    public final SondeoRepository sondeoRepository;

    public SondeoService(SondeoRepository sondeoRepository) {
        this.sondeoRepository = sondeoRepository;
    }
    public SondeoProjection get(int projectId, int probe){
        return this.sondeoRepository.get(projectId, probe);
    }
}
