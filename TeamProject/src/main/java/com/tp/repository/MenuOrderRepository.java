package com.tp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tp.entity.Cart;
import com.tp.entity.MenuOrder;

public interface MenuOrderRepository extends JpaRepository<MenuOrder, String> {
	
	MenuOrder findByUserId(String string);

}
