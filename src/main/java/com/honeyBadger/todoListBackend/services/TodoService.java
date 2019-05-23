package com.honeyBadger.todoListBackend.services;

import java.util.List;

import com.honeyBadger.todoListBackend.models.Todo;

public interface TodoService {

	List<Todo> findByUserId(long id);

	Todo findById(long todoId);

	void save(Todo todo, long userId);

	void update(Todo todo, long todoId, long userId);

}
