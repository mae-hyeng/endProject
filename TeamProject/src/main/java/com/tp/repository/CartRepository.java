package com.tp.repository;

import java.util.List;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

import com.tp.DTO.MenuDTO;
import com.tp.DTO.UserDTO;
import com.tp.entity.Cart;
import com.tp.entity.Menu;

public interface CartRepository extends JpaRepository<Cart, Long> {
	
	
	//메뉴 추가
//	List addMenu(MenuDTO menu);
	
	Cart findByUserName(String userName);

}
