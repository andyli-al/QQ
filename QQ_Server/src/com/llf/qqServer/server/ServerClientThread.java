package com.llf.qqServer.server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import com.llf.qqServer.controller.QQUserController;
import com.llf.qqcommon.pojo.Message;
import com.llf.qqcommon.pojo.QQUser;

/**
 * 服务器和某个客户端的通讯线程
 * @author llf
 *
 */
 public class ServerClientThread extends Thread{
	
	Socket s;
	
	public ServerClientThread(Socket s)
	{
		this.s=s;
	}
	
	public void notifyOthersFriends(int QQ_No)
	{
		//根据QQ号获取其他在线好友
		QQUserController qc=new QQUserController();
		List<QQUser> qqfriendsOnline=qc.getonlineFriends(QQ_No);
		
		Message m=new Message();
		m.setMesType("8");
		m.setSenderQQNo(QQ_No);
	    
		if(qqfriendsOnline.size()>0)
		{
		for(QQUser qqf:qqfriendsOnline)
		{
			//取得接收好友的通讯线程,循环通知
			try{
			ServerClientThread sct=ManageClientThread.getClientThread(qqf.getQQ_No());
			ObjectOutputStream oos=new ObjectOutputStream(sct.s.getOutputStream());
			m.setGetterQQNo(qqf.getQQ_No());
			oos.writeObject(m);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		}
	}
	
	public void run()
	{
		while(true)
		{
		//这里该线程就可以接收客户端的信息
		try
		{
		ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
		Message m=(Message) ois.readObject();
	
		if(m.getMesType().equals("3"))
		{
			//聊天信息，完成转发
			//取得接收人的通讯线程
			ServerClientThread sct=ManageClientThread.getClientThread(m.getGetterQQNo());
			ObjectOutputStream oos=new ObjectOutputStream(sct.s.getOutputStream());
			oos.writeObject(m);
		}else if(m.getMesType().equals("4"))
		{ 
			//退出登录,先提示好友自己下线,然后更改在线状态为下线,最后关闭资源
			QQUserController qc=new QQUserController();
			//提醒好友自己下线
			//根据QQ号获取其他在线好友
			List<QQUser> qqfriendsOnline=qc.getonlineFriends(m.getSenderQQNo());
			Message m2=new Message();
			m2.setMesType("9");
			m2.setSenderQQNo(m.getSenderQQNo());
			
			if(qqfriendsOnline.size()>0)
			{
			for(QQUser qqf:qqfriendsOnline)
			{
				//取得接收好友的通讯线程,循环通知
				try{
				ServerClientThread sct=ManageClientThread.getClientThread(qqf.getQQ_No());
				ObjectOutputStream oos=new ObjectOutputStream(sct.s.getOutputStream());
				m2.setGetterQQNo(qqf.getQQ_No());
				oos.writeObject(m2);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			}
			
			//更改状态
			qc.logout(m.getSenderQQNo());
			
			//关闭socket，关闭线程
			s.close();
			this.stop();	
			
		}else if(m.getMesType().equals("6"))
		{ 
			//编辑用户信息
			QQUserController qc=new QQUserController();
			qc.editQQuserMsg(m.getQquser());
			Message m2=new Message();
			m2.setMesType("7");
			m2.setQquser(m.getQquser());
			ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
			oos.writeObject(m2);
		}else if(m.getMesType().equals("12"))
		{
			//根据QQ号查询QQ
			QQUserController qc=new QQUserController();
			QQUser qquser_result=qc.getQQUserByNo(m.getQQ_No_find());
			Message m2=new Message();
			m2.setMesType("14");
			m2.setSenderQQNo(m.getSenderQQNo());
			List<QQUser> qquser_results=new ArrayList<QQUser>();
			if(qquser_result!=null)
			{
			qquser_results.add(qquser_result);
			}
			m2.setQqfriends(qquser_results);
			ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
			oos.writeObject(m2);
			
		}else if(m.getMesType().equals("13"))
		{
			//根据昵称关键字查询QQ
			QQUserController qc=new QQUserController();
			List<QQUser> qquser_result=qc.getQQUserBywebname(m.getQQ_webname_find());
			Message m2=new Message();
			m2.setMesType("14");
			m2.setSenderQQNo(m.getSenderQQNo());
			m2.setQqfriends(qquser_result);
			ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
			oos.writeObject(m2);
		}else if(m.getMesType().equals("10"))
		{
			//添加好友
			QQUserController qc=new QQUserController();
			qc.addQQFriend(m.getQquser().getQQ_No(), m.getQqfriend().getQQ_No());
			Message m2=new Message();
			m2.setMesType("15");
			m2.setQquser(m.getQquser());
			List<QQUser> qqfriends=qc.getQQfriends(m.getQquser().getQQ_No());
			m2.setQqfriends(qqfriends);
			ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
			oos.writeObject(m2);
			
			//如果被添加的好友在线,则也需刷新该好友的好友列表
			if(m.getQqfriend().getIsOnline()==1)
			{
			Message m3=new Message();
			m3.setMesType("15");
			m3.setQquser(m.getQqfriend());
			List<QQUser> qqfriends2=qc.getQQfriends(m.getQqfriend().getQQ_No());
			m3.setQqfriends(qqfriends2);
			ServerClientThread sct=ManageClientThread.getClientThread(m.getQqfriend().getQQ_No());
			ObjectOutputStream oos2=new ObjectOutputStream(sct.s.getOutputStream());
			oos2.writeObject(m3);
			}
			
		}else if(m.getMesType().equals("11"))
		{
			//删除好友
			QQUserController qc=new QQUserController();
			qc.deleteQQFriend(m.getQquser().getQQ_No(), m.getQqfriend().getQQ_No());
			Message m2=new Message();
			m2.setMesType("16");
			m2.setQquser(m.getQquser());
			List<QQUser> qqfriends=qc.getQQfriends(m.getQquser().getQQ_No());
			m2.setQqfriends(qqfriends);
			ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
			oos.writeObject(m2);
			
			//如果被删除的好友在线,则也需刷新该好友的好友列表
			if(m.getQqfriend().getIsOnline()==1)
			{
			Message m3=new Message();
			m3.setMesType("16");
			m3.setQquser(m.getQqfriend());
			List<QQUser> qqfriends2=qc.getQQfriends(m.getQqfriend().getQQ_No());
			m3.setQqfriends(qqfriends2);
			ServerClientThread sct=ManageClientThread.getClientThread(m.getQqfriend().getQQ_No());
			ObjectOutputStream oos2=new ObjectOutputStream(sct.s.getOutputStream());
			oos2.writeObject(m3);
			}
			
		}
		
		}catch(Exception e){
			e.printStackTrace();
		}
	  }
	}

}
