package com.ingeocimyc.lab.persistence.repository;

import com.ingeocimyc.lab.persistence.entity.HumedadEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

public interface HumedadRepository extends ListCrudRepository<HumedadEntity, Integer> {
    @Query(value = "SELECT * FROM ensayo_humedad WHERE MUESTRA_ID = :muestraId", nativeQuery = true)
    HumedadEntity get(@Param("muestraId") Integer muestraId);
}
