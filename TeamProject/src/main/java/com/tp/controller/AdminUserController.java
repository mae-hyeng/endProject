package com.tp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tp.entity.AdminUser;
import com.tp.entity.UserEntity;
import com.tp.service.AdminUserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class AdminUserController {

	@Autowired
	AdminUserService adminUserService;

	@GetMapping("/adminLogin")
	public String adminLogin() {
		return "admin/adminLogin";
	}

	@RequestMapping("/loginResult")
	public String loginResult() {
		return "admin/loginResult";
	}

	@PostMapping("/adminLogin")
	public String adminUser(@RequestParam("username") final String username,
			@RequestParam("password") final String password, Model model, HttpSession session,
			RedirectAttributes rttr) {
		
//		session.setAttribute("username", username);
		
		if (adminUserService.loginCheck(username, password) == 0) {
			rttr.addFlashAttribute("result", "OK");
			session.setAttribute("username", username);

			return "redirect:/loginResult";
		} else if (adminUserService.loginCheck(username, password) == 1) {
			rttr.addFlashAttribute("result", "FAIL");
			return "redirect:/loginResult";
		} else if (adminUserService.loginCheck(username, password) == 2)
			rttr.addFlashAttribute("result", "NONE_ID");
			return "redirect:/loginResult";
			
	}
	
	@GetMapping("/adminSessionover")
	public String sessionover(HttpSession session) {
		session.setAttribute("nosession", "NO");
		return "admin/adminSessionover";
	}
	
	
}