package com.tp.repository;

<<<<<<< HEAD
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

=======

import org.springframework.data.jpa.repository.JpaRepository;

import com.tp.entity.Cart;
import com.tp.entity.MenuOrder;

public interface CartRepository extends JpaRepository<Cart, Long> {
	
//	Cart findByCartIdAndMenuId(long cartId, long menuId);
	
>>>>>>> branch 'main' of https://github.com/mae-hyeng/endProject.git
}
