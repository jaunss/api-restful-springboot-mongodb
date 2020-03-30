package com.joaog.apimongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.joaog.apimongodb.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{
	
	@Query("{ 'titulo': { $regex: ?0, $options: 'i' } }")
	List<Post> searchTitle(String texto);
	
	List<Post> findByTitleContainingIgnoreCase(String texto);
}