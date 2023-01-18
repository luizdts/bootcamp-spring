package com.bootcamp.movieflix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootcamp.movieflix.entities.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long>{

}
