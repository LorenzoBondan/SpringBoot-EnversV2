package com.metaway.AuditoriaV2.dto;

import com.metaway.AuditoriaV2.entities.T_history;

import java.io.Serializable;
import java.time.Instant;

public class T_historyDTO implements Serializable {
    private String id;
    private Instant tstamp;
    private String schemaname;
    private String tabname;
    private String operation;
    private String old_val;

    public T_historyDTO(){}

    public T_historyDTO(T_history entity){
        this.id = entity.getId();
        this.tstamp = entity.getTstamp();
        this.schemaname = entity.getSchemaname();
        this.tabname = entity.getTabname();
        this.operation = entity.getOperation();
        this.old_val = entity.getOld_val();
    }

    public T_historyDTO(String id, Instant tstamp, String schemaname, String tabname, String operation, String old_val) {
        this.id = id;
        this.tstamp = tstamp;
        this.schemaname = schemaname;
        this.tabname = tabname;
        this.operation = operation;
        this.old_val = old_val;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Instant getTstamp() {
        return tstamp;
    }

    public void setTstamp(Instant tstamp) {
        this.tstamp = tstamp;
    }

    public String getSchemaname() {
        return schemaname;
    }

    public void setSchemaname(String schemaname) {
        this.schemaname = schemaname;
    }

    public String getTabname() {
        return tabname;
    }

    public void setTabname(String tabname) {
        this.tabname = tabname;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getOld_val() {
        return old_val;
    }

    public void setOld_val(String old_val) {
        this.old_val = old_val;
    }
}
