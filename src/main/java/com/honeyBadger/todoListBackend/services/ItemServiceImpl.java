package com.honeyBadger.todoListBackend.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.honeyBadger.todoListBackend.models.Item;
import com.honeyBadger.todoListBackend.repositories.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService {

	private ItemRepository itemRepository;
	
	
	public ItemServiceImpl(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}

	@Override
	public List<Item> findByTodoId(long todoId) {
		
		List<Item> items = new ArrayList<>();
		
		items = itemRepository.findByTodoId(todoId);
		
		return items;
	}
	
	@Override
	public void save(Item item, long userId) {
		
		Item _item = new Item();
		_item.setTitle(item.getTitle());
		_item.setCompleted(item.isCompleted());
		_item.setTodoId(userId);
		
		itemRepository.save(_item);
		
	}

}
