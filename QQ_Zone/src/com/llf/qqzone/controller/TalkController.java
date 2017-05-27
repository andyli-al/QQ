package com.llf.qqzone.controller;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.llf.qqzone.Entity.Talk;
import com.llf.qqzone.Entity.TalkComment;
import com.llf.qqzone.Entity.TalkCommentInfo;
import com.llf.qqzone.dao.TalkCommentDao;
import com.llf.qqzone.dao.TalkDao;

@Controller
public class TalkController {
	
	@Autowired
	private TalkDao talkDao;
	@Autowired
	private TalkCommentDao talkCommentDao;
	
	//发表说说
	@RequestMapping("/addTalk")
	public String addTalk(@RequestParam("talkcontent")String talkcontent,@RequestParam("QQ_No")int QQ_No,Model model)
	{
		Talk talk=new Talk();
		talk.setTalkcontent(talkcontent);
		talk.setQQ_No(QQ_No);
		Calendar now=Calendar.getInstance();
		talk.setTalkTime(new Time(now.getTimeInMillis()));
		
		talkDao.addTalk(talk);
		
		//完成页面回发
		String res=getAllTalks(QQ_No,model);
		
		return res;
	}
	
	//获取指定QQ所有的说说
	@RequestMapping("/getAllTalks")
	public String getAllTalks(@RequestParam("QQ_No")int QQ_No,Model model)
	{
		//获取指定QQ的所有说说
		List<Talk> result=talkDao.getAllTalk(QQ_No);
		model.addAttribute("result", result);
		//遍历获取所有说说的评论
		List<TalkCommentInfo> temp=null;
		List<List<TalkCommentInfo>> resultComments=new ArrayList<List<TalkCommentInfo>>();
		for(Talk talk:result)
		{
			temp=talkCommentDao.getAllCommentByTalk(talk.getTalkId());
			resultComments.add(temp);
		}
		model.addAttribute("resultComments", resultComments);
		
		return "talk_main";
		
	}
	
	//删除指定说说(会将其下的评论一并删除)
	@RequestMapping("/deleteTalk")
	@Transactional
	public String deleteTalk(@RequestParam("talkId")int talkId,@RequestParam("QQ_No")int QQ_No,Model model)
	{
		talkDao.deleteTalk(talkId);
		//完成页面回发
		String res=getAllTalks(QQ_No,model);
		
		return res;
		
	}
	
	
	//添加说说评论
	@RequestMapping("/addTalkomment")
	@Transactional
	public String addTalkComment(@RequestParam("talkCommentContent")String talkCommentContent,@RequestParam("talkId")int talkId,@RequestParam("QQ_commentNo")int QQ_commentNo,@RequestParam("QQ_No")int QQ_No,Model model)
	{
		TalkComment tc=new TalkComment();
		tc.setTalkCommentContent(talkCommentContent);
		tc.setTalkId(talkId);
		tc.setQQ_No(QQ_commentNo);
		Calendar now=Calendar.getInstance();
		tc.setPublishDate(new Time(now.getTimeInMillis()));
		
		talkCommentDao.addTalkComment(tc);
		
		//完成页面的回发
		String res=getAllTalks(QQ_No,model);
		
		return res;
		
	}
	
	//删除说说评论
	@RequestMapping("/deleteTalkComment")
	@Transactional
	public String deleteTalkComment(@RequestParam("talkCommentId")int talkCommentId,@RequestParam("QQ_No")int QQ_No,Model model)
	{
		talkCommentDao.deleteTalkComment(talkCommentId);
		//完成页面的回发
		String res=getAllTalks(QQ_No,model);
		
		return res;
		
	}
	

}
