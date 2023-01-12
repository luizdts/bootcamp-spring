package com.bootcamp.learnbds.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bootcamp.learnbds.dto.NotificationDTO;
import com.bootcamp.learnbds.entities.Notification;
import com.bootcamp.learnbds.entities.User;
import com.bootcamp.learnbds.repositories.NotificationRepository;

@Service
public class NotificationService {
	
	@Autowired
	private NotificationRepository repository;
	
	@Autowired
	private AuthService authService;
	
	@Transactional
	public Page<NotificationDTO> notificationForCurrentUser(boolean unreadOnly, Pageable pageable){
		User user = authService.authenticated();
		Page<Notification> page = repository.find(user, unreadOnly, pageable);
		
		return page.map(x -> new NotificationDTO(x));
	}
}
