package com.honeyBadger.todoListBackend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.honeyBadger.todoListBackend.models.User;
import com.honeyBadger.todoListBackend.repositories.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserService {

	private PasswordEncoder passwordEncoder;
	private UserRepository userRepository; 
	
	@Autowired
	public UserServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository) {
		this.passwordEncoder = passwordEncoder;
		this.userRepository = userRepository;
	}

	@Override
	public void save(User user) {

		User _user = new User();
		
		_user.setPassword(passwordEncoder.encode(user.getPassword()));
		_user.setEmail(user.getEmail());
		
		userRepository.save(_user);
		
	}

	@Override
	public List<User> findAll() {
		
		return userRepository.findAll();
	}

	@Override
	public ResponseEntity<String> saveAndRespond(User user) {
	
		User _user = new User(); 
		
		_user.setPassword(passwordEncoder.encode(user.getPassword()));
		_user.setEmail(user.getEmail());
		
		try {
			userRepository.save(_user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		
		return new ResponseEntity<>(HttpStatus.OK);
			
	}
	
	

}
