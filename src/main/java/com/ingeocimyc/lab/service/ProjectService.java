package com.ingeocimyc.lab.service;

import com.ingeocimyc.lab.persistence.entity.*;
import com.ingeocimyc.lab.persistence.projection.ProjectProjection;
import com.ingeocimyc.lab.persistence.repository.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {
    public final ProjectRepository projectRepository;
    public final SondeoRepository sondeoRepository;
    public final SolicitanteRepository solicitanteRepository;
    public final UserRepository userRepository;
    public final MuestraRepository muestraRepository;
    public final ProjectPageSortRepository projectPageSortRepository;


    public ProjectService(ProjectRepository projectRepository, SondeoRepository sondeoRepository, SolicitanteRepository solicitanteRepository, UserRepository userRepository, MuestraRepository muestraRepository, ProjectPageSortRepository projectPageSortRepository) {
        this.projectRepository = projectRepository;
        this.sondeoRepository = sondeoRepository;
        this.solicitanteRepository = solicitanteRepository;
        this.userRepository = userRepository;
        this.muestraRepository = muestraRepository;
        this.projectPageSortRepository = projectPageSortRepository;
    }
    public Page<ProjectEntity> getAll(int page, int elements,String sortBy, String sortDirection){
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection),sortBy);
        return projectPageSortRepository.findAll(PageRequest.of(page,elements,sort));
    }
    public Optional<ProjectEntity> getById(int id){
        return this.projectRepository.findById(id);
    }
    public List<ProjectProjection> getProjectDetails(Integer projectId, Integer probeId, Integer muestraId) {
        return projectRepository.getProjectDetails(projectId, probeId, muestraId);
    }

    public ProjectEntity createProject(ProjectEntity project) {
        ProjectEntity savedProject = projectRepository.save(project);
        createProbesForProject(savedProject);
        return savedProject;
    }

    private void createProbesForProject(@NotNull ProjectEntity project) {
        System.out.println(project);
        short numProbes = project.getProbes();
        for (short i = 1; i <= numProbes; i++) {
            SondeoEntity sondeo = new SondeoEntity();
            MuestraEntity muestra = new MuestraEntity();
            sondeo.setProject(project);
            sondeo.setProbe(i);
            sondeo.setProject_id(project.getId());
            SondeoEntity sondeoSave= sondeoRepository.save(sondeo);
            muestra.setSondeo(sondeoSave);
            muestra.setSondeo_id(sondeoSave.getId());
            short j=1;
            muestra.setMuestra(j);
            muestraRepository.save(muestra);
        }
    }
    public void delete(int id){
        projectRepository.deleteById(id);
    }

}
