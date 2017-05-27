package com.llf.qqzone.controller;

import java.sql.Time;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.llf.qqzone.Entity.Message;
import com.llf.qqzone.Entity.MessageInfo;
import com.llf.qqzone.Entity.PageData;
import com.llf.qqzone.dao.MessageDao;
import com.llf.qqzone.util.GetPageIndex;

@Controller
public class MessageController {
	
	@Autowired
	private MessageDao messageDao;
	
	//添加留言
	@RequestMapping("/addMessage")
	@Transactional
	public String addMessage(@RequestParam("messageContent")String messageContent,@RequestParam("QQ_No")int QQ_No,@RequestParam("QQ_friend")int QQ_friend,Model model)
	{
		Message m=new Message();
		m.setMessageContent(messageContent);
		m.setQQ_No(QQ_No);
		m.setQQ_friend(QQ_friend);
		Calendar now=Calendar.getInstance();
		m.setPublishDate(new Time(now.getTimeInMillis()));
		
		messageDao.addMessage(m);
		
		//完成页面回发，自动跳回第一页
		String res=getMessageListByPage(QQ_No,1,model);
		
		return res;
		
	}
	
	//分页获取留言列表
	@RequestMapping("/getMessageListByPage")
	public String getMessageListByPage(@RequestParam("QQ_No")int QQ_No,@RequestParam("pageIndex")int pageIndex,Model model)
	{
		 int rowCount=messageDao.getRowcount(QQ_No);
		 int pageCount=(rowCount-1)/10+1;
		 PageData pd=GetPageIndex.getData(pageIndex, 10);
		 pd.setQQ_No(QQ_No);
		 List<MessageInfo> result=messageDao.getMessageInfoByPage(pd);
		 
	   	 model.addAttribute("result", result);
	   	 model.addAttribute("pageIndex", pageIndex);
	   	 model.addAttribute("rowCount", rowCount);
	   	 model.addAttribute("pageCount", pageCount);
	   	 
		return "message_main";
		
	}
	
	
	//删除留言
	@RequestMapping("/deleteMessage")
	@Transactional
	public String deleteMessage(@RequestParam("messageId")int messageId,@RequestParam("QQ_No")int QQ_No,@RequestParam("pageIndex")int pageIndex,Model model)
	{
		messageDao.deleteMessage(messageId);
		//完成页面回发，跳转本页
		String res=getMessageListByPage(QQ_No,pageIndex,model);
		
		return res;
	}

}
