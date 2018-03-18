package com.mgctech.elitepos.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mgctech.elitepos.model.User;

public interface UserRepository extends MongoRepository<User, String> {

	public User findByUsername(String username);
	
}
