package com.llf.qqClient.util;

/**
 * 
 * @author llf
 * ʡ�й���������
 */
public class ProvinceCityContact {

	/**
	 * 
	 * @param province
	 * @return cities
	 */
	public static String[] getCitiesByProvince(String province)
	{
		//ģ�����ø���ʡ��ֻ�ṩ5����ѡ��Ͻ����
		String cities[]=new String[10];
		
		switch(province)
		{
		   case "����":
			   cities[0]="����";
			   cities[1]="����";
			   cities[2]="����";
			   cities[3]="����";
			   cities[4]="��ƽ";
			   break;
		   case "�Ϻ�":
			   cities[0]="����";
			   cities[1]="���";
			   cities[2]="��ɽ";
			   cities[3]="�ζ�";
			   cities[4]="�ֶ�����";
			   break;
		   case "���":
			   cities[0]="��ƽ";
			   cities[1]="�Ӷ�";
			   cities[2]="����";
			   cities[3]="�Ͽ�";
			   cities[4]="����";
			   break;
		   case "����":
			   cities[0]="����";
			   cities[1]="����";
			   cities[2]="�ϰ�";
			   cities[3]="ɳƺ��";
			   cities[4]="����";
			   break;
		   case "����":
			   cities[0]="�Ͼ�";
			   cities[1]="����";
			   cities[2]="����";
			   cities[3]="����";
			   cities[4]="����";
			   break;
		   case "�㽭":
			   cities[0]="����";
			   cities[1]="����";
			   cities[2]="����";
			   cities[3]="����";
			   cities[4]="����";
			   break;
		   case "�㶫":
			   cities[0]="����";
			   cities[1]="����";
			   cities[2]="��ݸ";
			   cities[3]="��ɽ";
			   cities[4]="�麣";
			   break;
		   case "����":
			   cities[0]="����";
			   cities[1]="����";
			   cities[2]="Ȫ��";
			   cities[3]="����";
			   cities[4]="����";
			   break;
		   case "ɽ��":
			   cities[0]="����";
			   cities[1]="�ൺ";
			   cities[2]="��̨";
			   cities[3]="����";
			   cities[4]="����";
			   break;
		   case "����":
			   cities[0]="����";
			   cities[1]="����";
			   cities[2]="��˳";
			   cities[3]="����";
			   cities[4]="����";
			   break;
		   case "���ɹ�":
			   cities[0]="���ͺ���";
			   cities[1]="��ͷ";
			   cities[2]="���ױ���";
			   cities[3]="���";
			   cities[4]="������˹";
			   break;
		}
		
		
		return cities;
	}
}
