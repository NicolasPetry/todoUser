package com.honeyBadger.todoListBackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
public class TodoListBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoListBackendApplication.class, args);
	}

}
