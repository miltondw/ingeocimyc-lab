package com.ingeocimyc.lab.persistence.repository;

import com.ingeocimyc.lab.persistence.entity.LiquidoEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LiquidoRepository extends ListCrudRepository<LiquidoEntity, Integer> {
    @Query(value = "SELECT * FROM ensayo_liquido WHERE MUESTRA_ID = :muestraId", nativeQuery = true)
    List<LiquidoEntity> get(@Param("muestraId") Integer muestraId);
}
