package com.metaway.AuditoriaV2.dto;

import com.metaway.AuditoriaV2.entities.Uf;

import java.io.Serializable;

public class UfMinDTO implements Serializable {
    private Integer cduf;
    private String dsuf;
    private String sguf;
    private Integer cdpais;
    private Integer codext;

    public UfMinDTO(){}

    public UfMinDTO(Uf entity){
        this.cduf = entity.getCduf();
        this.dsuf = entity.getDsuf();
        this.sguf = entity.getSguf();
        this.cdpais = entity.getPais().getCdpai();;
        this.codext = entity.getCodext();
    }

    public UfMinDTO(Integer cduf, String dsuf, String sguf, Integer cdpais, Integer codext) {
        this.cduf = cduf;
        this.dsuf = dsuf;
        this.sguf = sguf;
        this.cdpais = cdpais;
        this.codext = codext;
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
}
