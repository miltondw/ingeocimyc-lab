package com.ingeocimyc.lab.service;

import com.ingeocimyc.lab.persistence.entity.LiquidoEntity;
import com.ingeocimyc.lab.persistence.repository.LiquidoRepository;
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
}
