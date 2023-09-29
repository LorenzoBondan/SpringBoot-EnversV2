package com.metaway.AuditoriaV2.repositories;

import com.metaway.AuditoriaV2.entities.T_history;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface T_historyRepository extends MongoRepository<T_history, String> {
}
