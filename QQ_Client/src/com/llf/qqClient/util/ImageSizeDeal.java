package com.llf.qqClient.util;

/**
 * 
 * @author llf
 * ͼƬ��С�ȱ�������������
 */
public class ImageSizeDeal {
	
	/*
	 * ��ȡԴͼ��ȱ������ź��ͼƬ�Ŀ�͸�
	 */
	public static double[] getImageSizeAfterDeal()
	{
		double res[]=new double[2];
		 /*
		 * ��������ǹ涨
		 * �ϳɴ�����崰��ĳ�������Դͼ��ȱ������ź�Ŀ��Ϊ��width<=380,height<=340
		 */
		double width=FormatDataSave.tx_size[0];
		double height=FormatDataSave.tx_size[1];
	
		//����ͼƬ��߲�ͬ�����
	   if((width>380&&height>340)||(width<=380&&height<=340))
	   {
		   if((double)(380/width)*height<=340)
		   {
			   res[0]=380;
			   res[1]=(double)(380/width)*height;
		   }
		   else if((double)(340/height)*width<=380)
		   {
			   res[0]=(double)(340/height)*width;
			   res[1]=340;
		   }
	   }else if(width<=380&&height>340)
	   {
		   res[0]=(double)(340/height)*width;
		   res[1]=340;
	   }else if(width>380&&height<=340)
	   {
		   res[0]=380;
		   res[1]=(double)(380/width)*height;
	   }
		return res;
	}
	
}
