package com.llf.qqClient.client;

import java.util.HashMap;

import com.llf.qqClient.ui.QQPanel;

public class ManageQQPanel {

private static HashMap hm=new HashMap<Integer,QQPanel>();
	
	//º”»ÎQQPanel
	public static void addQQPanel(int QQ_No,QQPanel qp)
	{
		hm.put(QQ_No, qp);
	}
	
	public static QQPanel getQQPanel(int QQ_No)
	{
		return (QQPanel) hm.get(QQ_No);
	}
}
