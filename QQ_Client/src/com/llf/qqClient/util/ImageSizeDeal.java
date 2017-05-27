package com.llf.qqClient.util;

/**
 * 
 * @author llf
 * 图片大小等比例放缩处理类
 */
public class ImageSizeDeal {
	
	/*
	 * 获取源图像等比例缩放后的图片的宽和高
	 */
	public static double[] getImageSizeAfterDeal()
	{
		double res[]=new double[2];
		 /*
		 * 在这里，我们规定
		 * 合成处理面板窗体的长宽限制源图像等比例缩放后的宽高为：width<=380,height<=340
		 */
		double width=FormatDataSave.tx_size[0];
		double height=FormatDataSave.tx_size[1];
	
		//处理图片宽高不同的情况
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
