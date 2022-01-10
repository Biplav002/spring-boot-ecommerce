package com.luv2code.ecommerce.dao;

import java.util.Optional;

import com.luv2code.ecommerce.entity.Role;
import com.luv2code.ecommerce.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByRoleName(Roles role);
}