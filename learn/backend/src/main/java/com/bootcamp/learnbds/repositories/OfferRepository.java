package com.bootcamp.learnbds.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootcamp.learnbds.entities.Offer;

public interface OfferRepository extends JpaRepository<Offer, Long>{

}
