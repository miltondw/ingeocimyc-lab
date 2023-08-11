package com.ingeocimyc.lab.persistence.repository;

import com.ingeocimyc.lab.persistence.entity.ProjectEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.ListPagingAndSortingRepository;

public interface ProjectPageSortRepository extends ListPagingAndSortingRepository<ProjectEntity, Integer> {
    Page<ProjectEntity> findAll(Pageable pageable);
}
