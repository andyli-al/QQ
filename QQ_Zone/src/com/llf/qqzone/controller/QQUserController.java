package com.llf.qqzone.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.llf.qqzone.Entity.QQUser;
import com.llf.qqzone.dao.QQUserDao;
import com.llf.qqzone.dao.ZoneAccessDao;

@Controller
public class QQUserController {
	
	@Autowired
	private QQUserDao qquserDao;
	@Autowired
	private ZoneAccessDao zoneAccessDao;
	
	//QQ账号注册
	@RequestMapping("/register")
	public void qq_register(@RequestParam("QQ_webname")String QQ_webname,@RequestParam("QQ_pswd")String QQ_pswd,@RequestParam("u_sex")String u_sex,@RequestParam("birth_year")String birth_year,@RequestParam("birth_month")String birth_month,@RequestParam("birth_date")String birth_date,@RequestParam("stayCity_county")String stayCity_county,@RequestParam("stayCity_province")String stayCity_province,@RequestParam("stayCity_city")String stayCity_city,HttpServletResponse response) throws IOException
	{
		QQUser qquser=new QQUser();
		qquser.setQQ_webname(QQ_webname);
		qquser.setQQ_pswd(QQ_pswd);
		qquser.setU_sex(u_sex);
		if(birth_month.length()==1)
		{
			birth_month="0"+birth_month;
		}
		if(birth_date.length()==1)
		{
			birth_date="0"+birth_date;
		}
		String s_birthday=birth_year+"-"+birth_month+"-"+birth_date;
		
		Date d_birthday=null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			d_birthday = sdf.parse(s_birthday);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Calendar c=Calendar.getInstance();
		qquser.setU_age((c.get(Calendar.YEAR))-(Integer.parseInt(birth_year)));
		String s_stayCity=stayCity_county+stayCity_province+stayCity_city;
		qquser.setU_birthday(d_birthday);
		qquser.setU_staycity(s_stayCity);
		
		//自增生成QQ号,从10000开始增长
		//先查询出目前QQ号最大值
		int QQ_No=10000;
		Object obj=qquserDao.getQQNoMax();
		if(obj!=null)
		QQ_No=(Integer)obj+1;
		
		qquser.setQQ_No(QQ_No);
		qquserDao.register(qquser);
		
		String msg="注册成功,你的QQ号码是"+QQ_No+",请不要忘记喔!";
		
		response.setContentType("text/html;charset=utf-8"); 
		response.getWriter().print(msg);
	
	}
	
	//QQ空间登录
	@RequestMapping("/login")
	public String login(@RequestParam(value=("QQ_No"),required=false,defaultValue="")int QQ_No,@RequestParam(value=("QQ_pswd"),required=false,defaultValue="")String QQ_pswd,HttpServletRequest request)
	{
		if((QQ_No+"").equals("")||QQ_pswd.equals(""))
		{
			if(request.getSession().getAttribute("qquser")==null)
			return "login";
			else
				return "qqzone_main";
		}else
		{
		QQUser qquser=new QQUser();
		qquser.setQQ_No(QQ_No);
		qquser.setQQ_pswd(QQ_pswd);
		if(qquserDao.login(qquser)!=null)
		{  
			//获取该QQ号码的所有资源
			request.getSession().setAttribute("qquser", qquserDao.login(qquser));
			request.getSession().setAttribute("webname", qquserDao.login(qquser).getQQ_webname());
			request.getSession().setAttribute("qqno", qquserDao.login(qquser).getQQ_No());
			request.getSession().setAttribute("qqno2",qquserDao.login(qquser).getQQ_No());
			
			return "qqzone_main";
		}else
		return "to_login";
		}	
	}
	
	//QQ通过凭证访问空间
	@RequestMapping("/loginzone")
	public String loginzone(@RequestParam("tokenId")String tokenId,HttpServletRequest request)
	{
	    //获取访问凭证后到数据库中验证
		QQUser qquser2=zoneAccessDao.checkZoneAccessUser(tokenId);
		QQUser qquser=zoneAccessDao.checkZoneBeAccessUser(tokenId);
	
		if(qquser!=null)
		{
			//获取该QQ号码的所有资源
			request.getSession().setAttribute("qquser", qquser);
			request.getSession().setAttribute("webname", qquser.getQQ_webname());
			request.getSession().setAttribute("qqno", qquser.getQQ_No());
			request.getSession().setAttribute("qqno2", qquser2.getQQ_No());
			
			return "qqzone_main";
		}else
		{
			return "to_login";
		}
	}
	
	
	//更改个人资料
	@Transactional
	@RequestMapping("/editPersonnalMsg")
	public String editPersonnalMsg(@RequestParam("QQ_No")int QQ_No,@RequestParam("QQ_webname")String QQ_webname,@RequestParam("QQ_sign")String QQ_sign,@RequestParam("u_sex")String u_sex,@RequestParam("birth_year")String birth_year,@RequestParam("birth_month")String birth_month,@RequestParam("birth_date")String birth_date,@RequestParam("stayCity_county")String stayCity_county,@RequestParam("stayCity_province")String stayCity_province,@RequestParam("stayCity_city")String stayCity_city,@RequestParam("hometown_county")String hometown_county,@RequestParam("hometown_province")String hometown_province,@RequestParam("hometown_city")String hometown_city,@RequestParam("u_education")String u_education,@RequestParam("u_profession")String u_profession,HttpServletRequest request)
	{
		QQUser qquser=new QQUser();
		qquser.setQQ_No(QQ_No);
		qquser.setQQ_webname(QQ_webname);
		qquser.setQQ_sign(QQ_sign);
		qquser.setU_sex(u_sex);
		if(birth_month.length()==1)
		{
			birth_month="0"+birth_month;
		}
		if(birth_date.length()==1)
		{
			birth_date="0"+birth_date;
		}
		String s_birthday=birth_year+"-"+birth_month+"-"+birth_date;
		
		Date d_birthday=null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			d_birthday = sdf.parse(s_birthday);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Calendar c=Calendar.getInstance();
		qquser.setU_age((c.get(Calendar.YEAR))-(Integer.parseInt(birth_year)));
		String s_stayCity=stayCity_county+stayCity_province+stayCity_city;
		qquser.setU_birthday(d_birthday);
		qquser.setU_staycity(s_stayCity);
		String s_hometown=hometown_county+hometown_province+hometown_city;
		qquser.setU_hometown(s_hometown);
		qquser.setU_education(u_education);
		qquser.setU_profession(u_profession);
		
		qquserDao.editPersonalMsg(qquser);
		//更新session中数据
		request.getSession().setAttribute("qquser", qquser);
		
		return "personal_main";
		
	}
	
	//退出空间
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request)
	{
		//销毁session
		request.getSession().invalidate();
		return "login";
	}

}
