package com.coderscampus.Assignment14.web;


import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.coderscampus.Assignment14.domain.Channel;
import com.coderscampus.Assignment14.domain.Message;
import com.coderscampus.Assignment14.service.ChannelService;
import com.coderscampus.Assignment14.service.MessageService;

@Controller
public class ChannelController {
	
@Autowired
ChannelService channelService;

@Autowired
MessageService messageService;
	

@GetMapping("/channels/{channelId}")
	public String getChannel (ModelMap model, Channel channel) {
		
		channel = channelService.findById(channel);
		List<Message> messages = messageService.getMessages();
		model.put("messages", messages);
		model.put("channel", channel);
		
		return "channel";
	}
}
