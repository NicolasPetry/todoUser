package com.honeyBadger.todoListBackend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.honeyBadger.todoListBackend.models.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {

	List<Todo> findByUserId(long id);

}
