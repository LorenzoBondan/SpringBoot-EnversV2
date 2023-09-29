package com.metaway.AuditoriaV2.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.metaway.AuditoriaV2.dto.UfDTO;
import com.metaway.AuditoriaV2.dto.UfMinDTO;
import com.metaway.AuditoriaV2.services.UfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/ufs")
public class UfController {

    @Autowired
    private UfService service;

    @GetMapping
    public ResponseEntity<List<UfMinDTO>> findAll(){
        List<UfMinDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/active")
    public ResponseEntity<List<UfMinDTO>> findAllNotDeleted(){
        List<UfMinDTO> list = service.findAllNotDeleted();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UfMinDTO> findById(@PathVariable Integer id){
        UfMinDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CLIENT')")
    @PostMapping
    public ResponseEntity<UfDTO> insert(@RequestBody UfDTO dto) throws JsonProcessingException {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{cduf}")
                .buildAndExpand(dto.getCduf()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CLIENT')")
    @PutMapping(value = "/{id}")
    public ResponseEntity<UfDTO> update(@PathVariable Integer id, @RequestBody UfDTO dto) throws JsonProcessingException {
        dto = service.update(id, dto);
        return ResponseEntity.ok().body(dto);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CLIENT')")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<UfDTO> delete(@PathVariable Integer id) throws JsonProcessingException {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
