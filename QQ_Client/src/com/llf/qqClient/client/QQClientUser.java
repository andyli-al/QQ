package com.llf.qqClient.client;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.llf.qqcommon.pojo.Message;
import com.llf.qqcommon.pojo.QQUser;


public class QQClientUser {
	
	private Socket s;
	
	/**
	 * �û���½��֤
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
			//��½��֤�ɹ�
			//�ʹ���һ����QQ���������ͨѶ���߳�
			ClientServerThread cst=new ClientServerThread(s);
			//����ͨѶ�߳�
			cst.start();
			ManageClientToServerThread.addClientToServerThread(((QQUser) o).getQQ_No(), cst);
			m=ms;
		}else
		{
			//�ر�socket
			s.close();
		}
		
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
		}
		
		return m;
	}

}
