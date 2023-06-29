package com.tp.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class HomeController {

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/test")
	public String test() {
		return "test";
	}
	
}
