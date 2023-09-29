package com.metaway.AuditoriaV2.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.metaway.AuditoriaV2.dto.PaisDTO;
import com.metaway.AuditoriaV2.dto.PaisMinDTO;
import com.metaway.AuditoriaV2.dto.UfDTO;
import com.metaway.AuditoriaV2.entities.Pais;
import com.metaway.AuditoriaV2.entities.Uf;
import com.metaway.AuditoriaV2.repositories.PaisRepository;
import com.metaway.AuditoriaV2.repositories.UfRepository;
import com.metaway.AuditoriaV2.services.exceptions.DataBaseException;
import com.metaway.AuditoriaV2.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class PaisService {

    @Autowired
    private PaisRepository repository;

    @Autowired
    private UfRepository ufRepository;

    @Autowired
    private T_historyService tHistoryService;

    @Autowired
    private AuthService authService;

    @Transactional(readOnly = true)
    public List<PaisMinDTO> findAll(){
        return repository.findAll().stream().map(PaisMinDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public List<PaisMinDTO> findAllNotDeleted(){
        return repository.findAllNotDeleted().stream().map(PaisMinDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public PaisMinDTO findById(Integer id){
        Pais entity = repository.findByCdpai(id);
        return new PaisMinDTO(entity);
    }

    @Transactional
    public PaisDTO insert(PaisDTO dto) throws JsonProcessingException {
        Pais entity = new Pais();
        entity.setCdpai(264); // não é autoincrementável no banco
        copyDtoToEntity(dto, entity);
        setCreationInfo(entity);
        repository.save(entity);
        tHistoryService.saveThistory("insert", "pais");
        return new PaisDTO(entity);
    }

    @Transactional
    public PaisDTO update(Integer id, PaisDTO dto) throws JsonProcessingException {
        Pais entity = repository.findByCdpai(id);
        copyDtoToEntity(dto, entity);
        setLastUpdateInfo(entity);
        entity = repository.save(entity);
        tHistoryService.saveThistory("update", "pais");
        return new PaisDTO(entity);
    }

    @Transactional
    public void delete(Integer id){
        if (!repository.existsByCdpai(id)) {
            throw new ResourceNotFoundException("Id not found: " + id);
        }
        try{
            setLastUpdateInfo(repository.findByCdpai(id));
            repository.deleteByCdpai(id);
            tHistoryService.saveThistory("update", "pais"); // soft delete
        } catch(DataIntegrityViolationException e) {
            throw new DataBaseException("Integrity violation");
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private void copyDtoToEntity(PaisDTO dto, Pais entity){
        entity.setDspai(dto.getDspai());
        entity.setNacionalidade_m(dto.getNacionalidade_m());
        entity.setNacionalidade_f(dto.getNacionalidade_f());
        entity.setCodext(dto.getCodext());

        entity.getUfs().clear();
        for(UfDTO ufDto : dto.getUfs()){
            Uf uf = ufRepository.findByCduf(ufDto.getCduf());
            entity.getUfs().add(uf);
        }
    }

    private void setCreationInfo(Pais entity){
        entity.setCreatedBy(authService.authenticated().getEmail());
        entity.setCreationDate(LocalDateTime.now());
        entity.setLastUpdatedBy(authService.authenticated().getEmail());
        entity.setLastUpdatedDate(LocalDateTime.now());
    }

    private void setLastUpdateInfo(Pais entity){
        entity.setLastUpdatedBy(authService.authenticated().getEmail());
        entity.setLastUpdatedDate(LocalDateTime.now());
    }
}
