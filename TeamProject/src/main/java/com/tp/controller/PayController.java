package com.tp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PayController {
	
	@GetMapping("/cart")
	public String cart() {
		return "/pay/cart";
				
	}
	
	@GetMapping("/cart2")
	public String cart2() {
		return "/pay/cart2";
	}
	
	@RequestMapping("/success")
	public String success() {
		return "/pay/success";
	}
	
//	@GetMapping("/success")
//	public String success() {
//		return "/pay/success";
//	}
//	@PostMapping("/success")
//	public String successs() {
//		return "/pay/success";
//	}
	
	
	@GetMapping("/fail")
	public String fail() {
		return "/pay/fail";
	}
	@PostMapping("/fail")
	public String faill() {
		return "/pay/fail";
	}

}
