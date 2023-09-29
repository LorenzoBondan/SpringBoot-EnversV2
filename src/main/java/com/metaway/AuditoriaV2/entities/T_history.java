package com.metaway.AuditoriaV2.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.Objects;

@Data
@Document
public class T_history {

    @Id
    private String id;
    private Instant tstamp;
    private String schemaname;
    private String tabname;
    private String operation;
    private String old_val;

    public T_history(){}

    public T_history(T_historyPostgres tHistoryPostgres){
        //id
        this.tstamp = tHistoryPostgres.getTstamp();
        this.schemaname = tHistoryPostgres.getSchemaname();
        this.tabname = tHistoryPostgres.getTabname();
        this.operation = tHistoryPostgres.getOperation();
        this.old_val = tHistoryPostgres.getOld_val();
    }

    public T_history(String id, Instant tstamp, String schemaname, String tabname, String operation, String old_val) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        T_history tHistory = (T_history) o;
        return Objects.equals(id, tHistory.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
