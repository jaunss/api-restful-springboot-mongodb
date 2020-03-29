package com.joaog.apimongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.joaog.apimongodb.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{
	
}