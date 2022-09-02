package com.bootcamp.client.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.client.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

}
