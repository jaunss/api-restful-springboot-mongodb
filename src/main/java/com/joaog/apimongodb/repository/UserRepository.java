package com.joaog.apimongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.joaog.apimongodb.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{
	
}