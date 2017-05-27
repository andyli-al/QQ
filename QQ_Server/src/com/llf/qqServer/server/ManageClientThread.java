package com.llf.qqServer.server;

import java.util.HashMap;

/**
 * 管理客户端线程
 * @author llf
 *
 */
public class ManageClientThread {
	
	public static HashMap hm=new HashMap<Integer,ServerClientThread>();
	
	//像hm中加入客户端通讯线程
	public static void addClientThread(int QQ_No,ServerClientThread sct)
	{
		hm.put(QQ_No, sct);
	}
	
	public static ServerClientThread getClientThread(int QQ_No)
	{
		return (ServerClientThread) hm.get(QQ_No);
	}

}
