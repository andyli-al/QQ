package com.llf.qqServer.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ���һ���ӿڵ�ʵ����ʵ��
 * @author llf
 *
 */
public class GetDaoEntity {
	static ApplicationContext ctx=null;
	static{
		 ctx=new ClassPathXmlApplicationContext("beans.xml");
	}
	
	public static Object GetDao(String dao_sr)
	{
		Object obj_res=ctx.getBean(dao_sr);
	    return obj_res;
	}

}
