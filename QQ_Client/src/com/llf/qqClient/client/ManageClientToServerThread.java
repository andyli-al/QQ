package com.llf.qqClient.client;

import java.util.HashMap;
/**
 * @author llf
 * �������ӵ��������Ŀͻ������߳���
 *
 */
public class ManageClientToServerThread {
	
	private static HashMap hm=new HashMap<Integer,ClientServerThread>();

	//�Ѵ����õ�ͨѶ�̷߳��뵽hm
	public static void addClientToServerThread(int QQ_No,ClientServerThread cst)
	{
		hm.put(QQ_No, cst);
	}
	
	public static ClientServerThread getClientToServerThread(int QQ_No)
	{
		return (ClientServerThread) hm.get(QQ_No);
	}
}
