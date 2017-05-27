package com.llf.qqzone.dao;

import java.util.List;

import com.llf.qqzone.Entity.Talk;

public interface TalkDao {
	
	/**
	 * 添加说说
	 * @param talk
	 */
	public void addTalk(Talk talk);
	/**
	 * 根据QQ_No获取所有的说说
	 * @param QQ_No
	 * @return
	 */
	public List<Talk> getAllTalk(int QQ_No);
	/**
	 * 删除说说
	 * @param talkId
	 */
	public void deleteTalk(int talkId);

}
