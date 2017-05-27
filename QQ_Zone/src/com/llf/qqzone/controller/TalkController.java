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
	
	//����˵˵
	@RequestMapping("/addTalk")
	public String addTalk(@RequestParam("talkcontent")String talkcontent,@RequestParam("QQ_No")int QQ_No,Model model)
	{
		Talk talk=new Talk();
		talk.setTalkcontent(talkcontent);
		talk.setQQ_No(QQ_No);
		Calendar now=Calendar.getInstance();
		talk.setTalkTime(new Time(now.getTimeInMillis()));
		
		talkDao.addTalk(talk);
		
		//���ҳ��ط�
		String res=getAllTalks(QQ_No,model);
		
		return res;
	}
	
	//��ȡָ��QQ���е�˵˵
	@RequestMapping("/getAllTalks")
	public String getAllTalks(@RequestParam("QQ_No")int QQ_No,Model model)
	{
		//��ȡָ��QQ������˵˵
		List<Talk> result=talkDao.getAllTalk(QQ_No);
		model.addAttribute("result", result);
		//������ȡ����˵˵������
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
	
	//ɾ��ָ��˵˵(�Ὣ���µ�����һ��ɾ��)
	@RequestMapping("/deleteTalk")
	@Transactional
	public String deleteTalk(@RequestParam("talkId")int talkId,@RequestParam("QQ_No")int QQ_No,Model model)
	{
		talkDao.deleteTalk(talkId);
		//���ҳ��ط�
		String res=getAllTalks(QQ_No,model);
		
		return res;
		
	}
	
	
	//���˵˵����
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
		
		//���ҳ��Ļط�
		String res=getAllTalks(QQ_No,model);
		
		return res;
		
	}
	
	//ɾ��˵˵����
	@RequestMapping("/deleteTalkComment")
	@Transactional
	public String deleteTalkComment(@RequestParam("talkCommentId")int talkCommentId,@RequestParam("QQ_No")int QQ_No,Model model)
	{
		talkCommentDao.deleteTalkComment(talkCommentId);
		//���ҳ��Ļط�
		String res=getAllTalks(QQ_No,model);
		
		return res;
		
	}
	

}
