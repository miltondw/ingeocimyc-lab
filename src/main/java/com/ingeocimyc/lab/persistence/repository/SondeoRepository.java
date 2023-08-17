package com.ingeocimyc.lab.persistence.repository;

import com.ingeocimyc.lab.persistence.entity.SondeoEntity;
import com.ingeocimyc.lab.persistence.projection.SondeoProjection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

public interface SondeoRepository extends ListCrudRepository<SondeoEntity,Integer> {
    @Query(value = "SELECT " +
            "SONDEO.ID, " +
            "COUNT(MUESTRA.ID) AS MUESTRAS " +
            "FROM " +
            "SONDEO " +
            "INNER JOIN " +
            "MUESTRA ON MUESTRA.SONDEO_ID = SONDEO.ID " +
            "WHERE " +
            "SONDEO.project_id = :projectId " +
            "AND SONDEO.probe = :probe " +
            "GROUP BY " +
            "SONDEO.ID" , nativeQuery = true)
    SondeoProjection get(@Param("projectId") Integer projectId,
                         @Param("probe") Integer probeId);
}
