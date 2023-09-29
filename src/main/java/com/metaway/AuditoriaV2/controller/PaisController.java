package com.metaway.AuditoriaV2.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.metaway.AuditoriaV2.dto.PaisDTO;
import com.metaway.AuditoriaV2.dto.PaisMinDTO;
import com.metaway.AuditoriaV2.services.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/paises")
public class PaisController {

    @Autowired
    private PaisService service;

    @GetMapping
    public ResponseEntity<List<PaisMinDTO>> findAll(){
        List<PaisMinDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/active")
    public ResponseEntity<List<PaisMinDTO>> findAllNotDeleted(){
        List<PaisMinDTO> list = service.findAllNotDeleted();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PaisMinDTO> findById(@PathVariable Integer id){
        PaisMinDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CLIENT')")
    @PostMapping
    public ResponseEntity<PaisDTO> insert(@RequestBody PaisDTO dto) throws JsonProcessingException {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{cdpai}")
                .buildAndExpand(dto.getCdpai()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CLIENT')")
    @PutMapping(value = "/{id}")
    public ResponseEntity<PaisDTO> update(@PathVariable Integer id, @RequestBody PaisDTO dto) throws JsonProcessingException {
        dto = service.update(id, dto);
        return ResponseEntity.ok().body(dto);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CLIENT')")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<PaisDTO> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
