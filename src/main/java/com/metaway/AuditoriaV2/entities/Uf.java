package com.metaway.AuditoriaV2.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "uf")
@SQLDelete(sql = "UPDATE uf SET deleted = TRUE WHERE cduf=?")
public class Uf implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private Integer cduf;
    private String dsuf;
    private String sguf;
    @ManyToOne
    @JoinColumn(name = "cdpais")
    private Pais pais;
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

    public Uf(){}

    public Uf(Integer cduf, String dsuf, String sguf, Pais pais, Integer codext, 
              boolean deleted, String createdBy, LocalDateTime creationDate, String lastUpdatedBy, LocalDateTime lastUpdatedDate) {
        this.cduf = cduf;
        this.dsuf = dsuf;
        this.sguf = sguf;
        this.pais = pais;
        this.codext = codext;
        this.deleted = deleted;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.lastUpdatedBy = lastUpdatedBy;
        this.lastUpdatedDate = lastUpdatedDate;
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

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Uf uf = (Uf) o;
        return Objects.equals(cduf, uf.cduf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cduf);
    }
}
