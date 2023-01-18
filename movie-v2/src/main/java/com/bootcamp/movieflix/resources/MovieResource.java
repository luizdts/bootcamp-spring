package com.bootcamp.movieflix.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.SortDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.movieflix.dto.MovieCardDTO;
import com.bootcamp.movieflix.dto.MovieDetailsDTO;
import com.bootcamp.movieflix.dto.ReviewDTO;
import com.bootcamp.movieflix.services.MovieService;
import com.bootcamp.movieflix.services.ReviewService;

@RestController
@RequestMapping(value="/movies")
public class MovieResource {

	@Autowired
	private MovieService service;
	
	@Autowired
	private ReviewService reviewService;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<MovieDetailsDTO> findById(@PathVariable Long id){
		MovieDetailsDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}
	
	@GetMapping(value="/{movieId}/reviews")
	public ResponseEntity<List<ReviewDTO>> findMovieReviews(@PathVariable Long movieId){
		List<ReviewDTO> list = reviewService.findByMovie(movieId);
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping
	public ResponseEntity<Page<MovieCardDTO>> findByMoviePerGenre(
			@SortDefault(sort="title") Pageable pageable,
			@RequestParam(value="genreId", defaultValue="0") Long genreId,
			@RequestParam(value="title", defaultValue="") String title){

		Page<MovieCardDTO> list = service.findByMovieGenre(genreId, title.trim(), pageable);
		return ResponseEntity.ok().body(list);
	}
}
