package com.llf.qqzone.util;

import com.llf.qqzone.Entity.PageData;

/**
 *��ҳ��ѯ������װʵ����
 */
public class GetPageIndex {
	
	public static PageData getData(int pageIndex,int pageSize)
	{
		PageData pd=new PageData();
		pd.setStart_index((pageIndex-1)*pageSize);
		pd.setEnd_index(pageSize);
		return pd;
	}

}
