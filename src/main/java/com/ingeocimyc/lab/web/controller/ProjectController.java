package com.ingeocimyc.lab.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ingeocimyc.lab.persistence.entity.ProjectEntity;
import com.ingeocimyc.lab.persistence.projection.ProjectProjection;
import com.ingeocimyc.lab.persistence.projection.dto.TamicesData;
import com.ingeocimyc.lab.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public ResponseEntity<Page<ProjectEntity>> getAll(  @RequestParam(defaultValue = "0") int page,
                                                        @RequestParam(defaultValue = "10") int elements,
                                                        @RequestParam(defaultValue = "date") String sortBy,
                                                        @RequestParam(defaultValue = "desc") String sortDirection) {
        return ResponseEntity.ok(projectService.getAll(page,elements,sortBy,sortDirection));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<ProjectEntity>> getById( @PathVariable Integer id) {
        return ResponseEntity.ok(projectService.getById(id));
    }

    @GetMapping("/{projectId}/details")
    @ResponseBody
    public ResponseEntity<List<Map<String, Object>>> getProjectDetails(
            @PathVariable Integer projectId,
            @RequestParam Integer probeId,
            @RequestParam Integer muestraId
    ) {
        List<ProjectProjection> results = projectService.getProjectDetails(projectId, probeId, muestraId);

        // Crear un mapa para agrupar los datos por categoría
        List<Map<String, Object>> arrayData= new ArrayList<>() ;
        List<Map<String, Object>> liquidoDataList = new ArrayList<>();
        List<Map<String, Object>> plasticoDataList = new ArrayList<>();

        int count=1;
        for (ProjectProjection projection : results) {
            Map<String, Object> dataMap = new HashMap<>();
            // Agrupar los datos de HEADER
            Map<String, Object> headerData = new HashMap<>();
            headerData.put("title", projection.getTITLE());
            headerData.put("location", projection.getLOCATION());
            headerData.put("reference", projection.getREFERENCE());
            headerData.put("date", projection.getDATE());
            headerData.put("name", projection.getNAME()+' '+projection.getLASTNAME());
            headerData.put("probe", projection.getPROBE());
            headerData.put("muestra", projection.getMUESTRA());
            headerData.put("sampleWeight", projection.getSAMPLE_WEIGHT());
            headerData.put("tareWeightH", projection.getTARE_WEIGHT_H());
            // Agrupar los datos de HUMEDAD
            Map<String, Object> humedadData = new HashMap<>();
            humedadData.put("depth", projection.getDEPTH());
            humedadData.put("humidity", projection.getHUMIDITY_EH());
            humedadData.put("cylinder", projection.getCYLINDER());
            // Granulometría
            Map<String, Object> granulometriaData = new HashMap<>();
            String tamicesJsonString = projection.getTAMICES();
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                TamicesData tamicesData = objectMapper.readValue(tamicesJsonString, TamicesData.class);
                granulometriaData.put("tamices", tamicesData);
                granulometriaData.put("acum", projection.getacum());
                granulometriaData.put("arena", projection.getarena());
                granulometriaData.put("finos", projection.getfinos());
                granulometriaData.put("grava", projection.getgrava());
                granulometriaData.put("pasa", projection.getpasa());
                granulometriaData.put("retenido", projection.getretenido());
                granulometriaData.put("sucs_data", projection.getsucs_data());
                granulometriaData.put("total", projection.gettotal());
                granulometriaData.put("id", projection.getID());
                granulometriaData.put("muestra_id", projection.getMUESTRA_ID());
            } catch (Exception e) {
                e.printStackTrace();
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
            // Liquido
            Map<String, Object> liquidoData = new HashMap<>();
            liquidoData.put("numberOfStrokes", projection.getNUMBER_OF_STROKES());
            liquidoData.put("tareNumberEL", projection.getTARE_NUMBER_EL());
            liquidoData.put("tareWeightEL", projection.getTARE_WEIGHT_EL());
            liquidoData.put("tarePlusWetSoilWeightEL", projection.getTARE_PLUS_WET_SOIL_WEIGHT_EL());
            liquidoData.put("tarePlusDrySoilEL", projection.getTARE_PLUS_DRY_SOIL_EL());
            liquidoData.put("waterWeightEL", projection.getWATER_WEIGHT_EL());
            liquidoData.put("drySoilWeightEL", projection.getDRY_SOIL_WEIGHT_EL());
            liquidoData.put("humidityEL", projection.getHUMIDITY_EL());
            liquidoData.put("limite_liquido", projection.getlimite_liquido());
            liquidoData.put("numeroPruebaEL", projection.getNUMERO_PRUEBA_EL());
            // Plastico
            Map<String, Object> plasticoData = new HashMap<>();
            plasticoData.put("tareNumber", projection.getTARE_NUMBER());
            plasticoData.put("tareWeight", projection.getTARE_WEIGHT());
            plasticoData.put("tarePlusWetSoilWeight", projection.getTARE_PLUS_WET_SOIL_WEIGHT());
            plasticoData.put("tarePlusDrySoil", projection.getTARE_PLUS_DRY_SOIL());
            plasticoData.put("drySoilWeight", projection.getDRY_SOIL_WEIGHT());
            plasticoData.put("waterWeight", projection.getWATER_WEIGHT());
            plasticoData.put("humidity", projection.getHUMIDITY());
            plasticoData.put("observation", projection.getOBSERVATION());
            plasticoData.put("numeroPrueba", projection.getNUMERO_PRUEBA());
            plasticoData.put("limite_plastico", projection.getlimite_plastico());
            //General Structure

            if(count==1){
                dataMap.put("header", headerData);
                dataMap.put("humedad", humedadData);
                dataMap.put("granulometria", granulometriaData);
                plasticoDataList.add(plasticoData);
                arrayData.add(dataMap);
            }

            if(count==2){
                liquidoDataList.add(liquidoData);
            }
            if(count==4){
                plasticoDataList.add(plasticoData);
                liquidoDataList.add(liquidoData);
                dataMap.put("plastico", plasticoDataList);
                arrayData.add(dataMap);
            }
            if(count==6){
                liquidoDataList.add(liquidoData);
                dataMap.put("liquido", liquidoDataList);
                arrayData.add(dataMap);
            }
//            plasticoDataList = plasticoDataList.stream()
//                    .filter(item -> item.get("numeroPrueba") == null || item.get("numeroPrueba").equals(1) || item.get("numeroPrueba").equals(2))
//                    .distinct()
//                    .collect(Collectors.toList());
//
//// Eliminar duplicados en liquidoDataList basados en numeroPruebaEL
//            liquidoDataList = liquidoDataList.stream()
//                    .filter(item -> item.get("numeroPruebaEL") == null || (item.get("numeroPruebaEL").equals(1) || item.get("numeroPruebaEL").equals(2) || item.get("numeroPruebaEL").equals(3)))
//                    .distinct()
//                    .collect(Collectors.toList());
            System.out.println(liquidoData+" Liquido"+count+"\n");
            System.out.println(plasticoData+" PLastico");
            count=count+1;
        }

        return ResponseEntity.ok(arrayData);
    }

    @PostMapping
    public ResponseEntity<ProjectEntity> createProject(@RequestBody ProjectEntity project) {
        ProjectEntity createdProject = projectService.create(project);
        return new ResponseEntity<ProjectEntity>(createdProject, HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<ProjectEntity> update(@RequestBody ProjectEntity project) {
        return ResponseEntity.ok(projectService.update(project));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        projectService.delete(id);
        return ResponseEntity.ok().build();
    }
}
