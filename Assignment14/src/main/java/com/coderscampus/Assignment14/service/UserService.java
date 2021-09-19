package com.coderscampus.Assignment14.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.Assignment14.domain.User;
import com.coderscampus.Assignment14.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepo;

	public void addUser(String username) {
		User user = new User();
		user.setUsername(username);
		userRepo.save(user);
		
	}

}
