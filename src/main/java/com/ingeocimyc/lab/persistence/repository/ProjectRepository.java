package com.ingeocimyc.lab.persistence.repository;

import com.ingeocimyc.lab.persistence.entity.ProjectEntity;
import com.ingeocimyc.lab.persistence.projection.ProjectProjection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProjectRepository extends ListCrudRepository<ProjectEntity,Integer> {

    @Query(value = "SELECT P.TITLE, P.LOCATION, P.REFERENCE, P.DATE, " +
            "SO.NAME AS SOLICITANTE, S.PROBE, M.MUESTRA, H.SAMPLE_WEIGHT, H.TARE_WEIGHT AS TARE_WEIGHT_H, " +
            "EH.DEPTH, EH.TARE_WEIGHT AS TARE_WEIGHT_EH, EH.TARE_PLUS_WET_SOIL_WEIGHT AS TARE_PLUS_WET_SOIL_WEIGHT_EH, " +
            "EH.TARE_PLUS_DRY_SOIL AS TARE_PLUS_DRY_SOIL_EH , EH.DRY_SOIL_WEIGHT AS DRY_SOIL_WEIGHT_EH , " +
            "EH.WATER_WEIGHT AS WATER_WEIGHT_EH, EH.HUMIDITY AS HUMIDITY_EH, EH.CYLINDER, " +
            "EG.TAMICES AS TAMICES_EG, "+
            "EL.NUMBER_OF_STROKES, EL.TARE_NUMBER AS TARE_NUMBER_EL, EL.TARE_WEIGHT AS TARE_WEIGHT_EL, " +
            "EL.TARE_PLUS_WET_SOIL_WEIGHT AS TARE_PLUS_WET_SOIL_WEIGHT_EL, EL.TARE_PLUS_DRY_SOIL AS TARE_PLUS_DRY_SOIL_EL, "+
            "EL.WATER_WEIGHT AS WATER_WEIGHT_EL, EL.DRY_SOIL_WEIGHT AS DRY_SOIL_WEIGHT_EL, EL.HUMIDITY AS HUMIDITY_EL, " +
            "EL.NUMERO_PRUEBA AS NUMERO_PRUEBA_EL, " +
            "EP.TARE_NUMBER, EP.TARE_WEIGHT, EP.TARE_PLUS_WET_SOIL_WEIGHT, " +
            "EP.TARE_PLUS_DRY_SOIL, EP.DRY_SOIL_WEIGHT, EP.WATER_WEIGHT, EP.HUMIDITY, EP.OBSERVATION, EP.NUMERO_PRUEBA " +
            "FROM PROJECT AS P " +
            "INNER JOIN SOLICITANTE AS SO ON SO.ID = P.SOLICITANTE_ID " +
            "INNER JOIN SONDEO AS S ON S.PROJECT_ID = P.ID " +
            "INNER JOIN MUESTRA AS M ON M.SONDEO_ID = S.ID " +
            "INNER JOIN HEADER AS H ON H.MUESTRA_ID = M.ID " +
            "INNER JOIN ENSAYO_HUMEDAD AS EH ON EH.MUESTRA_ID = M.ID " +
            "INNER JOIN ENSAYO_GRANULOMETRIA AS EG ON EG.MUESTRA_ID = M.ID "+
            "INNER JOIN ENSAYO_LIQUIDO AS EL ON EL.MUESTRA_ID = M.ID " +
            "INNER JOIN ENSAYO_PLASTICO AS EP ON EP.MUESTRA_ID = M.ID " +
            "WHERE P.ID = :projectId " +
            "AND S.PROBE = :probeId " +
            "AND M.MUESTRA = :muestraId", nativeQuery = true)
    List<ProjectProjection> getProjectDetails(@Param("projectId") Integer projectId,
                                              @Param("probeId") Integer probeId,
                                              @Param("muestraId") Integer muestraId);
}
