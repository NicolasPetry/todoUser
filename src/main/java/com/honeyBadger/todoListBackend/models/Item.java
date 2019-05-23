package com.honeyBadger.todoListBackend.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="item")
public class Item {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="completed")
	private boolean completed;
	
	@Column(name="todo_id")
	private long todoId;
	
	public Item() {
		
	}

	public Item(String title, boolean completed, long todoId) {
		this.title = title;
		this.completed = completed;
		this.todoId = todoId;
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

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public Long getTodoId() {
		return todoId;
	}

	public void setTodoId(long todo_id) {
		this.todoId = todo_id;
	}
}
