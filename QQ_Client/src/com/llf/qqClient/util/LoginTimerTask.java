package com.llf.qqClient.util;

import java.util.List;
import java.util.TimerTask;

import com.llf.qqClient.client.ManageQQPanel;
import com.llf.qqClient.ui.LoginLoad;
import com.llf.qqClient.ui.QQPanel;
import com.llf.qqcommon.pojo.QQUser;

/**
 * 
 * @author llf
 * ��ʱ�����࣬5������ڵ�½����رղ��ͷ��߳�ռ����Դ
 *
 */
public class LoginTimerTask  extends TimerTask{
	
	private static LoginLoad ll=null;
	private static QQUser qquser=null;
	private static List<QQUser> qqfs=null;
		
	public static void setdata(LoginLoad lolod,QQUser qu,List<QQUser> qqfriends)
	{
		ll=lolod;
		qquser=qu;
		qqfs=qqfriends;
	}
	
	@Override
	public void run() {
		
		//���ڵ�½����ر�
		ll.dispose();
		//�������ڵ�½������߳�,�ͷ���Դ
		LoginLoad.t.stop();
		//��ʾ��½�ɹ���QQ������
		QQPanel qqp=new QQPanel(qquser,qqfs);
		ManageQQPanel.addQQPanel(qquser.getQQ_No(), qqp);
	
	}
	

}
