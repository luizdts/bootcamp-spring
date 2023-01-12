package com.bootcamp.learnbds.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootcamp.learnbds.entities.Reply;

public interface ReplyRepository extends JpaRepository<Reply, Long>{

}
