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
 *ĳ���ͻ��˺ͷ�����ͨѶ���߳�
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
			//��ͣ��ȡ�ӷ���˷�������Ϣ
			try
			{
			ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
			Message m=(Message)ois.readObject();
			
		    if(m.getMesType().equals("3"))
		    {
		    	//�Ѵӷ�������õ���Ϣ��ʾ��ָ�����������
				 QQChat qqchat=ManageQQChat.getQQChat(m.getGetterQQNo()+","+m.getSenderQQNo());
				 qqchat.showMsg(m);
				 
		    }else if(m.getMesType().equals("7"))
		    {
		    	//��Ϣ�޸ĳɹ�,ˢ��ҳ������
		    	PersonalInfoEditor.showResult(m.getQquser());
		    }else if(m.getMesType().equals("8"))
		    {
		    	//����������ʾ,���º����б�
		    	QQPanel qqp=ManageQQPanel.getQQPanel(m.getGetterQQNo());
		    	qqp.updateFriendlist_online(m);
		    }else if(m.getMesType().equals("9"))
		    {
		    	//����������ʾ,���º����б�
		    	QQPanel qqp=ManageQQPanel.getQQPanel(m.getGetterQQNo());
		    	qqp.updateFriendlist_dropline(m);
		    }else if(m.getMesType().equals("14"))
		    {
		    	//��ȡ��ѯQQ�û����,��ˢ�²���ҳ��
		    	SearchQQAdd sqa=ManageSearchPanel.getSearchQQPanel(m.getSenderQQNo());
		    	sqa.setValueToJtable(m);	
		    }else if(m.getMesType().equals("15"))
		    {
		    	//��Ӻ��ѳɹ�,��ʱ���º����б�
		    	QQPanel qqp=ManageQQPanel.getQQPanel(m.getQquser().getQQ_No());
		    	qqp.recreateUI(m.getQquser(), m.getQqfriends());
		    }else if(m.getMesType().equals("16"))
		    {
		    	//ɾ�����ѳɹ�,��ʱ���º����б�
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
