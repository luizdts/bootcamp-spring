package com.bootcamp.learnbds.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootcamp.learnbds.entities.Topic;

public interface TopicRepository extends JpaRepository<Topic, Long>{

}
