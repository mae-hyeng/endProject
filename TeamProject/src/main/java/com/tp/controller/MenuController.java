package com.tp.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.tp.entity.Cart;
import com.tp.entity.Menu;
import com.tp.entity.MenuOrder;
import com.tp.entity.UserEntity;
import com.tp.service.BoardService;
import com.tp.service.CartService;
import com.tp.service.MenuService;
import com.tp.service.OrderService;
import com.tp.service.UserService;

import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class MenuController {
	
	private final MenuService menuservice;
	private final OrderService orderService;
	private final CartService cartService;
	private final UserService userService;
	
	@RequestMapping("/drink")
	public String main(Menu menu, Model model
			,Cart cart, MenuOrder order) {
		
		List<Menu> list = null;
		
		list = menuservice.all();
		
		
		model.addAttribute("list", list);
		System.out.println(list);
		
		return "drink/drink";
	}
	
  @PostMapping("/save")
  public String drinkSave(Menu menu,
        MultipartFile file) throws Exception {
     
	  menuservice.save(menu, file);
     
     return "redirect:/drink";
     
  }
  
  @GetMapping("drinkOrder")
  public String drinkOrderG(@RequestParam("id") Long id,
		  @RequestParam("quantity") Integer quantity,
		  Model model,
		  MenuOrder order, 
		  UserEntity user,
		  Cart cart,
		  HttpSession session) {
	  
	  String username = (String)session.getAttribute("username");
	  
	  if(username != null) {
		 user = userService.UserInfo(username);
	  
		  order = MenuOrder.builder()
		            .quantity(quantity)
		            .menu(menuservice.MenuNum(id))
		            .user(user)
		            .build();
	
		  
		  System.out.println("user : " + user);
		  
		  
		  orderService.orderSave(order);
		  model.addAttribute("order", order);
		  cartService.cartSave(cart);
		  System.out.println("order : " + order);
	  
		  return "drink/drinkOrder"; 
	  }else {
		  return "redirect:/sessionover";
	  }
	  
	  
  }
  
  @PostMapping("drinkOrder")
  public String drinkOrderP(UserEntity user, Menu menu, MenuOrder order, Model model) {
	  
	  
	  List<MenuOrder> olist = orderService.orderAll();
	  
	  model.addAttribute("olist" ,olist);
	  
	  return "redirect:/drink";
  }

}
