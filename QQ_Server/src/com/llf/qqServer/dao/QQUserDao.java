package com.llf.qqServer.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;

import com.llf.qqcommon.pojo.QQUser;

public interface QQUserDao {
	
	/**
	 * ����QQ����
	 */
	public void updateQQuserMsg(QQUser qquser);
	/**
	 * ����QQ�Ż�ȡQQ�����б�
	 * @param QQ_No
	 * @return
	 */
	public List<QQUser> getQQfriends(int QQ_No);
	/**
	 * �˳���¼
	 * @param QQ_No
	 */
	public void logout(int QQ_No);
	/**
	 * ����QQ�Ż�ȡ�������ߺ���
	 * @param QQ_No
	 * @return
	 */
	public List<QQUser> getOnlineFriends(int QQ_No);
	/**
	 * ����QQ_No��ѯQQ
	 * @param QQ_No
	 * @return
	 */
	public QQUser getQQUserByNo(int QQ_No);
	/**
	 * �����ǳƹؼ��ֲ�ѯQQ
	 * @param QQ_webname
	 * @return
	 */
	public List<QQUser> getQQUserBywebname(String QQ_webname);
	/**
	 * ��Ӻ���
	 * @param QQ_No
	 * @param QQ_friend_No
	 */
	@Insert("insert into QQ_friend (QQ_No,QQ_friend_No) values(#{0},#{1})")
	public void addQQfriend(int QQ_No,int QQ_friend_No);
	
	/**
	 * ɾ������
	 * @param QQ_No
	 * @param QQ_friend_No
	 */
	@Delete("delete from QQ_friend where QQ_No=#{0} and QQ_friend_No=#{1}")
	public void deleteQQfriend(int QQ_No,int QQ_friend_No);

}
