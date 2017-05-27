package com.llf.qqClient.util;

/**
 * 
 * @author llf
 * 用户所选图片信息存储类
 */
public class FormatDataSave {
	
	//图片的格式
	public static String tx_format;
	//图片的宽高集
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
