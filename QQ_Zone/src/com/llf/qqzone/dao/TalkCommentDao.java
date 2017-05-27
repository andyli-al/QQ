package com.llf.qqzone.dao;

import java.util.List;

import com.llf.qqzone.Entity.TalkComment;
import com.llf.qqzone.Entity.TalkCommentInfo;

public interface TalkCommentDao {
	
	/**
	 * ���˵˵����
	 * @param tc
	 */
	public void addTalkComment(TalkComment tc);
	/**
	 * ɾ��˵˵����
	 * @param talkCommentId
	 */
	public void deleteTalkComment(int talkCommentId);
	/**
	 * ��ȡָ��˵˵����������
	 * @param talkId
	 * @return
	 */
	public List<TalkCommentInfo> getAllCommentByTalk(int talkId);

}
