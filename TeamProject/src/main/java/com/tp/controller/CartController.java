package com.tp.controller;

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
			  HttpSession session) {		
		List<Cart> list = null;
		
		list = cartService.cartAll();
		
		model.addAttribute("cartList", list);
		
		
		//
		String username = (String)session.getAttribute("username");
		
		
		List<Cart> list2 = null;
		
		list2 = cartService.cartUsername(username);
		
		System.out.println(list2);
		
		//
		
		System.out.println(list);
		for(int i=0; i<list.size(); i++ ) {
			session.setAttribute("id"+i, list.get(i).getId());
		
			session.setAttribute("quantity"+i, list.get(i).getQuantity());
		
			session.setAttribute("username"+i, list.get(i).getUser().getUsername());
		
			session.setAttribute("name"+i, list.get(i).getMenu().getName());
			i++;
			
		}
		    
	    return "menu/MyCart";
	     
	  }
	
	@PostMapping("/MyCart")
	@Transactional
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
