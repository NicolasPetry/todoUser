package com.honeyBadger.todoListBackend.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.honeyBadger.todoListBackend.models.User;

public interface UserService {

	void save(User user);

	List<User> findAll();

	ResponseEntity<String> saveAndRespond(User user);

}
