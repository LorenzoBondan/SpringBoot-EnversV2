package com.metaway.AuditoriaV2.repositories;

import com.metaway.AuditoriaV2.entities.T_historyPostgres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface T_historyPostgresRepository extends JpaRepository<T_historyPostgres, Integer> {

    @Query(nativeQuery = true, value = """
            SELECT * from t_history t
            WHERE t.tabname LIKE :tabname
            AND UPPER(t.operation) LIKE UPPER(:operation)
            ORDER BY t.tstamp DESC
            LIMIT 1
            """)
    T_historyPostgres findByOperationAndTabname(
            @Param("tabname") String tabname,
            @Param("operation") String operation);
}
