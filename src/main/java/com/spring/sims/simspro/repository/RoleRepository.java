package com.spring.sims.simspro.repository;

import com.spring.sims.simspro.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRole(String role);
}
