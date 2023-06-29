package com.tp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.tp.entity.Menu;
import com.tp.service.MenuService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MenuController {
	
	private final MenuService menuService;
	
	   @RequestMapping("/menu")
	   public String menu(Model model) {
		   List<Menu> list = null;
		   
		   list = menuService.all();
		   
		   model.addAttribute("list",list);
		   return "menu/menu";
	   }
	   
	   //메뉴 작성
	   @RequestMapping("menuRegister")
	   public String write() {
		   return "menu/register";
	   }
	   
	   //메뉴 저장
	   @GetMapping("/menuSave")
	   public String save() {
		   return "menu/menu";
	   }
	   
	   //메뉴 저장
	   @PostMapping("/menuSave")
	   public String menuSave(Menu menu, MultipartFile file) throws Exception {
		   menuService.save(menu, file);
		   return "redirect:/menu";
	   }
	   
	   //게시물 상세보기
	   @RequestMapping("/menuContent")
	   public String content(@RequestParam("id") Long id,
			   Model model,	
			   HttpServletRequest req,
			   HttpServletResponse res, HttpSession session) {
		   model.addAttribute("menu",menuService.selectOne(id));
		   
		   if(session.getAttribute("listnum_mo") != null) {
			   session.setAttribute("listnum", 3);
			   session.removeAttribute("listnum_mo");
		   } else {
			   session.setAttribute("listnum", 1);
		   }
		   return "menu/content";
	   }
	   
	   //게시물 삭제
	   @GetMapping("/deleteMenu")
	   public String delete(@RequestParam Long id) {
		   menuService.delete(id);
		   return "redirect:/menu";
	   }
	   
	   //게시물 수정
	   @GetMapping("/modifyMenu")
	   public String modify(@RequestParam Long id, Model model, HttpSession session) {
		   String username = (String) session.getAttribute("username");
		   session.setAttribute("listNum", 2);
		   model.addAttribute("menu",menuService.selectOne(id));
		   return "menu/menu_modify";
	   }
	   
	   // 게시물 수정 후 수정된 결과 보기
	   @PostMapping("/modifyMenu")
	   public String afterModify(Menu menu, MultipartFile file, HttpSession session) throws Exception {
		   session.setAttribute("listnum_mo", 2);
		   menuService.save(menu, file);
		   return "redirect:/menuContent?id="+menu.getId();
	   }
	   
}