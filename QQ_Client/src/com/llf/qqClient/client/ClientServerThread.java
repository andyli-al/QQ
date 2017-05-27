package com.llf.qqClient.client;

import java.io.ObjectInputStream;
import java.net.Socket;

import com.llf.qqClient.ui.PersonalInfoEditor;
import com.llf.qqClient.ui.QQChat;
import com.llf.qqClient.ui.QQPanel;
import com.llf.qqClient.ui.SearchQQAdd;
import com.llf.qqcommon.pojo.Message;

/**
 * @author llf
 *某个客户端和服务器通讯的线程
 *
 */
public class ClientServerThread extends Thread{
	
	private Socket s;
	
	public ClientServerThread(Socket s)
	{
		this.s=s;
	}
	
	public void run()
	{
		while(true)
		{
			//不停读取从服务端发来的信息
			try
			{
			ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
			Message m=(Message)ois.readObject();
			
		    if(m.getMesType().equals("3"))
		    {
		    	//把从服务器获得的消息显示到指定的聊天界面
				 QQChat qqchat=ManageQQChat.getQQChat(m.getGetterQQNo()+","+m.getSenderQQNo());
				 qqchat.showMsg(m);
				 
		    }else if(m.getMesType().equals("7"))
		    {
		    	//信息修改成功,刷新页面数据
		    	PersonalInfoEditor.showResult(m.getQquser());
		    }else if(m.getMesType().equals("8"))
		    {
		    	//好友上线提示,更新好友列表
		    	QQPanel qqp=ManageQQPanel.getQQPanel(m.getGetterQQNo());
		    	qqp.updateFriendlist_online(m);
		    }else if(m.getMesType().equals("9"))
		    {
		    	//好友下线提示,更新好友列表
		    	QQPanel qqp=ManageQQPanel.getQQPanel(m.getGetterQQNo());
		    	qqp.updateFriendlist_dropline(m);
		    }else if(m.getMesType().equals("14"))
		    {
		    	//获取查询QQ用户结果,并刷新查找页面
		    	SearchQQAdd sqa=ManageSearchPanel.getSearchQQPanel(m.getSenderQQNo());
		    	sqa.setValueToJtable(m);	
		    }else if(m.getMesType().equals("15"))
		    {
		    	//添加好友成功,及时更新好友列表
		    	QQPanel qqp=ManageQQPanel.getQQPanel(m.getQquser().getQQ_No());
		    	qqp.recreateUI(m.getQquser(), m.getQqfriends());
		    }else if(m.getMesType().equals("16"))
		    {
		    	//删除好友成功,及时更新好友列表
		    	QQPanel qqp=ManageQQPanel.getQQPanel(m.getQquser().getQQ_No());
		    	qqp.recreateUI(m.getQquser(), m.getQqfriends());
		    }
			 	 
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}

	public void setS(Socket s) {
		this.s = s;
	}
	
	public Socket getS() {
		return s;
	}
}
