package com.llf.qqzone.dao;

import com.llf.qqzone.Entity.ZoneAccessPermission;

public interface ZoneAccessPermissionDao {
	
   /**
    * ��ӷ���Ȩ��
    */
   public void addPermission(ZoneAccessPermission zp);
   /**
    * 
    *����QQ��������пɷ���Ȩ��
    */
   public void deleteAllPermission(int QQ_No);

}
