package com.ingeocimyc.lab.service;

import com.ingeocimyc.lab.persistence.entity.*;
import com.ingeocimyc.lab.persistence.projection.ProjectProjection;
import com.ingeocimyc.lab.persistence.repository.*;
import jakarta.persistence.EntityNotFoundException;
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

    public ProjectEntity create(ProjectEntity project) {
        ProjectEntity savedProject = projectRepository.save(project);
        createProbesForProject(savedProject, (short) 0);
        return savedProject;
    }
    public ProjectEntity update(ProjectEntity newProject) {
        Integer id =newProject.getId();
        ProjectEntity oldProject = projectRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("not found with ID: " + id));

        oldProject.setTitle(newProject.getTitle());
        oldProject.setLocation(newProject.getLocation());
        oldProject.setReference(newProject.getReference());
        oldProject.setSolicitante(newProject.getSolicitante());
        oldProject.setSolicitante_id(newProject.getSolicitante_id());
        oldProject.setUser_id(newProject.getUser_id());
        oldProject.setDate(newProject.getDate());
        oldProject.setUser(newProject.getUser());

        if(oldProject.getProbes() < newProject.getProbes()) {
            short probes=oldProject.getProbes();
            oldProject.setProbes(newProject.getProbes());
            createProbesForProject(oldProject,probes);
        }
        return projectRepository.save(oldProject);
    }

    private void createProbesForProject(@NotNull ProjectEntity project, short index) {
        System.out.println(project);
        short numProbes = project.getProbes();
        short i = (short) (index+1);
        for (; i <= numProbes; i++) {
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
