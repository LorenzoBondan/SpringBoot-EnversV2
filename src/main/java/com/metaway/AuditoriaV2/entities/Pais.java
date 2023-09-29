package com.metaway.AuditoriaV2.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "pais")
@SQLDelete(sql = "UPDATE pais SET deleted = TRUE WHERE cdpai=?")
public class Pais implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private Integer cdpai;
    private String dspai;
    @Column(name = "nacionalidade_f")
    private String nacionalidade_f;
    @Column(name = "nacionalidade_m")
    private String nacionalidade_m;
    private Integer codext;
    private boolean deleted = Boolean.FALSE;
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "creation_date", columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDateTime creationDate;
    @Column(name = "last_updated_by")
    private String lastUpdatedBy;
    @Column(name = "last_updated_date", columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDateTime lastUpdatedDate;

    @OneToMany(mappedBy = "pais")
    private List<Uf> ufs = new ArrayList<>();
    
    public Pais(){}

    public Pais(Integer cdpai, String dspai, String nacionalidade_m, String nacionalidade_f, Integer codext,
                boolean deleted, String createdBy, LocalDateTime creationDate, String lastUpdatedBy, LocalDateTime lastUpdatedDate) {
        this.cdpai = cdpai;
        this.dspai = dspai;
        this.nacionalidade_m = nacionalidade_m;
        this.nacionalidade_f = nacionalidade_f;
        this.codext = codext;
        this.deleted = deleted;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.lastUpdatedBy = lastUpdatedBy;
        this.lastUpdatedDate = lastUpdatedDate;
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

    public List<Uf> getUfs() {
        return ufs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pais pais = (Pais) o;
        return Objects.equals(cdpai, pais.cdpai);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cdpai);
    }
}
