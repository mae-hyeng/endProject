package com.tp.controller;

import java.util.List;

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
	
	private final MenuService drinkservice;
	private final OrderService orderService;
	private final CartService cartService;
	
	@RequestMapping("/drink")
	public String main(Menu menu, Model model
			,Cart cart, MenuOrder order) {
		
		List<Menu> list = null;
		List<Cart> clist = null;
		List<MenuOrder> olist = null;
		
		list = drinkservice.all();
		olist = orderService.orderAll();
		clist = cartService.cartAll();
		
		
		model.addAttribute("list", list);
		model.addAttribute("clist", clist);
		model.addAttribute("olist", olist);
		
		return "drink/drink";
	}
	
  @PostMapping("/save")
  public String drinkSave(Menu menu,
        MultipartFile file) throws Exception {
     
	  drinkservice.save(menu, file);
     
     return "redirect:/drink";
     
  }
  
  @GetMapping("drinkOrder")
  public String drinkOrderG(@RequestParam("id") Long id,
		  Model model,
		  MenuOrder order, 
		  UserEntity user) {
	  
	  orderService.createOrder(user);
	  order.setUser(user);
	  
	  System.out.println("user : " + user);
	  orderService.orderSave(order);
	  System.out.println("order : " + order);
	  
	return "drink/drinkOrder";
  }
  
  @PostMapping("drinkOrder")
  public String drinkOrderP(UserEntity user, Menu menu, MenuOrder order, Model model) {
	  
	  
	  List<MenuOrder> olist = orderService.orderAll();
	  
	  model.addAttribute("olist" ,olist);
	  
	  return "redirect:/drink";
  }

}
