package com.tp.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.internal.FirebaseService;

@Controller
public class HomeController {

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	
}
