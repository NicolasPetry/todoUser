package com.honeyBadger.todoListBackend.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.honeyBadger.todoListBackend.models.Item;
import com.honeyBadger.todoListBackend.models.Todo;
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

	@Override
	public void update(Item item, long itemId, long todoId) {
		
		Optional<Item> _item = itemRepository.findByIdAndTodoId(itemId, todoId);
		
		if(_item.isPresent()) {
			Item updatedItem = _item.get();
			updatedItem.setTitle(item.getTitle());
			updatedItem.setCompleted(item.isCompleted());
			itemRepository.save(updatedItem);
		} else
			throw new RuntimeException("item not found with id " + itemId);
		
	}

}
