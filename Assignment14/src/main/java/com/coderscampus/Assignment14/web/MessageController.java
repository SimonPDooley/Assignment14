package com.coderscampus.Assignment14.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coderscampus.Assignment14.domain.Message;
import com.coderscampus.Assignment14.service.MessageService;

@Controller
public class MessageController {
	
	@Autowired
	MessageService messageService;
	
	@PostMapping("/sendMessage")
	@ResponseBody
	public boolean postSendMessage (@RequestBody Message message) {
		messageService.sendMessage(message);
		return true;
	}
	
	@GetMapping("/getMessages")
	@ResponseBody
	public List<Message> getMessages () {
		List<Message> messages = messageService.getMessages();
		return messages;
	}
}
