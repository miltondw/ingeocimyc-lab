package com.ingeocimyc.lab.persistence.repository;

import com.ingeocimyc.lab.persistence.entity.GranulometriaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

public interface GranulometriaRepository extends ListCrudRepository<GranulometriaEntity, Integer> {
    @Query(value = "SELECT * FROM ENSAYO_GRANULOMETRIA WHERE MUESTRA_ID = :muestraId", nativeQuery = true)
    GranulometriaEntity get(@Param("muestraId") Integer muestraId);
}