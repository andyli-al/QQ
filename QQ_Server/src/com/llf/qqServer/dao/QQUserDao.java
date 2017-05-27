package com.llf.qqServer.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;

import com.llf.qqcommon.pojo.QQUser;

public interface QQUserDao {
	
	/**
	 * 更改QQ资料
	 */
	public void updateQQuserMsg(QQUser qquser);
	/**
	 * 根据QQ号获取QQ好友列表
	 * @param QQ_No
	 * @return
	 */
	public List<QQUser> getQQfriends(int QQ_No);
	/**
	 * 退出登录
	 * @param QQ_No
	 */
	public void logout(int QQ_No);
	/**
	 * 根据QQ号获取其他在线好友
	 * @param QQ_No
	 * @return
	 */
	public List<QQUser> getOnlineFriends(int QQ_No);
	/**
	 * 根据QQ_No查询QQ
	 * @param QQ_No
	 * @return
	 */
	public QQUser getQQUserByNo(int QQ_No);
	/**
	 * 根据昵称关键字查询QQ
	 * @param QQ_webname
	 * @return
	 */
	public List<QQUser> getQQUserBywebname(String QQ_webname);
	/**
	 * 添加好友
	 * @param QQ_No
	 * @param QQ_friend_No
	 */
	@Insert("insert into QQ_friend (QQ_No,QQ_friend_No) values(#{0},#{1})")
	public void addQQfriend(int QQ_No,int QQ_friend_No);
	
	/**
	 * 删除好友
	 * @param QQ_No
	 * @param QQ_friend_No
	 */
	@Delete("delete from QQ_friend where QQ_No=#{0} and QQ_friend_No=#{1}")
	public void deleteQQfriend(int QQ_No,int QQ_friend_No);

}
