package com.tp.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tp.entity.Cart;
import com.tp.entity.MenuOrder;

public interface CartRepository extends JpaRepository<Cart, Long> {
	
	List<Cart> findByUserName(String id);
	
}
