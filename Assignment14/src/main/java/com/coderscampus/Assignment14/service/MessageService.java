package com.coderscampus.Assignment14.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.Assignment14.domain.Message;
import com.coderscampus.Assignment14.domain.User;
import com.coderscampus.Assignment14.repository.MessageRepository;
import com.coderscampus.Assignment14.repository.UserRepository;

@Service
public class MessageService {
	
	@Autowired
	MessageRepository messageRepo;
	
	@Autowired
	UserRepository userRepo;

	public void sendMessage(User user) {
		Set<User> users = userRepo.getUsers();
		messageRepo.saveMessage(user, users);
		
	}

	public List<Message> getMessages() {
		List<Message> messages = messageRepo.getAllMessages();
		return messages;
	}
	
	

}
