package com.tp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tp.entity.UserEntity;
import com.tp.firebase.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import com.tp.DTO.UserDTO;
import com.tp.service.FirebaseService;
import com.tp.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	FirebaseService firebaseService;
	
	
	@GetMapping("/login")
	public String login() {
		
	return "user/login";
		
	}
	
	
	@GetMapping("/join")
	public String join() {
	      
	return "user/join";
	}
	
	
	@GetMapping("/mypage")
	public String mypage() {
	      
	return "user/mypage";
	}
	
	
	
	@PostMapping("/join")
	public String joinUser(UserDTO userDTO, RedirectAttributes rttr){

		UserEntity user = UserEntity.builder().username(userDTO.getUsername()).name(userDTO.getName()).password(userDTO.getPassword()).phone(userDTO.getPhone()).email(userDTO.getEmail()).address(userDTO.getAddress()).build();
		
//		firebaseService.insertUser(userDTO.getId() ,userDTO.getName(), userDTO.getAddress(), userDTO.getEmail(),userDTO.getPassword(), userDTO.getPhone(), userDTO.getUsername());
		final String username = userDTO.getUsername();
		if(userService.idCheck(username)==0) {
			userService.save(user);
			rttr.addFlashAttribute("result", "OK");
			return "redirect:/joinresult";
		}else {
			rttr.addFlashAttribute("result", "idExist!");
			return "redirect:/joinresult";
		}
		
	}
	
	@RequestMapping("/joinresult")
	public String joinresult() {
		
		return "user/joinresult";
	}
	
	@RequestMapping("/loginresult")
	public String loginresult() {
		
		return "user/loginresult";
				
	}
	
	@PostMapping("/login")
	public String loginUser(@RequestParam("username") final String username, @RequestParam("password") final String password,Model model, HttpSession session, RedirectAttributes rttr){
		
		UserEntity user= userService.UserInfo(username);
		
		if(userService.loginChek(username, password)==0) {
//			UserEntity user = userService.getByCredentials(username, password);
			rttr.addFlashAttribute("result", "OK");
			session.setAttribute("username", username);
			session.setAttribute("name", user.getName());
			session.setAttribute("id", user.getId());
			
			return "redirect:/loginresult";
		}else if(userService.loginChek(username, password)==1) {
			rttr.addFlashAttribute("result", "FAIL");
			return "redirect:/loginresult";
		}else if(userService.loginChek(username, password)==2)
			rttr.addFlashAttribute("result", "NONE_ID");
			return "redirect:/loginresult";

		
		
	}
	
//	@PostMapping("/login")
//    public String login(@RequestBody String idToken, RedirectAttributes rttr) {
//		Firebase firebase = new Firebase();
//		firebase.init();
//        try {
//            FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(idToken);
//            String uid = decodedToken.getUid();
//            // 로그인 성공
//            rttr.addFlashAttribute("result", "OK");
//            return "redirect:/loginresult";
//        } catch (FirebaseAuthException e) {
//            // 로그인 실패
//        	rttr.addFlashAttribute("result", "FAIL");
//        	return "redirect:/loginresult";
//        }
//    }
	
	@GetMapping("/update")
	
	public String update(HttpSession session) {
		String username=(String)session.getAttribute("username");
		UserEntity userinfo = userService.UserInfo(username);
		if(username!=null) {
			session.setAttribute("user", userinfo);
			session.setAttribute("username", userinfo.getUsername());
			session.setAttribute("name", userinfo.getName());
			return "/user/update";
		}else {
			return "redirect:/sessionover";
		}

	}
	
	@PostMapping("/update")
	
	public String update(UserEntity user, HttpSession session) {
		userService.save(user);
		UserEntity userinfo = userService.UserInfo(user.getUsername());
		session.setAttribute("username", userinfo.getUsername());
		session.setAttribute("name", userinfo.getName());
		return "/user/mypage";
	}
	
	@GetMapping("/pwupdate")
	public String pwupdate(HttpSession session) {
		String username=(String)session.getAttribute("username");
		UserEntity userinfo = userService.UserInfo(username);
		if(username!=null) {
			session.setAttribute("user", userinfo);
			return "/user/pwupdate";
		}
		 return "redirect:/sessionover";
	}
	
	@PostMapping("/pwupdate")
	public String pwupdate(HttpSession session, @RequestParam("password") final String password) {
		UserEntity user = (UserEntity)session.getAttribute("user");
		user.setPassword(password);
		userService.save(user);
		session.setAttribute("username", user.getUsername());
		session.setAttribute("name", user.getName());
		return "/user/mypage";
	}
	
	
	@GetMapping("/delete")
	   public String delete(HttpSession session) {
		String username = (String)session.getAttribute("username"); 
		UserEntity userinfo = userService.UserInfo(username);
		if(username!=null) {
			session.setAttribute("id", userinfo.getId());
			session.setAttribute("username", userinfo.getUsername());
			session.setAttribute("user", userinfo);
			return "/user/delete";
		}
		 return "redirect:/sessionover";
		
		
	
	}
	
	@PostMapping("/delete")
	public String delete(HttpSession session, @RequestParam("password") final String password) {
		if(session.getAttribute("id")!=null) {
			String id=(String)session.getAttribute("id");
			UserEntity user = (UserEntity)session.getAttribute("user");
			if(user.getPassword().equals(password)) {
				userService.deleteById(id);
				session.invalidate();
				return "/user/login";
			}else {
				return "/user/mypage";
			}
		}else {
			
			return "redirect:/sessionover";
		}
		
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
	       
		   session.invalidate();
	        
	        
		   return "redirect:/";        
	        
}
	
	@GetMapping("/sessionover")
	public String sessionover(HttpSession session) {
		session.setAttribute("nosession", "NO");
		return "user/sessionover";
	}

}
