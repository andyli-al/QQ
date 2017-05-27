package com.llf.qqClient.client;

import java.util.HashMap;

import com.llf.qqClient.ui.SearchQQAdd;

public class ManageSearchPanel {
	
private static HashMap hm=new HashMap<Integer,SearchQQAdd>();
	
	//º”»ÎSearchQQAdd
	public static void addSearchQQPanel(int QQ_No,SearchQQAdd sa)
	{
		hm.put(QQ_No, sa);
	}
	
	public static SearchQQAdd getSearchQQPanel(int QQ_No)
	{
		return (SearchQQAdd) hm.get(QQ_No);
	}

}
