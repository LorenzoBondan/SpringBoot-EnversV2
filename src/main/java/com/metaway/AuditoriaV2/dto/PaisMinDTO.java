package com.metaway.AuditoriaV2.dto;

import com.metaway.AuditoriaV2.entities.Pais;

import java.io.Serializable;

public class PaisMinDTO implements Serializable {
    private Integer cdpai;
    private String dspai;
    private Integer codext;
    private String nacionalidade_f;
    private String nacionalidade_m;

    public PaisMinDTO(){}

    public PaisMinDTO(Pais entity){
        this.cdpai = entity.getCdpai();
        this.dspai = entity.getDspai();
        this.codext = entity.getCodext();
        this.nacionalidade_f = entity.getNacionalidade_f();
        this.nacionalidade_m = entity.getNacionalidade_m();
    }

    public PaisMinDTO(Integer cdpai, String dspai, Integer codext, String nacionalidade_f, String nacionalidade_m) {
        this.cdpai = cdpai;
        this.dspai = dspai;
        this.codext = codext;
        this.nacionalidade_f = nacionalidade_f;
        this.nacionalidade_m = nacionalidade_m;
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

    public Integer getCodext() {
        return codext;
    }

    public void setCodext(Integer codext) {
        this.codext = codext;
    }

    public String getNacionalidade_f() {
        return nacionalidade_f;
    }

    public void setNacionalidade_f(String nacionalidade_f) {
        this.nacionalidade_f = nacionalidade_f;
    }

    public String getNacionalidade_m() {
        return nacionalidade_m;
    }

    public void setNacionalidade_m(String nacionalidade_m) {
        this.nacionalidade_m = nacionalidade_m;
    }
}
