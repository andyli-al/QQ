package com.llf.qqClient.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * ���մ�����
 * @author llf
 *
 */
public class BirthdayHandler {
	
	
	public static String[] handle(int u_age,Object o_birthday)
	{
		String s_birthday=null;
		if(o_birthday.getClass().getTypeParameters().equals("java.util.Date"))
		{
			s_birthday = o_birthday.toString();
		}else
		{
			s_birthday = new SimpleDateFormat("yyyy-MM-dd").format(o_birthday);
		}
		
		String[] ss=new String[3];
		//����1994-02-01
		String[] temp=s_birthday.split("-");
		ss[0]=temp[1]+"��"+temp[2]+"��";
	    int constellationIndex=ConstellationUtil.getConstellationByDate(temp[1], temp[2]);
	    if(constellationIndex==0)
	    {
	    	ss[1]="Ħ����";
	    }else if(constellationIndex==1)
	    {
	    	ss[1]="ˮƿ��";
	    }else if(constellationIndex==2)
	    {
	    	ss[1]="˫����";
	    }else if(constellationIndex==3)
	    {
	    	ss[1]="������";
	    }else if(constellationIndex==4)
	    {
	    	ss[1]="��ţ��";
	    }else if(constellationIndex==5)
	    {
	    	ss[1]="˫����";
	    }else if(constellationIndex==6)
	    {
	    	ss[1]="��з��";
	    }else if(constellationIndex==7)
	    {
	    	ss[1]="ʨ����";
	    }else if(constellationIndex==8)
	    {
	    	ss[1]="��Ů��";
	    }else if(constellationIndex==9)
	    {
	    	ss[1]="�����";
	    }else if(constellationIndex==10)
	    {
	    	ss[1]="��Ы��";
	    }else if(constellationIndex==11)
	    {
	    	ss[1]="������";
	    }
	    
	    int age=0;
	    if(u_age==0)
	    {
	    Calendar c=Calendar.getInstance();
		age=(c.get(Calendar.YEAR))-(Integer.parseInt(temp[0]));
		ss[2]=age+"";
	    }else
	    {	
	    age=u_age;
	    ss[2]=age+"";
	    }
		
		return ss;
	}
	
	
}
