package com.honeyBadger.todoListBackend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.honeyBadger.todoListBackend.models.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

	List<Item> findByTodoId(long todoId);
}
