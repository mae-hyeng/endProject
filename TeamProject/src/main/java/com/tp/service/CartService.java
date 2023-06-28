package com.tp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tp.entity.Cart;
import com.tp.repository.CartRepository;
import com.tp.repository.OrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CartService {
	
	private final CartRepository cartRepository;
	

	
	//전체 주문 조회
	public List<Cart> cartAll() {
		return cartRepository.findAll();
	}

}
