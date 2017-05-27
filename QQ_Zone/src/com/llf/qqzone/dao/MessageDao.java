package com.llf.qqzone.dao;

import java.util.List;

import com.llf.qqzone.Entity.Message;
import com.llf.qqzone.Entity.MessageInfo;
import com.llf.qqzone.Entity.PageData;

public interface MessageDao {
	
	/**
	 * �������
	 * @param m
	 */
	public void addMessage(Message m);
	/**
	 * ɾ������
	 * @param messageId
	 */
	public void deleteMessage(int messageId);
	  /**
     * ��ȡָ��QQ�����������ܼ�¼��
     * @return int 
     */
	public int getRowcount(int QQ_No); 
	/**
	 * ��ҳ��ȡָ��QQ�������б�
	 * @param pd
	 * @return List<CourseInfo>
	 */
	public List<MessageInfo> getMessageInfoByPage(PageData pd);

}
