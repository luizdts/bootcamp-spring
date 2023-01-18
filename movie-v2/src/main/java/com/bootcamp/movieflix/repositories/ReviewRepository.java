package com.bootcamp.movieflix.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootcamp.movieflix.entities.Movie;
import com.bootcamp.movieflix.entities.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {

	List<Review> findByMovie(Movie movie);

}
