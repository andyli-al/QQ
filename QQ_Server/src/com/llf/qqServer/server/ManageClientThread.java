package com.llf.qqServer.server;

import java.util.HashMap;

/**
 * ����ͻ����߳�
 * @author llf
 *
 */
public class ManageClientThread {
	
	public static HashMap hm=new HashMap<Integer,ServerClientThread>();
	
	//��hm�м���ͻ���ͨѶ�߳�
	public static void addClientThread(int QQ_No,ServerClientThread sct)
	{
		hm.put(QQ_No, sct);
	}
	
	public static ServerClientThread getClientThread(int QQ_No)
	{
		return (ServerClientThread) hm.get(QQ_No);
	}

}
