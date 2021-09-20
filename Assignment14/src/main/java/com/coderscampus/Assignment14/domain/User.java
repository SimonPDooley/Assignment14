package com.coderscampus.Assignment14.domain;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity // Class name = User, DB Table name = user
@Table(name = "users")
public class User {
	
	private long userId;
	private String username;
	private Set<Message> messages;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@OneToMany(mappedBy = "message",fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	public Set<Message> getMessages() {
		return messages;
	}
	public void setMessages(Set<Message> messages) {
		this.messages = messages;
	}
	
}
