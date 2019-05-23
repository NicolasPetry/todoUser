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
@RequestMapping("/api/todo/{id}")
public class TodoController {

	
private TodoService todoService;
	
	@Autowired
	public TodoController(TodoService todoService) {
		this.todoService = todoService;
	}

	@GetMapping
	public List<Todo> getAllTodos(@PathVariable("id") long userId) {
		
		return todoService.findByUserId(userId);
	}
	
	
	@GetMapping("{id}")
	public Todo getTodoById(@PathVariable("id") long todoId) throws Exception {
		
		Todo todo = todoService.findById(todoId);
		
		if(todo == null) {
			throw new Exception("todo not found" +todoId);
		}
		
		return todo;
	}
//	
//	@PostMapping
//	public Todo postTodo(@RequestBody Todo todo) {
//		
//		todoService.save(todo);
//		
//		return todo;
//	}
//	
//	@PutMapping("{id}")
//	public Todo updateTodo(@PathVariable("id") long id,
//						   @RequestBody Todo todo) {
//		
//		todoService.update(todo, id);
//		
//		return todo;
//	}
//	
//	@DeleteMapping("{id}")
//	public String deleteTodo(@PathVariable long id) {
//			
//		return todoService.deleteById(id);
//	}
}
