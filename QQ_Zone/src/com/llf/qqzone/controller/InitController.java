package com.llf.qqzone.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InitController {
	
	//��λ����¼ҳ��
	@RequestMapping("to_login")
	public String to_login()
	{
		return "login";
	}
	
	//��λ��ע��ҳ��
	@RequestMapping("/to_register")
	public String to_regiter()
	{
		return "register";		
	}

}
