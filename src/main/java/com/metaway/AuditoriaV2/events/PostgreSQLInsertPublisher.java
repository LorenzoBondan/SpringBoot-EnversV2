package com.metaway.AuditoriaV2.events;

import com.metaway.AuditoriaV2.entities.T_history;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class PostgreSQLInsertPublisher {

    private final ApplicationEventPublisher eventPublisher;

    public PostgreSQLInsertPublisher(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    @Async
    public void publishEvent(T_history t_history){
        PostgreSQLInsertEvent event = new PostgreSQLInsertEvent(this, t_history);
        eventPublisher.publishEvent(event);
    }
}
