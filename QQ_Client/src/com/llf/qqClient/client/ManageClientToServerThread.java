package com.llf.qqClient.client;

import java.util.HashMap;
/**
 * @author llf
 * 管理连接到服务器的客户单的线程类
 *
 */
public class ManageClientToServerThread {
	
	private static HashMap hm=new HashMap<Integer,ClientServerThread>();

	//把创建好的通讯线程放入到hm
	public static void addClientToServerThread(int QQ_No,ClientServerThread cst)
	{
		hm.put(QQ_No, cst);
	}
	
	public static ClientServerThread getClientToServerThread(int QQ_No)
	{
		return (ClientServerThread) hm.get(QQ_No);
	}
}
