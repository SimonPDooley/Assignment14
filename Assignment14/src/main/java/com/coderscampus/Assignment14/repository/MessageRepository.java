package com.coderscampus.Assignment14.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.coderscampus.Assignment14.domain.Message;
import com.coderscampus.Assignment14.domain.User;

@Repository
public class MessageRepository {
	
	List<Message> messages = new ArrayList<Message>();
	
	public void saveMessage(User user, Set<User> users) {
		Message message  = user.getMessages().get(0);

		for(User existingUser : users) { 
			if(existingUser.getUsername() == user.getUsername()) { 
				message.setUserId(existingUser.getUserId());
				message.setMessageId(messages.size()+1);
				messages.add(message);
				existingUser.getMessages().add(message);
			}
		}
	}

	public List<Message> getAllMessages() {
		return messages;	
	}

}
