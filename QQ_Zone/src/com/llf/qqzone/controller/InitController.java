package com.llf.qqzone.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InitController {
	
	//定位到登录页面
	@RequestMapping("to_login")
	public String to_login()
	{
		return "login";
	}
	
	//定位到注册页面
	@RequestMapping("/to_register")
	public String to_regiter()
	{
		return "register";		
	}

}
