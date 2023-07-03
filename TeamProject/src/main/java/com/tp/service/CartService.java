package com.tp.service;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.catalina.User;
//import java.util.List;
//
import org.springframework.stereotype.Service;

import com.tp.entity.Cart;
import com.tp.entity.UserEntity;
//
//import com.tp.entity.Cart;
//import com.tp.entity.MenuOrder;
import com.tp.repository.CartRepository;

import lombok.RequiredArgsConstructor;
//import com.tp.repository.OrderRepository;
//
//import lombok.RequiredArgsConstructor;
//
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
//
//	
//	//전체 주문 조회
	@Transactional
	public List<Cart> cartAll() {
		return cartRepository.findAll();
	}
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

//	public List<Cart> findSame(String menuname) {
//		return cartRepository.findByMenuName(menuname);
//	}

//
//}
//=======
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//import javax.transaction.Transactional;
//
//import org.springframework.stereotype.Service;
//
//import com.tp.entity.Cart;
//import com.tp.entity.Menu;
//import com.tp.entity.MenuOrder;
//import com.tp.entity.UserEntity;
//import com.tp.repository.CartRepository;
//import com.tp.repository.MenuOrderRepository;
//import com.tp.repository.UserRepository;
//
//import lombok.RequiredArgsConstructor;

//@Service
//@RequiredArgsConstructor // Lombok 어노테이션을 사용하여 생성자 자동 생성
//public class CartService {
//
//	private final MenuOrderRepository menuorderRepository; 
//	private final CartRepository cartRepository;    // CartRepository 필드 추가
//	private final UserRepository userRepository;
//	
//	// User에게 장바구니 생성
//	public void createMenuorder(UserEntity user){
//		MenuOrder menuorder = MenuOrder.createMenuorder(user);
//		menuorderRepository.save(menuorder);
//    }
//	
	
//	// menuorder에 menu 추가하기
//	@Transactional
//    public void addCart(UserEntity user, Menu menu, int count){
//
//		MenuOrder menuorder = menuorderRepository.findByUserId(user.getId());
//
//        // menuorder 가 비어있다면 생성.
//        if(menuorder == null){
//            menuorder = MenuOrder.createMenuorder(user);
//            menuorderRepository.save(menuorder);
//        }

//        // cart 생성
//        Cart cart = cartRepository.findByCartIdAndMenuId(cart.getId(),menu.getId());
//
//        // cart가 비어있다면 새로 생성.
//        if(cart == null) {
//        	cart = Cart.createCart(menuorder, menu, count);
//        	cartRepository.save(cart);
//        	cart.setCount(cart.getCount() + 1);
//        }else{
//            // 비어있지 않다면 그만큼 갯수를 추가.
//            cart.addCount(count);
//        }
//
//    }
	
//	// 장바구니 조회하기
//	public List<Cart> userCartView(MenuOrder menuorder){
//        List<Cart> cart_items = cartRepository.findAll();
//        List<Cart> user_items = new ArrayList<>();
//
//        for(Cart cart_item : cart_items){
//            if(cart_item.getCart().getId() == cart.getId()){
//                user_items.add(cart_item);
//            }
//        }
//
//        return user_items;
//    }
//	
//	public void cartItemDelete(int id){
//        cart_itemRepository.deleteById(id);
//    }
	
//	public void cartDelete(int id){
//        List<Cart_item> cart_items = cart_itemRepository.findAll(); // 전체 cart_item 찾기
//
//        // 반복문을 이용하여 접속 User의 Cart_item 만 찾아서 삭제
//        for(Cart_item cart_item : cart_items){
//            if(cart_item.getCart().getUser().getId() == id){
//                cart_item.getCart().setCount(cart_item.getCart().getCount() - 1);
//                cart_itemRepository.deleteById(cart_item.getId());
//            }
//        }
//    }
//	
//	@Transactional
//    public void cartPayment(int id){
//        List<Cart_item> cart_items = cart_itemRepository.findAll(); // 전체 cart_item 찾기
//        List<Cart_item> userCart_items = new ArrayList<>();
//        UserEntity buyer = userRepository.findById(id).get();
//
//        // 반복문을 이용하여 접속 User의 Cart_item만 찾아서 저장
//        for(Cart_item cart_item : cart_items){
//            if(cart_item.getCart().getUser().getId() == buyer.getId()){
//                userCart_items.add(cart_item);
//            }
//        }
//
//        // 반복문을 이용하여 접속 User의 Cart_item 만 찾아서 삭제
//        for(Cart_item cart_item : userCart_items){
//            // 재고 변경
//            int stock = cart_item.getItem().getStock(); // 현재 재고를 변수에 저장
//            stock = stock - cart_item.getCount(); // 저장된 변수를 결제한 갯수만큼 빼준다
//            cart_item.getItem().setStock(stock); // 재고갯수 변경
//
//            // 금액 처리
//            UserEntity seller = cart_item.getItem().getUser();
//            int cash = cart_item.getItem().getPrice(); // 아이템 가격을 변수에 저장
//            buyer.setMoney(cash * -1);
//            seller.setMoney(cash);
//        }
//    }
//	
