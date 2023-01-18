package com.bootcamp.movieflix.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bootcamp.movieflix.dto.ReviewDTO;
import com.bootcamp.movieflix.entities.Movie;
import com.bootcamp.movieflix.entities.Review;
import com.bootcamp.movieflix.entities.User;
import com.bootcamp.movieflix.repositories.MovieRepository;
import com.bootcamp.movieflix.repositories.ReviewRepository;
import com.bootcamp.movieflix.services.exceptions.DatabaseException;
import com.bootcamp.movieflix.services.exceptions.ResourceNotFoundException;

@Service
public class ReviewService {
	
	@Autowired
	private ReviewRepository repository;
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private AuthService authService;
	
	@Transactional(readOnly = true)
	public List<ReviewDTO> findByMovie(Long movieId){
		try {
			Movie movie = movieRepository.getOne(movieId);
			List<Review> list = repository.findByMovie(movie);
			return list.stream().map(x -> new ReviewDTO(x)).collect(Collectors.toList());
		} catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found " + movieId);
		}
	}
	
	@Transactional(readOnly=true)
	public ReviewDTO insert(ReviewDTO dto) {
		User user = authService.authenticated();
		
		try {
			Review entity = new Review();
			entity.setMovie(movieRepository.getOne(dto.getMovieId()));
			entity.setUser(user);
			entity.setText(dto.getText());
			
			repository.save(entity);
			
			return new ReviewDTO(entity);
			
		} catch(DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation - Id movie not found " + dto.getMovieId());
		}
	}
}
