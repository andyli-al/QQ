package com.llf.qqClient.Controller;

import java.io.ObjectOutputStream;

import com.llf.qqClient.client.ManageClientToServerThread;
import com.llf.qqcommon.pojo.Message;
import com.llf.qqcommon.pojo.QQUser;

/**
 * QQ�û���������
 * @author llf
 *
 */
public class QQUserController {
	
	/**
	 * �༭����
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
	 * �˳���¼
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
	 * ���Ͳ�ѯ�������ݵ�������
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
	 * ���Ͳ�ѯ�������ݵ�������
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
	 * ���QQ����
	 * @param QQ_No
	 * @param qq_friend_no
	 */
	public void addfriend(QQUser qquser,QQUser qqfriend)
	{
		Message m=new Message();
		m.setMesType("10");
		//����QQ
		m.setQquser(qquser);
		//������ӵĺ���QQ
		m.setQqfriend(qqfriend);
		
	    try{
	    	ObjectOutputStream oos=new ObjectOutputStream(ManageClientToServerThread.getClientToServerThread(qquser.getQQ_No()).getS().getOutputStream());
	    	oos.writeObject(m);
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
	}
	
	/**
	 * ɾ������
	 * @param QQ_No
	 * @param QQ_friend_No
	 */
	public void deletefriend(QQUser qquser,QQUser qqfriend)
	{
		Message m=new Message();
		m.setMesType("11");
		//����QQ
		m.setQquser(qquser);
		//����ɾ���ĺ���QQ
	   m.setQqfriend(qqfriend);
	   
	   try{
	    	ObjectOutputStream oos=new ObjectOutputStream(ManageClientToServerThread.getClientToServerThread(qquser.getQQ_No()).getS().getOutputStream());
	    	oos.writeObject(m);
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
		
	}
}
