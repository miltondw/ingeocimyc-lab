package com.ingeocimyc.lab.persistence.repository;

import com.ingeocimyc.lab.persistence.entity.SolicitanteEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.ListPagingAndSortingRepository;


public interface SolicitantePageSortRepository extends ListPagingAndSortingRepository<SolicitanteEntity, String> {
    Page<SolicitanteEntity> findAll(Pageable pageable);
}