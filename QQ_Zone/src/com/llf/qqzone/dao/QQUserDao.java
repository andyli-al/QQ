package com.llf.qqzone.dao;

import com.llf.qqzone.Entity.QQUser;

public interface QQUserDao {
	
	/**
	 * QQע��
	 * @param qquser
	 */
    public void register(QQUser qquser);
    /**
     * ��ȡ��ǰQQ�����ֵ
     * @return int
     */
    public Object getQQNoMax();
    /**
     * ��¼
     * @param qquser
     * @return
     */
    public QQUser login(QQUser qquser);
    /**
     * ���ĸ�������
     * @param qquser
     */
    public void editPersonalMsg(QQUser qquser);
}
