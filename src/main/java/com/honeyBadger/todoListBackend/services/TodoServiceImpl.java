package com.honeyBadger.todoListBackend.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.honeyBadger.todoListBackend.models.Todo;
import com.honeyBadger.todoListBackend.repositories.TodoRepository;

@Service
public class TodoServiceImpl implements TodoService {

	private TodoRepository todoRepository;

	public TodoServiceImpl(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}

	@Override
	public List<Todo> findByUserId(long id) {
		
		List<Todo> todos = new ArrayList<>();
		
		todos = todoRepository.findByUserId(id);
		
		return todos;
	}

	@Override
	public Todo findById(long todoId) {
		
		Optional<Todo> todoOptional = todoRepository.findById(todoId);
		
		Todo todo = null;
		
		if(todoOptional.isPresent())
			todo = todoOptional.get();
		else
			throw new RuntimeException("todo not found with id " + todoId);
		
		return todo;
	}
	
//	@Override
//	public void save(Todo todo) {
//		
//		
//	}
//
//	@Override
//	public void update(Todo todo, long id) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public String deleteById(long id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//


}
