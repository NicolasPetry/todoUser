package com.honeyBadger.todoListBackend.services;

import com.honeyBadger.todoListBackend.models.Item;

public interface ItemService {

	void save(Item item, long userId);

}
