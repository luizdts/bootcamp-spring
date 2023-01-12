package com.bootcamp.learnbds.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootcamp.learnbds.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

}
