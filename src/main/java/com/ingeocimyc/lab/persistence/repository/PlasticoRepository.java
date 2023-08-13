package com.ingeocimyc.lab.persistence.repository;

import com.ingeocimyc.lab.persistence.entity.PlasticoEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlasticoRepository extends ListCrudRepository<PlasticoEntity, Integer> {
    @Query(value = "SELECT * FROM ensayo_plastico WHERE MUESTRA_ID = :muestraId", nativeQuery = true)
    List<PlasticoEntity> get(@Param("muestraId") Integer muestraId);
}
