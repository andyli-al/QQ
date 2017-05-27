package com.llf.qqzone.dao;

import com.llf.qqzone.Entity.QQUser;

/**
 * 空间访问权限验证
 * @author llf
 *
 */
public interface ZoneAccessDao {
	
	/**
	 * 空间访问QQ
	 * @param token
	 * @return
	 */
	public QQUser checkZoneAccessUser(String tokenId);
	/**
	 * 空间被访问QQ
	 * @param token
	 * @return
	 */
	public QQUser checkZoneBeAccessUser(String tokenId);

}
