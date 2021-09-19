package com.coderscampus.Assignment14.domain;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Channel {

		private long channelId;
		private String channelName;
		private Set<Message> messages;
		
	
		@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "channels")
		public long getChannelId() {
			return channelId;
		}
		public void setChannelId(long channelId) {
			this.channelId = channelId;
		}
		public String getChannelName() {
			return channelName;
		}
		public void setChannelName(String channelName) {
			this.channelName = channelName;
		}
		
		@OneToMany(mappedBy = "channel",fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
		public Set<Message> getMessages() {
			return messages;
		}
		public void setMessages(Set<Message> messages) {
			this.messages = messages;
		}
		
		
}
