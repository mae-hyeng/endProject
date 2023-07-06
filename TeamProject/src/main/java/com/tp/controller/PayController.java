package com.tp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

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
	CartService cartService;
	
	@Autowired
	MenuOrderService menuOrderService;

	@PostMapping("/cart")
	public String cart(HttpSession session,
			@RequestParam(value = "QuantitySum", required = false) Integer totalQuantity,
			@RequestParam(value = "PriceSum", required = false) Integer PriceSum, RedirectAttributes rttr) {
		if(totalQuantity== null || PriceSum == null) {
			rttr.addFlashAttribute("result", "NO");
			return "redirect:/nocart";
		}else {
			String username=(String)session.getAttribute("username");
			if(username!=null) {
				UserEntity userinfo = userService.UserInfo(username);
				session.setAttribute("user", userinfo);
				session.setAttribute("uuid", userinfo.getId());
				session.setAttribute("name", userinfo.getName());
				session.setAttribute("email", userinfo.getEmail());
				
				 // 현재 날짜 및 시간 가져오기
		        Date now = new Date();

		        // 주문번호 형식을 위한 날짜 및 시간 포맷 지정
		        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");

		        // 주문번호 생성을 위한 랜덤 숫자 생성
		        Random random = new Random();
		        int randomNumber = random.nextInt(900) + 100; // 세 자리 랜덤 숫자 (100 이상 999 이하)

		        // 주문번호 조합
		        String orderNumber = dateFormat.format(now) + randomNumber;
		        
		        session.setAttribute("orderNumber", orderNumber);
				cartService.deleteCartByUser(userinfo);

				return "/pay/cart";
			}else {
				return "redirect:/sessionover";
			}	
		}
		
		
	}
	
	@PostMapping("/cart2")
	public String cart2(HttpSession session,
			@RequestParam("priceAll") Integer priceAll) {
		 
			String username=(String)session.getAttribute("username");
			if(username!=null) {
				UserEntity userinfo = userService.UserInfo(username);
				session.setAttribute("user", userinfo);
				session.setAttribute("uuid", userinfo.getId());
				session.setAttribute("name", userinfo.getName());
				session.setAttribute("email", userinfo.getEmail());
				
				 // 현재 날짜 및 시간 가져오기
		        Date now = new Date();

		        // 주문번호 형식을 위한 날짜 및 시간 포맷 지정
		        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");

		        // 주문번호 생성을 위한 랜덤 숫자 생성
		        Random random = new Random();
		        int randomNumber = random.nextInt(900) + 100; // 세 자리 랜덤 숫자 (100 이상 999 이하)

		        // 주문번호 조합
		        String orderNumber = dateFormat.format(now) + randomNumber;
		        
		        session.setAttribute("orderNumber", orderNumber);
				
				return "/pay/cart";
			}else {
				return "redirect:/sessionover";
			}	
		
		
		
	}
	@GetMapping("/success")
	public String success(
			MenuOrder menuOrder,
			Menu menu,
			UserEntity user,
			Cart cart,
			HttpSession session,
			Model model
			) {
		String username = (String)session.getAttribute("username");
		
		user = userService.UserInfo(username);
		
		List<UserEntity> userList = new ArrayList<>();
		userList.add(user);
		
		for(int i=0; i<userList.size(); i++) {
			System.out.println(userList.get(i));
		}
		
		Cart savedCart = cartService.cartSave(cart); // cart 저장
		savedCart.setQuantity(savedCart.getQuantity());
		savedCart.setUser(user);
		savedCart.setMenu(savedCart.getMenu());
		
		System.out.println("savedCart : " + savedCart);
		System.out.println("cart : " + cart);
		
		System.out.println("getQuantity" + savedCart.getQuantity());
		System.out.println("getMenu : " + savedCart.getMenu());
		
		menuOrderService.saveOrder(menuOrder);
		
		model.addAttribute("menuOrder", menuOrder);
		
		System.out.println("menuOrder : " + menuOrder);
		
		
		
		return "/pay/success";
	}
	
	@GetMapping("/nocart")
	public String nocart() {
		return "/pay/nocart";
	}
	

	
//	@RequestMapping("/success")
//	public String success(
//			MenuOrder menuOrder,
//			Menu menu,
//			UserEntity user,
//			Cart cart,
//			HttpSession session
//			) {
//		
//		String username = (String)session.getAttribute("username");
//		
//		user = userService.UserInfo(username);
//		
////		menuOrder = MenuOrder.builder()			
////				.cart(cart)
////				.user(user)
////				.menu(menu)
////				.build();
//		
//		return "/pay/success";
//	}
	
//	@GetMapping("/success")
//	public String success() {
//		return "/pay/success";
//	}

	@PostMapping("/success")
	public String successs() {
		return "/pay/success";
	}
	
	
	@GetMapping("/fail")
	public String fail() {
		return "/pay/fail";
	}
	@PostMapping("/fail")
	public String faill() {
		return "/pay/fail";
	}
}

