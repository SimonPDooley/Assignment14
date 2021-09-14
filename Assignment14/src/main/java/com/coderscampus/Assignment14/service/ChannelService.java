package com.coderscampus.Assignment14.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.Assignment14.domain.Channel;
import com.coderscampus.Assignment14.repository.ChannelRepository;

@Service
public class ChannelService {
	
	@Autowired
	ChannelRepository channelRepo;

	public Set<Channel> getGeneralChannel() {
		Set<Channel> channels = channelRepo.CreateChannelList();
		return channels;
	}

	public Channel findById(Channel channel) {
			channel = channelRepo.findById(channel);
		return channel;
	}

}
