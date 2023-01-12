package com.bootcamp.learnbds.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootcamp.learnbds.entities.Section;

public interface SectionRepository extends JpaRepository<Section, Long>{

}
