package com.llf.qqzone.dao;

import java.util.List;

import com.llf.qqzone.Entity.Talk;

public interface TalkDao {
	
	/**
	 * ���˵˵
	 * @param talk
	 */
	public void addTalk(Talk talk);
	/**
	 * ����QQ_No��ȡ���е�˵˵
	 * @param QQ_No
	 * @return
	 */
	public List<Talk> getAllTalk(int QQ_No);
	/**
	 * ɾ��˵˵
	 * @param talkId
	 */
	public void deleteTalk(int talkId);

}
