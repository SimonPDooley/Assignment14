package com.coderscampus.Assignment14.repository;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.coderscampus.Assignment14.domain.User;

@Repository
public class UserRepository {
	
	private Set<User> users = new HashSet<User>();
	
	public void addUser(String username) {
		User user = new User();
		user.setUsername(username);
		user.setUserId(users.size()+1);
		users.add(user);
	}

	public Set<User> getUsers() {
		return users;
	}

}
