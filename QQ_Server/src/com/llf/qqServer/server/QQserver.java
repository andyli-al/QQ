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
 * QQ��������
 * @author llf
 *
 */
public class QQserver {
	
	public QQserver()
	{
         try {
			
			//��6666����
			System.out.println("���Ƿ���������6666����");
			ServerSocket ss=new ServerSocket(6666);
			//����,�ȴ�����
			while(true)
			{
				Socket s=ss.accept();
				//���տͻ��˷�������Ϣ.
				ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
				QQUser qquser=(QQUser) ois.readObject();
				Message m=new Message();
				ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
				QQUserLoginController qlc=new QQUserLoginController();
				QQUserController qc=new QQUserController();
				QQUser qquser_res=qlc.login(qquser.getQQ_No(), qquser.getQQ_pswd());
				
				if(qquser_res!=null)
				{
					//����һ����½�ɹ�����Ϣ��(QQ��½�û������к���)
					m.setMesType("1");
					m.setQquser(qquser_res);
					m.setQqfriends(qc.getQQfriends(qquser.getQQ_No()));
					oos.writeObject(m);
					
					//����͵���һ���̣߳��÷�������֮����ͨѶ
					ServerClientThread sct=new ServerClientThread(s);
					ManageClientThread.addClientThread(qquser.getQQ_No(), sct);
					//������ͨѶ�߳�
					sct.start();
					
					//֪ͨ�������ߺ���
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
