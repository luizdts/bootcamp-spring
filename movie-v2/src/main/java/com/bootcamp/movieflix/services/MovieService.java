package com.bootcamp.movieflix.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bootcamp.movieflix.dto.MovieCardDTO;
import com.bootcamp.movieflix.dto.MovieDetailsDTO;
import com.bootcamp.movieflix.entities.Genre;
import com.bootcamp.movieflix.entities.Movie;
import com.bootcamp.movieflix.repositories.GenreRepository;
import com.bootcamp.movieflix.repositories.MovieRepository;
import com.bootcamp.movieflix.services.exceptions.ResourceNotFoundException;

@Service
public class MovieService {
	
	@Autowired
	private MovieRepository repository;
	
	@Autowired
	private GenreRepository genreRepository;
	
	@Transactional(readOnly=true)
	public MovieDetailsDTO findById(Long id) {
		Optional<Movie> obj = repository.findById(id);
		Movie entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new MovieDetailsDTO(entity);
	}
	
	@Transactional(readOnly=true)
	public Page<MovieCardDTO> findByMovieGenre(Long genreId, String title, Pageable pageable){
		Genre genre = (genreId == 0) ? null : genreRepository.getOne(genreId);
		Page<Movie> page = repository.findByGenre(genre, title, pageable);
		return page.map(x -> new MovieCardDTO(x));
	}
}
