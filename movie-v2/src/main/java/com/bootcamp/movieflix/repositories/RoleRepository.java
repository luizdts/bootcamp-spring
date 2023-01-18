package com.bootcamp.movieflix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootcamp.movieflix.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
