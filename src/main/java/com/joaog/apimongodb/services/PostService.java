package com.joaog.apimongodb.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joaog.apimongodb.domain.Post;
import com.joaog.apimongodb.repository.PostRepository;
import com.joaog.apimongodb.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository userRepository;
	
	
	public Post findById(String id) {
		Optional<Post> user = userRepository.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
	}
}