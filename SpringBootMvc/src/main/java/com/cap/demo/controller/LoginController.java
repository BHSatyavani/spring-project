package com.cap.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class LoginController {
@PostMapping
	public String validateLogin(@RequestParam("userName")String userName,
			@RequestParam("userPwd")String userPwd){
	
	
	
	
		return userPwd;
		
	}
	
}
