package com.llf.qqClient.client;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.llf.qqcommon.pojo.Message;
import com.llf.qqcommon.pojo.QQUser;


public class QQClientUser {
	
	private Socket s;
	
	/**
	 * 用户登陆验证
	 * @param o
	 * @return
	 */
	public Message sendLoginInfoToServer(Object o)
	{
		Message m=null;
		try
		{
	    s=new Socket("127.0.0.1",6666);
		ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
		oos.writeObject(o);
		
		ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
		Message ms=(Message)ois.readObject();
		if(ms.getMesType().equals("1"))
		{
			//登陆验证成功
			//就创建一个该QQ号与服务器通讯的线程
			ClientServerThread cst=new ClientServerThread(s);
			//启动通讯线程
			cst.start();
			ManageClientToServerThread.addClientToServerThread(((QQUser) o).getQQ_No(), cst);
			m=ms;
		}else
		{
			//关闭socket
			s.close();
		}
		
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
		}
		
		return m;
	}

}
