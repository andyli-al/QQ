package com.llf.qqzone.dao;

import com.llf.qqzone.Entity.QQUser;

public interface QQUserDao {
	
	/**
	 * QQ注册
	 * @param qquser
	 */
    public void register(QQUser qquser);
    /**
     * 获取当前QQ号最大值
     * @return int
     */
    public Object getQQNoMax();
    /**
     * 登录
     * @param qquser
     * @return
     */
    public QQUser login(QQUser qquser);
    /**
     * 更改个人资料
     * @param qquser
     */
    public void editPersonalMsg(QQUser qquser);
}
