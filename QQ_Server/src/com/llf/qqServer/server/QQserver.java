package com.llf.qqServer.server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.llf.qqServer.controller.QQUserController;
import com.llf.qqServer.controller.QQUserLoginController;
import com.llf.qqcommon.pojo.Message;
import com.llf.qqcommon.pojo.QQUser;

/**
 * QQ服务器类
 * @author llf
 *
 */
public class QQserver {
	
	public QQserver()
	{
         try {
			
			//在6666监听
			System.out.println("我是服务器，在6666监听");
			ServerSocket ss=new ServerSocket(6666);
			//阻塞,等待连接
			while(true)
			{
				Socket s=ss.accept();
				//接收客户端发来的信息.
				ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
				QQUser qquser=(QQUser) ois.readObject();
				Message m=new Message();
				ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
				QQUserLoginController qlc=new QQUserLoginController();
				QQUserController qc=new QQUserController();
				QQUser qquser_res=qlc.login(qquser.getQQ_No(), qquser.getQQ_pswd());
				
				if(qquser_res!=null)
				{
					//返回一个登陆成功的信息报(QQ登陆用户和所有好友)
					m.setMesType("1");
					m.setQquser(qquser_res);
					m.setQqfriends(qc.getQQfriends(qquser.getQQ_No()));
					oos.writeObject(m);
					
					//这里就单开一个线程，让服务器与之保持通讯
					ServerClientThread sct=new ServerClientThread(s);
					ManageClientThread.addClientThread(qquser.getQQ_No(), sct);
					//启动该通讯线程
					sct.start();
					
					//通知其他在线好友
					sct.notifyOthersFriends(qquser.getQQ_No());
					
				}else
				{
					m.setMesType("2");
					oos.writeObject(m);
					s.close();
				}
					
			}	
			
			
		} catch (Exception e) {
			e.printStackTrace();
	
		}finally{
			
		}
		
	}

}
