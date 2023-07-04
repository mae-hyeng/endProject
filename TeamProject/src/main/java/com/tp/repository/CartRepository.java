package com.tp.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tp.entity.Cart;
import com.tp.entity.Menu;
import com.tp.entity.MenuOrder;
import com.tp.entity.UserEntity;

public interface CartRepository extends JpaRepository<Cart, Long> {
	
//	List<Cart> findByUserName(UserEntity user);
//	List<Cart> findByMenuName(String menuname);
	
	List<Cart> findByUserId(String id);

	void deleteByIdIn(List<Long> ids);
	Cart findByUserAndMenu(UserEntity user, Menu menu);
}
