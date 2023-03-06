package com.cos.recorSys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsersController {
	
	

	@GetMapping({"","/"})
	public String index() {
		return "index";
	}	
	@GetMapping("/auth/join")
	public String joinForm() {
		return "user/joinForm";
	}
	@GetMapping("/auth/login")
	public String loginForm() {
		return "user/loginForm";
	}
	@GetMapping("/auth/update")
	public String updateForm() {
		return "user/updateForm";
	}

	@GetMapping("/mypage")
	public String mypage() {
		return "user/mypage";
	}
	

}	

	
	

