package com.metaway.AuditoriaV2.repositories;

import com.metaway.AuditoriaV2.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
