package com.tp.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tp.entity.Menu;
import com.tp.entity.UserEntity;
import com.tp.repository.OrderRepository;
import com.tp.service.MenuService;
import com.tp.service.OrderService;
import com.tp.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderController {

	private final OrderService orderService;
	private final UserService userService;
	private final MenuService menuService;
	
	@Transactional
    @RequestMapping("/order")
    public String myOrderPage(@RequestParam("id") Long id,Model model, HttpSession session){
        
		Menu list = menuService.selectOne(id);
		
		System.out.println(list);
		
		model.addAttribute("orderList", list);
		
		return "board/content";
		
    }
	
}
