package com.llf.qqzone.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PsersonalController {
	
	//定位到个人档
	@RequestMapping("/to_personalMain")
	public String to_personalMain(@RequestParam("QQ_No")int QQ_No)
	{
		return "personal_main";
	}

}
