package com.honeyBadger.todoListBackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.honeyBadger.todoListBackend.models.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
