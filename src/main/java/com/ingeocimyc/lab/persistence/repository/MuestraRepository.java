package com.ingeocimyc.lab.persistence.repository;

import com.ingeocimyc.lab.persistence.entity.MuestraEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

public interface MuestraRepository extends ListCrudRepository<MuestraEntity,Integer> {
    @Query(value = "SELECT "+
            "M.id, " +
            "M.sondeo_id, "+
            "M.muestra "+
            "FROM PROJECT AS P " +
            "INNER JOIN SONDEO AS S ON S.PROJECT_ID = P.ID " +
            "INNER JOIN MUESTRA AS M ON M.SONDEO_ID = S.ID " +
            "WHERE P.ID = :projectId " +
            "AND S.PROBE = :probe " +
            "AND M.MUESTRA = :muestra", nativeQuery = true)
    MuestraEntity get(@Param("projectId") Integer projectId,
                            @Param("probe") Integer probeId,
                            @Param("muestra") Integer muestraId);

}
