package com.ingeocimyc.lab.persistence.repository;

import com.ingeocimyc.lab.persistence.entity.GranulometriaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GranulometriaRepository extends ListCrudRepository<GranulometriaEntity, Integer> {
    @Query(value = "SELECT EG.ID," +
            "EG.ACUM," +
            "EG.ARENA," +
            "EG.FINOS," +
            "EG.GRAVA," +
            "EG.MUESTRA_ID," +
            "EG.OBSERVATION," +
            "EG.PASA," +
            "EG.RETENIDO," +
            "EG.SUCS_DATA," +
            "EG.TAMICES," +
            "EG.TOTAL " +
            "FROM PROJECT AS P " +
            "INNER JOIN SONDEO AS S ON S.PROJECT_ID = P.ID " +
            "INNER JOIN MUESTRA AS M ON M.SONDEO_ID = S.ID " +
            "INNER JOIN ENSAYO_GRANULOMETRIA AS EG ON EG.MUESTRA_ID = M.ID " +
            "WHERE P.ID = :projectId " +
            "AND S.PROBE = :probeId " +
            "AND M.MUESTRA = :muestraId", nativeQuery = true)
    GranulometriaEntity get(@Param("projectId") Integer projectId,
                                @Param("probeId") Integer probeId,
                                @Param("muestraId") Integer muestraId);
}
