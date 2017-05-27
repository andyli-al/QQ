package com.llf.qqClient.Controller;

import java.io.ObjectOutputStream;

import com.llf.qqClient.client.ManageClientToServerThread;
import com.llf.qqcommon.pojo.Message;
import com.llf.qqcommon.pojo.QQUser;

/**
 * QQ用户控制器类
 * @author llf
 *
 */
public class QQUserController {
	
	/**
	 * 编辑资料
	 * @param qquser
	 */
	public void editPersonalMsg(QQUser qquser)
	{
		Message m=new Message();
		m.setMesType("6");
		m.setQquser(qquser);
		
		try{
			ObjectOutputStream oos=new ObjectOutputStream(ManageClientToServerThread.getClientToServerThread(qquser.getQQ_No()).getS().getOutputStream());
			oos.writeObject(m);
			
		}catch(Exception e){
		   e.printStackTrace();
		}
	
	}
	
	/**
	 * 退出登录
	 * @param QQ_No
	 */
	public void logout(int QQ_No)
	{
		Message m=new Message();
		m.setMesType("4");
		m.setSenderQQNo(QQ_No);
		try{
			
			ObjectOutputStream oos=new ObjectOutputStream(ManageClientToServerThread.getClientToServerThread(QQ_No).getS().getOutputStream());
			oos.writeObject(m);
		}catch(Exception e2){
			e2.printStackTrace();
		}
	}

	/**
	 * 发送查询条件数据到服务器
	 * @param QQ_No
	 */
	public void sendSearchDataInt(int QQ_No,int find_No)
	{
		Message m=new Message();
		m.setMesType("12");
		m.setSenderQQNo(QQ_No);
	    m.setQQ_No_find(find_No);
		
		try{
			ObjectOutputStream oos=new ObjectOutputStream(ManageClientToServerThread.getClientToServerThread(QQ_No).getS().getOutputStream());
			oos.writeObject(m);
				
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 发送查询数条件据到服务器
	 * @param QQ_webname
	 */
	public void sendSearchDataString(int QQ_No,String QQ_webname_find)
	{
         Message m=new Message();
	     m.setMesType("13");
	     m.setSenderQQNo(QQ_No);
	     m.setQQ_webname_find(QQ_webname_find);
		
		try{
			ObjectOutputStream oos=new ObjectOutputStream(ManageClientToServerThread.getClientToServerThread(QQ_No).getS().getOutputStream());
			oos.writeObject(m);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 添加QQ好友
	 * @param QQ_No
	 * @param qq_friend_no
	 */
	public void addfriend(QQUser qquser,QQUser qqfriend)
	{
		Message m=new Message();
		m.setMesType("10");
		//本人QQ
		m.setQquser(qquser);
		//即将添加的好友QQ
		m.setQqfriend(qqfriend);
		
	    try{
	    	ObjectOutputStream oos=new ObjectOutputStream(ManageClientToServerThread.getClientToServerThread(qquser.getQQ_No()).getS().getOutputStream());
	    	oos.writeObject(m);
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
	}
	
	/**
	 * 删除好友
	 * @param QQ_No
	 * @param QQ_friend_No
	 */
	public void deletefriend(QQUser qquser,QQUser qqfriend)
	{
		Message m=new Message();
		m.setMesType("11");
		//本人QQ
		m.setQquser(qquser);
		//即将删除的好友QQ
	   m.setQqfriend(qqfriend);
	   
	   try{
	    	ObjectOutputStream oos=new ObjectOutputStream(ManageClientToServerThread.getClientToServerThread(qquser.getQQ_No()).getS().getOutputStream());
	    	oos.writeObject(m);
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
		
	}
}
