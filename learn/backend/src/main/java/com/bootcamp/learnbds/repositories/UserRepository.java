package com.bootcamp.learnbds.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootcamp.learnbds.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByEmail(String email);
}
