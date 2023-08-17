package com.ingeocimyc.lab.persistence.repository;

import com.ingeocimyc.lab.persistence.entity.HeaderEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface HeaderRepository extends ListCrudRepository<HeaderEntity, Integer> {
    @Query(value = "SELECT * FROM HEADER WHERE MUESTRA_ID = :muestraId", nativeQuery = true)
    HeaderEntity get(@Param("muestraId") Integer muestraId);
    Optional<HeaderEntity> findByMuestraId(Integer id);
}
