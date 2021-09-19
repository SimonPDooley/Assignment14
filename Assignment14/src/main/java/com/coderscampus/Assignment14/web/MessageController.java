package com.coderscampus.Assignment14.web;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	public boolean postSendMessage (@RequestBody Message message) {
		
		messageService.sendMessage(message);
		

		//List<Message> messages = messageService.getMessages();
		System.out.println(message.getUser() +": "+ message.getMessage());

		return true;
	}
	
	@GetMapping("/getMessages")
	@ResponseBody
	public List<Message> getMessages () {
		List<Message> messages = messageService.getMessages();

		//System.out.println(user.getUsername() +": "+ user.getMessages().get(0).getMessage());

		Message message2 = new Message();
		message2.setMessage("qwe21d");
		message2.setMessageId(3);
		message2.setUser("goober");
		
		Message message1 = new Message();
		message1.setMessage("asdasd");
		message1.setMessageId(4);
		message1.setUser("Bagool");
		messages.add(message1);
		messages.add(message2);
		
		return messages;
	
	}

}
