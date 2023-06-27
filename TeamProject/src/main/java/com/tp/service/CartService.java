//package com.tp.service;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//import javax.transaction.Transactional;
//
//import org.springframework.stereotype.Service;
//
//import com.tp.entity.Cart;
//import com.tp.entity.Cart_item;
//import com.tp.entity.Item;
//import com.tp.entity.UserEntity;
//import com.tp.repository.OrderRepository;
//import com.tp.repository.CartRepository;
//import com.tp.repository.UserRepository;
//
//import lombok.RequiredArgsConstructor;
//
//@Service
//@RequiredArgsConstructor // Lombok 어노테이션을 사용하여 생성자 자동 생성
//public class CartService {
//
//	private final OrderRepository cartRepository; // CartRepository 필드 추가
//	private final CartRepository cart_itemRepository;
//	private final UserRepository userRepository;
//	
//	
//	public void createCart(UserEntity user){
//        Cart cart = Cart.createCart(user);
//        cartRepository.save(cart);
//    }
//	
//	@Transactional
//    public void addCart(UserEntity user, Item item, int count){
//
//		Cart cart = cartRepository.findByUserId(user.getId());
//
//        // cart 가 비어있다면 생성.
//        if(cart == null){
//            cart = Cart.createCart(user);
//            cartRepository.save(cart);
//        }
//
//        // cart_item 생성
//        Cart_item cart_item = cart_itemRepository.findByCartIdAndItemId(cart.getId(),item.getId());
//
//        // cart_item이 비어있다면 새로 생성.
//        if(cart_item == null){
//            cart_item = Cart_item.createCartItem(cart,item,count);
//            cart_itemRepository.save(cart_item);
//            cart.setCount(cart.getCount() + 1);
//        }else{
//            // 비어있지 않다면 그만큼 갯수를 추가.
//            cart_item.addCount(count);
//        }
//
//    }
//	
//	public List<Cart_item> userCartView(Cart cart){
//        List<Cart_item> cart_items = cart_itemRepository.findAll();
//        List<Cart_item> user_items = new ArrayList<>();
//
//        for(Cart_item cart_item : cart_items){
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
//	
////	public void cartDelete(int id){
////        List<Cart_item> cart_items = cart_itemRepository.findAll(); // 전체 cart_item 찾기
////
////        // 반복문을 이용하여 접속 User의 Cart_item 만 찾아서 삭제
////        for(Cart_item cart_item : cart_items){
////            if(cart_item.getCart().getUser().getId() == id){
////                cart_item.getCart().setCount(cart_item.getCart().getCount() - 1);
////                cart_itemRepository.deleteById(cart_item.getId());
////            }
////        }
////    }
////	
////	@Transactional
////    public void cartPayment(int id){
////        List<Cart_item> cart_items = cart_itemRepository.findAll(); // 전체 cart_item 찾기
////        List<Cart_item> userCart_items = new ArrayList<>();
////        UserEntity buyer = userRepository.findById(id).get();
////
////        // 반복문을 이용하여 접속 User의 Cart_item만 찾아서 저장
////        for(Cart_item cart_item : cart_items){
////            if(cart_item.getCart().getUser().getId() == buyer.getId()){
////                userCart_items.add(cart_item);
////            }
////        }
////
////        // 반복문을 이용하여 접속 User의 Cart_item 만 찾아서 삭제
////        for(Cart_item cart_item : userCart_items){
////            // 재고 변경
////            int stock = cart_item.getItem().getStock(); // 현재 재고를 변수에 저장
////            stock = stock - cart_item.getCount(); // 저장된 변수를 결제한 갯수만큼 빼준다
////            cart_item.getItem().setStock(stock); // 재고갯수 변경
////
////            // 금액 처리
////            UserEntity seller = cart_item.getItem().getUser();
////            int cash = cart_item.getItem().getPrice(); // 아이템 가격을 변수에 저장
////            buyer.setMoney(cash * -1);
////            seller.setMoney(cash);
////        }
////    }
////	
//}
