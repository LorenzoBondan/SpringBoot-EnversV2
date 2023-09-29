package com.metaway.AuditoriaV2.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.metaway.AuditoriaV2.dto.UfDTO;
import com.metaway.AuditoriaV2.dto.UfMinDTO;
import com.metaway.AuditoriaV2.entities.Uf;
import com.metaway.AuditoriaV2.repositories.PaisRepository;
import com.metaway.AuditoriaV2.repositories.UfRepository;
import com.metaway.AuditoriaV2.services.exceptions.DataBaseException;
import com.metaway.AuditoriaV2.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UfService {

    @Autowired
    private UfRepository repository;

    @Autowired
    private PaisRepository paisRepository;

    @Autowired
    private AuthService authService;

    @Autowired
    private T_historyService tHistoryService;

    @Transactional(readOnly = true)
    public List<UfMinDTO> findAll(){
        return repository.findAll().stream().map(UfMinDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public List<UfMinDTO> findAllNotDeleted(){
        return repository.findAllNotDeleted().stream().map(UfMinDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public UfMinDTO findById(Integer cduf){
        Uf entity = repository.findByCduf(cduf);
        return new UfMinDTO(entity);
    }

    @Transactional
    public UfDTO insert(UfDTO dto) throws JsonProcessingException {
        Uf entity = new Uf();
        entity.setCduf(305);
        copyDtoToEntity(dto, entity);
        setCreationInfo(entity);
        repository.save(entity);
        tHistoryService.saveThistory("insert", "uf");
        return new UfDTO(entity);
    }

    @Transactional
    public UfDTO update(Integer id, UfDTO dto) throws JsonProcessingException{
        Uf entity = repository.findByCduf(id);
        copyDtoToEntity(dto, entity);
        setLastUpdateInfo(entity);
        repository.save(entity);
        tHistoryService.saveThistory("update", "uf");
        return new UfDTO(entity);
    }

    @Transactional
    public void delete(Integer id) {
        if(!repository.existsByCduf(id)){
            throw new ResourceNotFoundException("Id not found " + id);
        }
        try{
            setLastUpdateInfo(repository.findByCduf(id));
            repository.deleteByCduf(id);
            tHistoryService.saveThistory("update", "uf");
        } catch (DataIntegrityViolationException | JsonProcessingException e){
            throw new DataBaseException("Integrity violation");
        }
    }

    private void copyDtoToEntity(UfDTO dto, Uf entity){
        entity.setDsuf(dto.getDsuf());
        entity.setSguf(dto.getSguf());
        entity.setCodext(dto.getCodext());
        entity.setPais(paisRepository.findByCdpai(dto.getCdpais()));
    }

    private void setCreationInfo(Uf entity){
        entity.setCreatedBy(authService.authenticated().getEmail());
        entity.setCreationDate(LocalDateTime.now());
        entity.setLastUpdatedBy(authService.authenticated().getEmail());
        entity.setLastUpdatedDate(LocalDateTime.now());
    }

    private void setLastUpdateInfo(Uf entity){
        entity.setLastUpdatedBy(authService.authenticated().getEmail());
        entity.setLastUpdatedDate(LocalDateTime.now());
    }
}
