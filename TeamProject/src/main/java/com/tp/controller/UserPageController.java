//package com.tp.controller;
//
//import java.util.List;
//
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//
//import com.tp.entity.Cart;
//
//public class UserPageController {
//
//	@GetMapping("/user/{id}/cart")
//    public String myCartPage(@PathVariable("id") Integer id,Model model,@AuthenticationPrincipal PrincipalDetails principalDetails){
//        // 로그인 User == 접속 User
//        if(principalDetails.getUser().getId() == id){
//            // User의 장바구니를 가져온다.
//            Cart cart = principalDetails.getUser().getCart();
//            // 장바구니의 아이템을 가져온다.
//
//            List<Cart> cart_items = cartService.userCartView(cart);
//
//            int totalPrice = 0;
//            for(Cart cart_item : cart_items){
//                totalPrice += ( cart_item.getItem().getPrice() * cart_item.getCount());
//            }
//
//            model.addAttribute("cart_itemList",cart_items);
//            model.addAttribute("totalPrice",totalPrice);
//            model.addAttribute("user",userPageService.findUser(id));
//
//            return "/cart/cart";
//        }else{
//            return "redirect:/main";
//        }
//    }
//	
//}
