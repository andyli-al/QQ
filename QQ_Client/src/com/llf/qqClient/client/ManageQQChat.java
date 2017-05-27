package com.llf.qqClient.client;

import java.util.HashMap;

import com.llf.qqClient.ui.QQChat;

/**
 * @author llf
 * 管理QQ聊天界面
 *
 */
public class ManageQQChat {
	
	private static HashMap hm=new HashMap<String,QQChat>();
	
	//加入QQChat
	public static void addQQChat(String loginUserAndFriendNo,QQChat qc)
	{
		hm.put(loginUserAndFriendNo, qc);
	}
	
	public static QQChat getQQChat(String loginUserAndFriendNo)
	{
		return (QQChat) hm.get(loginUserAndFriendNo);
	}

}
