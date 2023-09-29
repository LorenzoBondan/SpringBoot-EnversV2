package com.metaway.AuditoriaV2.repositories;

import com.metaway.AuditoriaV2.entities.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PaisRepository extends JpaRepository<Pais, Integer> {
    Pais findByCdpai(Integer cdpai);

    Boolean existsByCdpai(Integer cdpai);

    void deleteByCdpai(Integer cdpai);

    @Query(nativeQuery = true, value = """
            SELECT * FROM pais WHERE deleted = false
            """)
    List<Pais> findAllNotDeleted();
}
