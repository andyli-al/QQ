package com.llf.qqClient.util;

/**
 * 
 * @author llf
 * �û���ѡͼƬ��Ϣ�洢��
 */
public class FormatDataSave {
	
	//ͼƬ�ĸ�ʽ
	public static String tx_format;
	//ͼƬ�Ŀ�߼�
	public static int[] tx_size=new int[2];
	
	public static void set_tx_format(String tf)
	{
		tx_format=tf;
	}
	
	public static void set_ts(int width,int height)
	{
		tx_size[0]=width;
		tx_size[1]=height;
	}

}
