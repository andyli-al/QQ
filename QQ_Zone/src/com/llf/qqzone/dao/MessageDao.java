package com.llf.qqzone.dao;

import java.util.List;

import com.llf.qqzone.Entity.Message;
import com.llf.qqzone.Entity.MessageInfo;
import com.llf.qqzone.Entity.PageData;

public interface MessageDao {
	
	/**
	 * 添加留言
	 * @param m
	 */
	public void addMessage(Message m);
	/**
	 * 删除留言
	 * @param messageId
	 */
	public void deleteMessage(int messageId);
	  /**
     * 获取指定QQ的所有留言总记录数
     * @return int 
     */
	public int getRowcount(int QQ_No); 
	/**
	 * 分页获取指定QQ的留言列表
	 * @param pd
	 * @return List<CourseInfo>
	 */
	public List<MessageInfo> getMessageInfoByPage(PageData pd);

}
