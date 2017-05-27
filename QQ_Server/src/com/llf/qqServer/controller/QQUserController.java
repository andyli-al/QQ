package com.llf.qqServer.controller;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.llf.qqServer.dao.QQUserDao;
import com.llf.qqServer.util.GetDaoEntity;
import com.llf.qqcommon.pojo.QQUser;

/**
 * 用户信息控制器
 * @author llf
 *
 */
public class QQUserController {
	
	private static QQUserDao qquserDao=null;
	static{
		
		qquserDao=(QQUserDao) GetDaoEntity.GetDao("QQUserDao");
	}
	
	/**
	 * 编辑用户信息
	 * @param qquser
	 */
	@Transactional
	public void editQQuserMsg(QQUser qquser)
	{
		qquserDao.updateQQuserMsg(qquser);
	}
	
	/**
	 * 根据QQ号获取QQ好友列表
	 * @param QQ_No
	 * @return
	 */
	public List<QQUser> getQQfriends(int QQ_No)
	{
		return qquserDao.getQQfriends(QQ_No);	
	}
	
	/**
	 * 退出登录
	 * @param QQ_No
	 */
	public void logout(int QQ_No)
	{
		qquserDao.logout(QQ_No);
	}
	
	/**
	 * 根据QQ号获取其他在线好友
	 * @param QQ_No
	 * @return
	 */
	public List<QQUser> getonlineFriends(int QQ_No)
	{
		return qquserDao.getOnlineFriends(QQ_No);
	}
	
	/**
	 * 根据QQ号码查询QQ
	 * @param QQ_No
	 * @return
	 */
	public QQUser getQQUserByNo(int QQ_No)
	{
		return qquserDao.getQQUserByNo(QQ_No);
	}
	
	/**
	 * 根据昵称关键字查询QQ
	 * @param QQ_webname
	 * @return
	 */
	public List<QQUser> getQQUserBywebname(String QQ_webname)
	{
		List<QQUser> result=qquserDao.getQQUserBywebname(QQ_webname);
		return result;
	}

	
	/**
	 * 添加好友
	 * @param QQ_No
	 * @param QQ_friend_No
	 * @return
	 */
	@Transactional
	public void addQQFriend(int QQ_No,int QQ_friend_No)
	{
		qquserDao.addQQfriend(QQ_No, QQ_friend_No);
		qquserDao.addQQfriend(QQ_friend_No, QQ_No);
	}
	
	/**
	 * 删除好友
	 * @param QQ_No
	 * @param QQ_friend_No
	 */
	@Transactional
	public void deleteQQFriend(int QQ_No,int QQ_friend_No)
	{
		qquserDao.deleteQQfriend(QQ_No, QQ_friend_No);
		qquserDao.deleteQQfriend(QQ_friend_No, QQ_No);
	}
}
 