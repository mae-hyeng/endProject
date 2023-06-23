package com.tp.service;

import java.util.Collections;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.tp.entity.CartEntity;
import com.tp.entity.DrinkEntity;
import com.tp.entity.UserEntity;
import com.tp.repository.CartRepository;

import lombok.RequiredArgsConstructor;

@Service
//@RequiredArgsConstructor
public class CartService {

	private final CartRepository cartRepository;
	
	public CartService(CartRepository cartRepository) {
		this.cartRepository = cartRepository;
	}
	
	public void addToCart(String userId, Long drinkId) {
		UserEntity user = new UserEntity();
		user.setId(userId);
		
		DrinkEntity drink = new DrinkEntity();
		drink.setId(drinkId);
		
		CartEntity cart = new CartEntity();
		cart.setUser(user);
		cart.setDrink(drink);
		cart.setDrink(Collections.singletonList(drink));
		
		cartRepository.save(cart);
		
	}
}
