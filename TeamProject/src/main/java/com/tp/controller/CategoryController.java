package com.tp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tp.entity.Menu;
import com.tp.service.MenuService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class CategoryController {
	
	private MenuService menuService;

	@RequestMapping("/{category}")
	public String category(@PathVariable("category") String category, Model model) {
		List<Menu> list = null;
		
		if(category.equals("coffee")) {
			category = "COFFEE";
		} else if(category.equals("milk_tea&latte")) {
			category = "MILK TEA & LATTE";
		} else if(category.equals("juice&drink")) {
			category = "JUICE & DRINK";
		} else if(category.equals("smoothie")) {
			category = "SMOOTHIE";
		} else if(category.equals("tea&ade")) {
			category = "TEA & ADE";
		} else if(category.equals("BREAD")) {
			category = "DESSERT";
		} else if(category.equals("MD")) {
			category = "MD";
		}
		list = menuService.categoryList(category);
		model.addAttribute("list",list);
		
		return category;
	}
	
	
}
