package com.llf.qqzone.dao;

import com.llf.qqzone.Entity.QQUser;

/**
 * �ռ����Ȩ����֤
 * @author llf
 *
 */
public interface ZoneAccessDao {
	
	/**
	 * �ռ����QQ
	 * @param token
	 * @return
	 */
	public QQUser checkZoneAccessUser(String tokenId);
	/**
	 * �ռ䱻����QQ
	 * @param token
	 * @return
	 */
	public QQUser checkZoneBeAccessUser(String tokenId);

}
