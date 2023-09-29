package com.metaway.AuditoriaV2.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "t_history")
public class T_historyPostgres implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant tstamp;
    @Column(columnDefinition = "TEXT")
    private String schemaname;
    @Column(columnDefinition = "TEXT")
    private String tabname;
    @Column(columnDefinition = "TEXT")
    private String operation;
    @JdbcTypeCode(SqlTypes.JSON)
    private String old_val;

    public T_historyPostgres(){}

    public T_historyPostgres(T_history t_history){
        //id
        this.tstamp = t_history.getTstamp();
        this.schemaname = t_history.getSchemaname();
        this.tabname = t_history.getTabname();
        this.operation = t_history.getOperation();
        this.old_val = t_history.getOld_val();
    }

    public T_historyPostgres(Integer id, Instant tstamp, String schemaname, String tabname, String operation, String old_val) {
        this.id = id;
        this.tstamp = tstamp;
        this.schemaname = schemaname;
        this.tabname = tabname;
        this.operation = operation;
        this.old_val = old_val;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
        T_historyPostgres that = (T_historyPostgres) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
