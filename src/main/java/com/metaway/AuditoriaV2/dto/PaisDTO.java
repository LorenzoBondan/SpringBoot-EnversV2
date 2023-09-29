package com.metaway.AuditoriaV2.dto;

import com.metaway.AuditoriaV2.entities.Pais;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PaisDTO implements Serializable {

    private Integer cdpai;
    private String dspai;
    private Integer codext;
    private boolean deleted;
    private String nacionalidade_f;
    private String nacionalidade_m;
    private String createdBy;
    private LocalDateTime creationDate;
    private String lastUpdatedBy;
    private LocalDateTime lastUpdatedDate;

    private List<UfDTO> ufs = new ArrayList<>();

    public PaisDTO(){}

    public PaisDTO(Pais entity){
        this.cdpai = entity.getCdpai();
        this.dspai = entity.getDspai();
        this.nacionalidade_m = entity.getNacionalidade_m();
        this.nacionalidade_f = entity.getNacionalidade_f();
        this.codext = entity.getCodext();
        this.deleted = entity.isDeleted();
        this.createdBy = entity.getCreatedBy();
        this.creationDate = entity.getCreationDate();
        this.lastUpdatedBy = entity.getLastUpdatedBy();
        this.lastUpdatedDate = entity.getLastUpdatedDate();

        entity.getUfs().forEach(uf -> this.getUfs().add(new UfDTO(uf)));
    }

    public PaisDTO(Integer cdpai, String dspai, String nacionalidade_m, String nacionalidade_f, Integer codext,
                   boolean deleted, String createdBy, LocalDateTime creationDate, String lastUpdatedBy, LocalDateTime lastUpdateDate) {
        this.cdpai = cdpai;
        this.dspai = dspai;
        this.nacionalidade_m = nacionalidade_m;
        this.nacionalidade_f = nacionalidade_f;
        this.codext = codext;
        this.deleted = deleted;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.lastUpdatedBy = lastUpdatedBy;
        this.lastUpdatedDate = lastUpdateDate;
    }

    public Integer getCdpai() {
        return cdpai;
    }

    public void setCdpai(Integer cdpai) {
        this.cdpai = cdpai;
    }

    public String getDspai() {
        return dspai;
    }

    public void setDspai(String dspai) {
        this.dspai = dspai;
    }

    public String getNacionalidade_m() {
        return nacionalidade_m;
    }

    public void setNacionalidade_m(String nacionalidade_m) {
        this.nacionalidade_m = nacionalidade_m;
    }

    public String getNacionalidade_f() {
        return nacionalidade_f;
    }

    public void setNacionalidade_f(String nacionalidade_f) {
        this.nacionalidade_f = nacionalidade_f;
    }

    public Integer getCodext() {
        return codext;
    }

    public void setCodext(Integer codext) {
        this.codext = codext;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public LocalDateTime getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(LocalDateTime lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public List<UfDTO> getUfs() {
        return ufs;
    }
}
