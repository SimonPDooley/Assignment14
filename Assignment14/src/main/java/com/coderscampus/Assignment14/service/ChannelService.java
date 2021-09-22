package com.coderscampus.Assignment14.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.Assignment14.domain.Channel;
import com.coderscampus.Assignment14.repository.ChannelRepository;

@Service
public class ChannelService {
	
	@Autowired
	ChannelRepository channelRepo;
	
	public List<Channel> getChannels() {
		
		List<Channel> channels = new ArrayList<Channel>();
		//Create a General and Private Channel if there are no channels
		if(channelRepo.count() > 0){
			channels = channelRepo.findAll();
			return channels;
		}
		else {
			Channel generalChannel = new Channel();
			generalChannel.setChannelName("General");
			channels.add(generalChannel);
			channelRepo.save(generalChannel);
			Channel privateChannel = new Channel();
			privateChannel.setChannelName("Private");
			channels.add(privateChannel);
			channelRepo.save(privateChannel);
			return channels;
		}
	}

	public Channel findChannelById(Channel channel) {
		channel = channelRepo.getById(channel.getChannelId());
		return channel;
	}

	public void addChannel(String channelName) {
		Channel channel = new Channel();
		channel.setChannelName(channelName);
		channelRepo.save(channel);
	}
}
