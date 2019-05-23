package com.honeyBadger.todoListBackend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.honeyBadger.todoListBackend.models.Todo;
import com.honeyBadger.todoListBackend.services.TodoService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/todo/{userId}")
public class TodoController {

	
private TodoService todoService;
	
	@Autowired
	public TodoController(TodoService todoService) {
		this.todoService = todoService;
	}

	@GetMapping
	public List<Todo> getAllTodos(@PathVariable("userId") long userId) {
		
		return todoService.findByUserId(userId);
	}
	
	
	@GetMapping("{todoId}")
	public Todo getTodoById(@PathVariable("todoId") long todoId) throws Exception {
		
		Todo todo = todoService.findById(todoId);
		
		if(todo == null) {
			throw new Exception("todo not found" +todoId);
		}
		
		return todo;
	}
	
	@PostMapping
	public Todo postTodo(@PathVariable("userId") long userId, @RequestBody Todo todo) {
		
		todoService.save(todo, userId);
		
		return todo;
	}
	
	@PutMapping("{todoId}")
	public Todo updateTodo(
			@PathVariable("userId") long userId,
			@PathVariable("todoId") long todoId,
			@RequestBody Todo todo) {
		
		todoService.update(todo, todoId, userId);
		
		return todo;
	}
	
	@DeleteMapping("{todoId}")
	public String deleteTodo(
			@PathVariable("userId") long userId,
			@PathVariable("todoId") long todoId) {
			
		return todoService.deleteById(todoId, userId);
	}
}
