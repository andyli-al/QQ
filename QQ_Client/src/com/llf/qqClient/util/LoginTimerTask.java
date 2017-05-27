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
 * 定时任务类，5秒后正在登陆界面关闭并释放线程占用资源
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
		
		//正在登陆界面关闭
		ll.dispose();
		//结束正在登陆界面的线程,释放资源
		LoginLoad.t.stop();
		//显示登陆成功后QQ面板界面
		QQPanel qqp=new QQPanel(qquser,qqfs);
		ManageQQPanel.addQQPanel(qquser.getQQ_No(), qqp);
	
	}
	

}
