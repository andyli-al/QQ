package com.llf.qqzone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.llf.qqzone.Entity.ZoneAccessPermission;
import com.llf.qqzone.dao.ZoneAccessPermissionDao;

@Controller
public class ZoneAccessPermissionController {
	
	@Autowired
	private ZoneAccessPermissionDao zoneAccessPermissionDao;
	
	//添加空间访问权限
	@RequestMapping("/addPermission")
	@Transactional
	public String addPermission(@RequestParam("QQ_No")int QQ_No,@RequestParam("QQ_friend")int QQ_friend)
	{
		//先清空原有权限记录
		zoneAccessPermissionDao.deleteAllPermission(QQ_No);
		
		ZoneAccessPermission zp=new ZoneAccessPermission();
		zp.setQQ_No(QQ_No);
		zp.setQQ_friend(QQ_friend);
		
		System.out.println(QQ_No);
		System.out.println(QQ_friend);
		
		zoneAccessPermissionDao.addPermission(zp);
		
		return "test";
		
		
	}

}
