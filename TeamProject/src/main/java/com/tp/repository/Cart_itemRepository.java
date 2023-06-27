package com.tp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tp.entity.Cart_item;

public interface Cart_itemRepository extends JpaRepository<Cart_item, Integer> {
	
	Cart_item findByCartIdAndItemId(int cartId, long itemId);
	
}
