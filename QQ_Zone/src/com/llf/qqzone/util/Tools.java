package com.llf.qqzone.util;

import java.io.UnsupportedEncodingException;


public class Tools {
	
	//�ṩһ�����������ַ���gb2312��UTF-8��gbkת������
	public static String getNewString(String input)
	{
		String result="";
		try {
			result=new String(input.getBytes("iso-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
		
			e.printStackTrace();
		}
		return result;
	}

}
