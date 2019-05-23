package com.honeyBadger.todoListBackend.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.honeyBadger.todoListBackend.models.Item;
import com.honeyBadger.todoListBackend.models.Todo;
import com.honeyBadger.todoListBackend.services.ItemService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/todo/{userId}/{todoId}")
public class ItemController {

	private ItemService itemService;

	public ItemController(ItemService itemService) {
		this.itemService = itemService;
	}
	
	@PostMapping
	public Item postItem(@PathVariable("todoId") long userId, @RequestBody Item item) {
		
		itemService.save(item, userId);
		
		return item;
	}
}
