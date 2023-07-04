package com.tp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tp.entity.Cart;
import com.tp.entity.Menu;
import com.tp.entity.MenuOrder;
import com.tp.entity.UserEntity;
import com.tp.service.CartService;
import com.tp.service.MenuOrderService;
import com.tp.service.UserService;

@Controller
public class PayController {
	@Autowired
	UserService userService;
	
	@Autowired
	MenuOrderService menuOrderService;
	
	@RequestMapping("/cart")
	public String cart(HttpSession session,
			@RequestParam("QuantitySum") Integer totalQuantity,
			@RequestParam("PriceSum") Integer PriceSum,
			@RequestParam("menuOrderName") String menuOrderName) {
		
		System.out.println("menuOrderName" + menuOrderName);
		
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
	
	@RequestMapping("/cart2")
	public String cart2(HttpSession session,
			@RequestParam("priceAll") Integer priceAll) {
		
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
		
		List<UserEntity> userList = new ArrayList<>();
		userList.add(user);
		
		
		System.out.println("pay : " + userList);
		
		menuOrder = MenuOrder.builder()			
				.cart(cart)
				.user(userList)
				.menu(menu)
				.build();
		
		menuOrderService.saveOrder(menuOrder);
		
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
