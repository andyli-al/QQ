package com.llf.qqzone.dao;

import com.llf.qqzone.Entity.ZoneAccessPermission;

public interface ZoneAccessPermissionDao {
	
   /**
    * 添加访问权限
    */
   public void addPermission(ZoneAccessPermission zp);
   /**
    * 
    *根据QQ号清空所有可访问权限
    */
   public void deleteAllPermission(int QQ_No);

}
