package com.tp.service;
import java.util.List;

import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.tp.entity.Cart;
import com.tp.entity.Menu;
import com.tp.entity.MenuOrder;
import com.tp.entity.UserEntity;
import com.tp.repository.CartRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CartService {
	

	private final CartRepository cartRepository;
	
//	@Transactional
//	public List<Cart> cartUsername(UserEntity user) {
//		return cartRepository.findByUserName(user);
//	}
	
//	public List<Cart> cartOut(String id) {
//		return cartRepository.findByUserId(id);
//	}


	//전체 주문 조회
	@Transactional
	public List<Cart> cartAll() {
		return cartRepository.findAll();
	}

	public Cart cartSave(Cart cart) {
		return cartRepository.save(cart);
	}

	@Transactional
	public void deleteCartMenu(List<Long> ids) {
	    if (!ids.isEmpty()) {
	        cartRepository.deleteByIdIn(ids);
	    }
	}
	
	public Cart getCartByUserAndMenu(UserEntity user, Menu menu) {
	    return cartRepository.findByUserAndMenu(user, menu);
    }
	
	@Transactional
	public void deleteCartByUser(UserEntity user) {
	    List<Cart> cartEntities = cartRepository.findByUser(user);
	    for (Cart cartEntity : cartEntities) {
	        MenuOrder menuOrder = cartEntity.getMenuOrder();
	        if (menuOrder != null) {
	            menuOrder.setCart(null);
	        }
	        cartRepository.delete(cartEntity);
	    }
	}
	
	public Cart findCartByUserId(String userId) {
	    return cartRepository.findByUser_Id(userId);
	}
	
	public Cart findCartByIdAndUserId(Long cartId, String userId) {
	    return cartRepository.findByIdAndUser_Id(cartId, userId);
	}


}