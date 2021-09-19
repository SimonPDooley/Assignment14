package com.coderscampus.Assignment14.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.coderscampus.Assignment14.domain.Channel;
import com.coderscampus.Assignment14.service.ChannelService;
import com.coderscampus.Assignment14.service.UserService;


@Controller
public class UserController {

	@Autowired
	ChannelService channelService;
	
	@Autowired
	UserService userService;
	
	@GetMapping("/welcome")
	public String getCreateUser (ModelMap model) {
		List<Channel>channels = channelService.getChannels();
		
		//model.put("user", new User());
		model.put("channels", channels);
		
		return "welcome";
	}
	
	@PostMapping("/welcome")
	public String postCreateUser (@RequestBody String username) {
		
		System.out.println(username);
		userService.addUser(username);
		
		return "redirect:/welcome";
	}
	
}
