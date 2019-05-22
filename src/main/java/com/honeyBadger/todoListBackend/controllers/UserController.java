package com.honeyBadger.todoListBackend.controllers;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.honeyBadger.todoListBackend.models.User;
import com.honeyBadger.todoListBackend.services.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/todo/user")
public class UserController {

	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping
	public List<User> getAllUsers() {
		
		return userService.findAll();
	}
	
	@PostMapping("/signup")
	public User addUser(@RequestBody User user) {
		
		userService.save(user);
		
		return user;
	}
	
//	@PostMapping("/signup")
//	public ResponseEntity<String> addUser(@RequestBody User user) {
//			
//		return userService.saveAndRespond(user);
//	}
}
