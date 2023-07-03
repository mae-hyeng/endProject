package com.tp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tp.entity.Cart;
import com.tp.entity.Menu;
import com.tp.entity.MenuOrder;
import com.tp.entity.UserEntity;
import com.tp.service.UserService;

@Controller
public class PayController {
	@Autowired
	UserService userService;
	
	@RequestMapping("/cart")
	public String cart(HttpSession session,
			@RequestParam("QuantitySum") Integer totalQuantity,
			@RequestParam("PriceSum") Integer PriceSum) {
		
		String username=(String)session.getAttribute("username");
		if(username!=null) {
			UserEntity userinfo = userService.UserInfo(username);
			session.setAttribute("user", userinfo);
			session.setAttribute("name", userinfo.getName());
			session.setAttribute("email", userinfo.getEmail());
			return "/pay/cart";
		}else {
			return "redirect:/sessionover";
		}
		
	}
	

	
	@RequestMapping("/success")
	public String success(
			MenuOrder menuOrder,
			Menu menu,
			UserEntity user,
			Cart cart,
			HttpSession session
			) {
		
		String username = (String)session.getAttribute("username");
		
		user = userService.UserInfo(username);
		
		menuOrder = MenuOrder.builder()			
				.cart(cart)
				.user(user)
				.menu(menu)
				.build();
		
		return "/pay/success";
	}
	
//	@GetMapping("/success")
//	public String success() {
//		return "/pay/success";
//	}
//	@PostMapping("/success")
//	public String successs() {
//		return "/pay/success";
//	}
	
	
	@GetMapping("/fail")
	public String fail() {
		return "/pay/fail";
	}
	@PostMapping("/fail")
	public String faill() {
		return "/pay/fail";
	}
}
