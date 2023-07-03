package com.tp.service;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.tp.entity.Cart;
import com.tp.entity.UserEntity;
import com.tp.repository.CartRepository;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class CartService {
//	
	private final CartRepository cartRepository;

	@Transactional
	public List<Cart> cartUsername(UserEntity user) {
		return cartRepository.findByUserName(user);
	}
//	
//	//전체 주문 조회
	@Transactional
	public List<Cart> cartAll() {
		return cartRepository.findAll();
	}
//	
//
//	
//	//전체 주문 조회
//	public List<Cart> cartAll() {
//		return cartRepository.findAll();
//	}
//	
//	
	public void cartSave(Cart cart) {
		cartRepository.save(cart);
	}

	@Transactional
	public void deleteCartMenu(List<Long> ids) {
	    if (!ids.isEmpty()) {
	        cartRepository.deleteByIdIn(ids);
	    }
	}

}
