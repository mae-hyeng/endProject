package com.tp.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tp.entity.Menu;
import com.tp.service.MenuService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MenuController {
	
	private final MenuService menuService;
	
	   @RequestMapping("/menu")
	   public String menu(Model model, 
	         @PageableDefault(direction = Sort.Direction.DESC)
	         String keyword) {
		   
		   Page<Menu> list = null;
		   
		   model.addAttribute("list",list);
		   
		   return "menu/menu";
	   }
}
