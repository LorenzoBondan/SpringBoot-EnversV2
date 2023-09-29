package com.metaway.AuditoriaV2.dto;

import com.metaway.AuditoriaV2.entities.Uf;

import java.io.Serializable;
import java.time.LocalDateTime;

public class UfDTO implements Serializable {
    private Integer cduf;
    private String dsuf;
    private String sguf;
    private Integer cdpais;
    private Integer codext;
    private boolean deleted;
    private String createdBy;
    private LocalDateTime creationDate;
    private String lastUpdatedBy;
    private LocalDateTime lastUpdatedDate;

    public UfDTO(){}

    public UfDTO(Integer cduf, String dsuf, String sguf, Integer cdpais, Integer codext,
                 boolean deleted, String createdBy, LocalDateTime creationDate, String lastUpdatedBy, LocalDateTime lastUpdatedDate) {
        this.cduf = cduf;
        this.dsuf = dsuf;
        this.sguf = sguf;
        this.cdpais = cdpais;
        this.codext = codext;
        this.deleted = deleted;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.lastUpdatedBy = lastUpdatedBy;
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public UfDTO(Uf entity){
        this.cduf = entity.getCduf();
        this.dsuf = entity.getDsuf();
        this.sguf = entity.getSguf();
        this.cdpais = entity.getPais().getCdpai();
        this.codext = entity.getCodext();
        this.deleted = entity.isDeleted();
        this.createdBy = entity.getCreatedBy();
        this.creationDate = entity.getCreationDate();
        this.lastUpdatedBy = entity.getLastUpdatedBy();
        this.lastUpdatedDate = entity.getLastUpdatedDate();
    }

    public Integer getCduf() {
        return cduf;
    }

    public void setCduf(Integer cduf) {
        this.cduf = cduf;
    }

    public String getDsuf() {
        return dsuf;
    }

    public void setDsuf(String dsuf) {
        this.dsuf = dsuf;
    }

    public String getSguf() {
        return sguf;
    }

    public void setSguf(String sguf) {
        this.sguf = sguf;
    }

    public Integer getCdpais() {
        return cdpais;
    }

    public void setCdpais(Integer cdpais) {
        this.cdpais = cdpais;
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
}
