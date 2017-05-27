package com.llf.qqClient.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 
 * @author llf
 * �ļ�������
 */
public class FileDeal {
	
	//���û�ѡ���ͼƬ��ʱת��������
	public static void dealFile(String filename)
	{
		File f_source=new File(filename);
		//���ر���·��
		String savepath="";
		savepath="img_tx/tx_selected"+filename.substring(filename.lastIndexOf("."));
		FormatDataSave.set_tx_format((filename.substring(filename.lastIndexOf("."))));
		
        File sf=new File(savepath);
		FileInputStream fis=null;
		FileOutputStream fos=null;
		
		try {
			fis=new FileInputStream(f_source);
			fos=new FileOutputStream(sf);
			
			byte[] b=new byte[1024];
			int n=0;
			while((n=fis.read(b))!=-1)
			{
				fos.write(b);
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally
		{
			try {
				fos.close();
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	//��ȡͼƬ�Ŀ�͸�
	public static int[] getImageData(String filename) throws Exception
	{
		int[] res=new int[2];
		
		File f=new File(filename);
		
		BufferedImage sourceImg=ImageIO.read(new FileInputStream(f));
	    
		//��ȡͼƬ�Ŀ�
		res[0]=sourceImg.getWidth();
		
		//��ȡͼƬ�ĸ�
		res[1]=sourceImg.getHeight();
		
		return res;
	}

}
