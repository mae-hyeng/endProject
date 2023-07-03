package com.tp.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tp.entity.Cart;
import com.tp.entity.MenuOrder;
import com.tp.entity.UserEntity;

public interface CartRepository extends JpaRepository<Cart, Long> {
	
	List<Cart> findByUserName(UserEntity user);
//	List<Cart> findByMenuName(String menuname);

	void deleteByIdIn(List<Long> ids);
}
