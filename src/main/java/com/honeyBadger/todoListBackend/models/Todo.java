package com.honeyBadger.todoListBackend.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="todo")
public class Todo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="title")
	private String title;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="todo_id")
	private List<Item> items;
	
	@Column(name="user_id")
	private Long userId;
	
	@Column(name="completed")
	private boolean completed;
	
	public Todo() {
		
	}

	public Todo(String title, boolean completed, Long userId) {
		this.title = title;
		this.completed = completed;
		this.userId = userId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	
	//convenience method
	
//	public void addItem(Item item) {
//		
//		if (items == null) {
//			items = new ArrayList<>();
//			}
//		items.add(item);
//	}
	

	@Override
	public String toString() {
		return "Todo [id=" + id + ", title=" + title + ", items=" + items + ", completed=" + completed + "]";
	}
}
