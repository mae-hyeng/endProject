//package com.tp.controller;
//
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import com.tp.entity.UserEntity;
//import com.tp.repository.UserRepository;
//
//public class CartController {
//
//	private final UserRepository userRepository;
//	
//	@PostMapping("/user/cart/{id}/{menuId}")
//	public String addCartItem(@PathVariable("id") Integer id, @PathVariable("menuId") Integer menuId, int quantity) {
//		
//		UserEntity user = userRepository.findByUsername(id);
//		
//		return "/cart";
//	}
//	
//}
