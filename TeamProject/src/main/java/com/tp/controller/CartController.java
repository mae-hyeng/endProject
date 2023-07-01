package com.tp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tp.DTO.UserDTO;
import com.tp.entity.Cart;
import com.tp.entity.UserEntity;
import com.tp.repository.CartRepository;
import com.tp.service.CartService;
import com.tp.service.MenuService;
import com.tp.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class CartController {

	private final CartService cartService;
	private final UserService userService;
	private final MenuService menuService;
	
	
	@GetMapping("/MyCart")
	@Transactional
	  public String drinkSave(
			  Cart cart,
			  Model model,
			  UserEntity user,
			  HttpSession session) {		
		List<Cart> list = null;
		
		list = cartService.cartAll();
		List<Cart> list2 = new ArrayList<>();
		
		String username = (String)session.getAttribute("username");
		
		for(int i=0; i<list.size(); i++) {
			if(username.equals(list.get(i).getUser().getUsername())) {
				list2.add(list.get(i));
				model.addAttribute("list2", list2);
			}
		}
		System.out.println("List2 : " + list2);    
		
	    return "menu/MyCart";
	     
	  }
	
}
