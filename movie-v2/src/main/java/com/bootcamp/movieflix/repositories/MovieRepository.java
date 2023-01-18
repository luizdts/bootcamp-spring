package com.bootcamp.movieflix.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bootcamp.movieflix.entities.Genre;
import com.bootcamp.movieflix.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
	
	@Query("SELECT obj FROM Movie obj INNER JOIN obj.genre gen WHERE "
			+ "(:genre IS NULL OR gen = :genre) AND "
			+ "(:title = '' OR LOWER(obj.title) LIKE LOWER(CONCAT('%',:title,'%'))) ")
	Page<Movie> findByGenre(Genre genre, String title, Pageable pageable);
}
