package com.ingeocimyc.lab.service;

import com.ingeocimyc.lab.persistence.entity.HeaderEntity;
import com.ingeocimyc.lab.persistence.repository.HeaderRepository;
import jakarta.persistence.EntityNotFoundException;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HeaderService {
    private final HeaderRepository headerRepository;
    @Autowired
    public HeaderService(HeaderRepository headerRepository) {
        this.headerRepository = headerRepository;
    }
    public Optional<HeaderEntity> get(int muestraId){
        return Optional.ofNullable(headerRepository.get( muestraId));
    }
    public HeaderEntity create(HeaderEntity header) {
        return headerRepository.save(header);
    }
    public HeaderEntity update(@NotNull HeaderEntity ensayo) {
        Integer id = ensayo.getMuestra_id();
        HeaderEntity existing = headerRepository.findByMuestraId(id)
                .orElseThrow(() -> new EntityNotFoundException("not found with ID: " + id));
        existing.setTare_weight(ensayo.getTare_weight());
        existing.setSample_weight(ensayo.getSample_weight());
        return headerRepository.save(existing);
    }
}
