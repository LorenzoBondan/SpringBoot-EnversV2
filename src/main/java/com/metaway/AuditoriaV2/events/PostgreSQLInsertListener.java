package com.metaway.AuditoriaV2.events;

import com.metaway.AuditoriaV2.entities.T_history;
import com.metaway.AuditoriaV2.repositories.T_historyRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class PostgreSQLInsertListener {

    @Autowired
    private T_historyRepository repository;

    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(PostgreSQLInsertListener.class);

    @EventListener
    public void handleThistoryRegister(PostgreSQLInsertEvent event){
        T_history t_history = event.getT_history();
        repository.save(t_history);
    }
}
