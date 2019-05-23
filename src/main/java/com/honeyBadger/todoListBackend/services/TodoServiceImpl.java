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
	public List<Todo> findByUserId(long userId) {
		
		List<Todo> todos = new ArrayList<>();
		
		todos = todoRepository.findByUserId(userId);
		
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

	@Override
	public void save(Todo todo, long userId) {
	
		Todo _todo = new Todo();
		_todo.setTitle(todo.getTitle());
		_todo.setCompleted(todo.isCompleted());
		_todo.setUserId(userId);
		
		todoRepository.save(_todo);

	}


	@Override
	public void update(Todo todo, long todoId, long userId) {
		
		Optional<Todo> _todo = todoRepository.findByIdAndUserId(todoId, userId);
		
		if(_todo.isPresent()) {
			Todo updatedTodo = _todo.get();
			updatedTodo.setTitle(todo.getTitle());
			updatedTodo.setCompleted(todo.isCompleted());
			todoRepository.save(updatedTodo);
		} else
			throw new RuntimeException("todo not found with id " + todoId);
			
		
	}


	@Override
	public String deleteById(long todoId, long userId) {
		
		Optional<Todo> _todo = todoRepository.findByIdAndUserId(todoId, userId);
		
		String message = null;
		
		if(_todo.isPresent()) {
			todoRepository.deleteById(todoId);
			message = "Deleted todo with id = " + todoId;
		} else {
			message = "Todo with Id " + todoId + " not found";
		}
		
		return message;
	}


}
