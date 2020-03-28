package com.joaog.apimongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joaog.apimongodb.domain.User;
import com.joaog.apimongodb.dto.UserDTO;
import com.joaog.apimongodb.repository.UserRepository;
import com.joaog.apimongodb.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> user = userRepository.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
	}
	
	public User insert(User obj) {
		return userRepository.insert(obj);
	}
	
	public User fromDTO(UserDTO obj) {
		return new User(obj.getId(), obj.getNome(), obj.getEmail());
	}
	
	public void deleteById(String id) {
		findById(id);
		userRepository.deleteById(id);
	}
	
	public User update (User user) {
		User newObj = findById(user.getId());
		updateData(newObj, user);
		return userRepository.save(newObj);
	}

	private void updateData(User newObj, User user) {
		
		newObj.setNome(user.getNome());
		newObj.setEmail(user.getEmail());
	}
}