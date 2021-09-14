package com.coderscampus.Assignment14.repository;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.coderscampus.Assignment14.domain.Channel;

@Repository
public class ChannelRepository {
	Set<Channel> channels = new HashSet<Channel>();
	
	public Set<Channel> CreateChannelList() {
		if(channels.size() == 0) {
			Channel generalChannel = new Channel();
			generalChannel.setChannelName("General");
			generalChannel.setChannelId(channels.size()+1);
			channels.add(generalChannel);	
		}
		return channels;	
	}

	public Channel findById(Channel currentChannel) {
		for(Channel channel : channels) { 
			if(currentChannel.getChannelId() == (channel.getChannelId())) { 
				return channel;
			}
		}
		return currentChannel;
	}
}
