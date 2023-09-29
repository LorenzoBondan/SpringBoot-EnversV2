package com.metaway.AuditoriaV2.repositories;

import com.metaway.AuditoriaV2.entities.Uf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UfRepository extends JpaRepository<Uf, Integer> {
    Uf findByCduf(Integer cduf);
    Boolean existsByCduf(Integer cduf);
    void deleteByCduf(Integer cduf);

    @Query(nativeQuery = true, value = "SELECT * from uf WHERE deleted = false")
    List<Uf> findAllNotDeleted();
}
