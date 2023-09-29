package com.metaway.AuditoriaV2.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.metaway.AuditoriaV2.entities.T_history;
import com.metaway.AuditoriaV2.entities.T_historyPostgres;
import com.metaway.AuditoriaV2.events.PostgreSQLInsertPublisher;
import com.metaway.AuditoriaV2.repositories.PaisRepository;
import com.metaway.AuditoriaV2.repositories.T_historyPostgresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class T_historyService {

    @Autowired
    private PostgreSQLInsertPublisher postgreSQLInsertPublisher;

    @Autowired
    private T_historyPostgresRepository tHistoryPostgresRepository;
    @Autowired
    private PaisRepository paisRepository;

    @Transactional
    public void saveThistory(String operation, String table) throws JsonProcessingException {
        T_historyPostgres tHistoryPostgres = tHistoryPostgresRepository.findByOperationAndTabname(table, operation);
        T_history t_history = new T_history(tHistoryPostgres);
        postgreSQLInsertPublisher.publishEvent(t_history);
    }
}
