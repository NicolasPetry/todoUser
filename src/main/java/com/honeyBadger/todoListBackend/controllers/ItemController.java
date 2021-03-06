package com.honeyBadger.todoListBackend.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.honeyBadger.todoListBackend.models.Item;
import com.honeyBadger.todoListBackend.services.ItemService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/todo/{userId}/{todoId}")
public class ItemController {

	private ItemService itemService;

	public ItemController(ItemService itemService) {
		this.itemService = itemService;
	}
	
	@GetMapping("/items")
	public List<Item> getAllItems(@PathVariable("todoId") long todoId) {
		
		return itemService.findByTodoId(todoId);
	}
	
	@PostMapping
	public Item postItem(@PathVariable("todoId") long userId, @RequestBody Item item) {
		
		itemService.save(item, userId);
		
		return item;
	}
	
	@PutMapping("{itemId}")
	public Item updateItem(
			@PathVariable("todoId") long todoId,
			@PathVariable("itemId") long itemId,
			@RequestBody Item item) {
		
		itemService.update(item, itemId, todoId);
		
		return item;
	}
	
	@DeleteMapping("{itemId}")
	public String deleteTodo(
			@PathVariable("itemId") long itemId,
			@PathVariable("todoId") long todoId) {
			
		return itemService.deleteById(todoId, itemId);
	}
}
