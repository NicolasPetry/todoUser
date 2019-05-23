package com.honeyBadger.todoListBackend.services;

import java.util.List;

import com.honeyBadger.todoListBackend.models.Item;

public interface ItemService {

	void save(Item item, long userId);

	List<Item> findByTodoId(long todoId);

	void update(Item item, long itemId, long todoId);

}
