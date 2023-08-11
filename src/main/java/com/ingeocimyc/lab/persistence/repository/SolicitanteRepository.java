package com.ingeocimyc.lab.persistence.repository;

import com.ingeocimyc.lab.persistence.entity.SolicitanteEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SolicitanteRepository extends ListCrudRepository<SolicitanteEntity,String> {
    @Query(value = "SELECT * FROM solicitante WHERE name LIKE :nombre%", nativeQuery = true)
    List<SolicitanteEntity> findByName(@Param("nombre") String nombre);
}
