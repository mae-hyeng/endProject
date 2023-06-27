package com.tp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tp.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, String> {
	Cart findByUserId(String string);
	
}
