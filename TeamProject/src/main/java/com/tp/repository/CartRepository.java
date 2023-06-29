package com.tp.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.tp.entity.Cart;
import com.tp.entity.MenuOrder;

public interface CartRepository extends JpaRepository<MenuOrder, Integer> {
	
	Cart findByCartIdAndMenuId(long cartId, long menuId);
	
}
