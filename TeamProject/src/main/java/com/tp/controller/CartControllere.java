package com.tp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tp.entity.Cart;
import com.tp.entity.UserEntity;
import com.tp.repository.CartRepository;
import com.tp.service.CartService;
import com.tp.service.MenuService;
import com.tp.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class CartControllere {

	private final CartService cartService;
	private final UserService userService;
	private final MenuService menuService;
	
	@GetMapping("/addCart")
	  public String drinkSave(
			  Cart cart, 
			  UserEntity user,
			  HttpSession session) {
		
		String username = (String)session.getAttribute("username");
		
		user = userService.UserInfo(username);
		
		cart.setUser(user);
//		cartService.cartSave(cart);
	     
	     return "redirect:/drink";
	     
	  }
	
}
