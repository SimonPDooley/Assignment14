package com.coderscampus.Assignment14.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coderscampus.Assignment14.domain.Channel;

@Repository
public interface ChannelRepository extends JpaRepository<Channel, Long>{
	
}
