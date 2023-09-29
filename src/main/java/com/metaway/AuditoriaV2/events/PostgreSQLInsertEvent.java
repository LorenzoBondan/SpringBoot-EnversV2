package com.metaway.AuditoriaV2.events;

import com.metaway.AuditoriaV2.entities.T_history;
import org.springframework.context.ApplicationEvent;

public class PostgreSQLInsertEvent extends ApplicationEvent {

    private T_history t_history;

    public PostgreSQLInsertEvent(Object source, T_history t_history) {
        super(source);
        this.t_history = t_history;
    }

    public T_history getT_history() {
        return t_history;
    }

    public void setT_history(T_history t_history) {
        this.t_history = t_history;
    }
}
