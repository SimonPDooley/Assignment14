package com.coderscampus.Assignment14.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coderscampus.Assignment14.domain.Message;
import com.coderscampus.Assignment14.domain.User;
import com.coderscampus.Assignment14.service.MessageService;

@Controller
public class MessageController {
	
	@Autowired
	MessageService messageService;
	
	@PostMapping("/sendMessage")
	@ResponseBody
	public boolean postSendMessage (@RequestBody User user) {
		
		List<Message> messages = messageService.getMessages();
		System.out.println(user.getUsername() +": "+ user.getMessages().get(0).getMessage());
		for(Message message: messages) {
			System.out.println(message.getMessage());
		}

		messageService.sendMessage(user);
		
		return true;
	}
	
	@GetMapping("/getMessages")
	@ResponseBody
	public boolean getMessages (ModelMap model) {
		
		List<Message> messages = messageService.getMessages();
		model.put("messages", messages);
		
		return true;
	}

}
