package com.tp.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	@GetMapping("/MyCart")
	  public String drinkSave(
			  Cart cart, 
			  UserEntity user,
			  Model model,
			  HttpSession session) {
		
		String username = (String)session.getAttribute("username");
		System.out.println("username : " + username);
		
		List<Cart> list = cartService.cartUsername(username);
		System.out.println(list);
		
		model.addAttribute("MyCart", list);
	     
	     return "menu/MyCart";
	     
	  }
	
	@PostMapping("/MyCart")
	public String orderAll(
			Cart cart,
			UserEntity user,
			HttpSession session,
			Model model
			) {
		
		String username = (String)session.getAttribute("username");
		
		System.out.println("username Post : " + username);
				
		
		
		return "redirect:/drink";
	}
	
}
