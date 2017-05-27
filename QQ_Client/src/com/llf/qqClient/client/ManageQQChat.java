package com.llf.qqClient.client;

import java.util.HashMap;

import com.llf.qqClient.ui.QQChat;

/**
 * @author llf
 * ����QQ�������
 *
 */
public class ManageQQChat {
	
	private static HashMap hm=new HashMap<String,QQChat>();
	
	//����QQChat
	public static void addQQChat(String loginUserAndFriendNo,QQChat qc)
	{
		hm.put(loginUserAndFriendNo, qc);
	}
	
	public static QQChat getQQChat(String loginUserAndFriendNo)
	{
		return (QQChat) hm.get(loginUserAndFriendNo);
	}

}
