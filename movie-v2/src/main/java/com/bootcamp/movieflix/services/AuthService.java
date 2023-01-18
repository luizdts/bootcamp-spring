package com.bootcamp.movieflix.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bootcamp.movieflix.entities.User;
import com.bootcamp.movieflix.repositories.UserRepository;
import com.bootcamp.movieflix.services.exceptions.ForbiddenException;
import com.bootcamp.movieflix.services.exceptions.UnauthorizedException;

@Service
public class AuthService {

	@Autowired
	private UserRepository userRepository;

	// Retornar entidade usuário autenticado
	@Transactional(readOnly = true)
	public User authenticated() {
		try {
			String username = SecurityContextHolder.getContext().getAuthentication().getName();
			return userRepository.findByEmail(username);
		} catch (Exception e) {
			throw new UnauthorizedException("Invalid user");
		}
	}

	// Lança exception se o usuário logado não for o proprio usuário que está logado ou adm
	public void validateSelfOrAdmin(Long userId) {
		User user = authenticated();
		if (!user.getId().equals(userId) && !user.hasRole("ROLE_ADMIN")) {
			throw new ForbiddenException("Access denied");
		}
	}

}
