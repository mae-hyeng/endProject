package com.tp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tp.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

	Item findItemById(Long id);
	
}
