package com.llf.qqzone.util;

/**
 * 
 * @author llf
 * 生日与星座匹配处理类
 */
public class ConstellationUtil {
	
	/**
	 * 
	 * @param month
	 * @param day
	 * 12.22-1.19摩羯座 0
	 * 1.20-2.18水瓶座  1
	 * 2.19-3.20双鱼座  2
	 * 3.21-4.19白羊座  3
	 * 4.20-5.20金牛座  4
	 * 5.21-6.21双子座  5
	 * 6.22-7.22巨蟹座  6
	 * 7.23-8.22狮子座  7
	 * 8.23-9.22处女座  8
	 * 9.23-10.23天秤座  9
	 * 10.24-11.22天蝎座  10
	 * 11.23-12.21射手座  11
	 * @return星座的索引
	 */
	
   public static int getConstellationByDate(String month,String day)
   {
	   int result=0;
	   
	   if(Integer.parseInt(month)==1)
	   {
		   if(Integer.parseInt(day)<=19)
		   {
			   result=0;
		   }else
		   {
			   result=1;
		   }
	   }else if(Integer.parseInt(month)==2)
	   {
		   if(Integer.parseInt(day)<=18)
		   {
			   result=1;
		   }else
		   {
			   result=2;
		   }
	   }else if(Integer.parseInt(month)==3)
	   {
		   if(Integer.parseInt(day)<=20)
		   {
			   result=2;
		   }else
		   {
			   result=3;
		   }
	   }
	   else if(Integer.parseInt(month)==4)
	   {
		   if(Integer.parseInt(day)<=19)
		   {
			   result=3;
		   }else
		   {
			   result=4;
		   }
	   }
	   else if(Integer.parseInt(month)==5)
	   {
		   if(Integer.parseInt(day)<=20)
		   {
			   result=4;
		   }else
		   {
			   result=5;
		   }
	   }
	   else if(Integer.parseInt(month)==6)
	   {
		   if(Integer.parseInt(day)<=21)
		   {
			   result=5;
		   }else
		   {
			   result=6;
		   }
	   }
	   else if(Integer.parseInt(month)==7)
	   {
		   if(Integer.parseInt(day)<=22)
		   {
			   result=6;
		   }else
		   {
			   result=7;
		   }
	   }
	   else if(Integer.parseInt(month)==8)
	   {
		   if(Integer.parseInt(day)<=22)
		   {
			   result=7;
		   }else
		   {
			   result=8;
		   }
	   }
	   else if(Integer.parseInt(month)==9)
	   {
		   if(Integer.parseInt(day)<=22)
		   {
			   result=8;
		   }else
		   {
			   result=9;
		   }
	   }
	   else if(Integer.parseInt(month)==10)
	   {
		   if(Integer.parseInt(day)<=23)
		   {
			   result=9;
		   }else
		   {
			   result=10;
		   }
	   }
	   else if(Integer.parseInt(month)==11)
	   {
		   if(Integer.parseInt(day)<=22)
		   {
			   result=10;
		   }else
		   {
			   result=11;
		   }
	   }
	   else if(Integer.parseInt(month)==12)
	   {
		   if(Integer.parseInt(day)<=21)
		   {
			   result=11;
		   }else
		   {
			   result=0;
		   }
	   }
	   
	   return result;
   }
   
   public static String getConstellation(int index)
   {
	   String res="";
	   if(index==0)
	   {
		   res="摩羯座";
	   }else if(index==1)
	   {
		   res="水瓶座";
	   }else if(index==2)
	   {
		   res="双鱼座";
	   }else if(index==3)
	   {
		   res="白羊座";
	   }else if(index==4)
	   {
		   res="金牛座";
	   }else if(index==5)
	   {
		   res="双子座";
	   }else if(index==6)
	   {
		   res="巨蟹座";
	   }else if(index==7)
	   {
		   res="狮子座";
	   }else if(index==8)
	   {
		   res="处女座";
	   }else if(index==9)
	   {
		   res="天秤座";
	   }else if(index==10)
	   {
		   res="天蝎座";
	   }else if(index==11)
	   {
		   res="射手座";
	   }
	return res;
   }

   
}
