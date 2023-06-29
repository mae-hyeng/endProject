package com.tp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PayController {
	
	@GetMapping("/cart")
	public String cart() {
		return "/pay/cart";
				
	}
	
	@GetMapping("/pay")
	public String pay() {
		return "/pay/pay";
	}
	
	@RequestMapping("/success")
	public String success() {
		return "/pay/success";
	}
	
	@RequestMapping("/fail")
	public String fail() {
		return "/pay/fail";
	}

}
