package com.coderscampus.Assignment14.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coderscampus.Assignment14.domain.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long>{
	
}


