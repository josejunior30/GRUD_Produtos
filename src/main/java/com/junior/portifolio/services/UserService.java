package com.junior.portifolio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.junior.portifolio.entities.User;
import com.junior.portifolio.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public Optional<User> findById(Long id) {
		return repository.findById(id);
	}
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		 repository.deleteById(id);
	}
	public User update(Long id, User obj) {
		User entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	
}
}
