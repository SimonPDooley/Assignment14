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

	public void sendMessage(Message message) {
		List<User> users = userRepo.findAll();
		
		List<Message> messages = messageRepo.findAll();

 	//	for(User existingUser : users) { 
		//	if(existingUser.getUsername().equals(message.getUser())) { 
		message.setMessageId(messages.size()+1);
				messages.add(message);
				messageRepo.saveAll(messages);
		//	}
	//	}
	}

	public List<Message> getMessages() {
			List<Message> messages =  messageRepo.findAll();
			return messages;
	}
}
