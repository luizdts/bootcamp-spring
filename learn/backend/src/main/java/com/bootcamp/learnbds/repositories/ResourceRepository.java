package com.bootcamp.learnbds.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootcamp.learnbds.entities.Resource;

public interface ResourceRepository extends JpaRepository<Resource, Long>{

}
