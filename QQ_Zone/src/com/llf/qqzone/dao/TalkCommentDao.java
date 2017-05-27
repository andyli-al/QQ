package com.llf.qqzone.dao;

import java.util.List;

import com.llf.qqzone.Entity.TalkComment;
import com.llf.qqzone.Entity.TalkCommentInfo;

public interface TalkCommentDao {
	
	/**
	 * 添加说说评论
	 * @param tc
	 */
	public void addTalkComment(TalkComment tc);
	/**
	 * 删除说说评论
	 * @param talkCommentId
	 */
	public void deleteTalkComment(int talkCommentId);
	/**
	 * 获取指定说说的所有评论
	 * @param talkId
	 * @return
	 */
	public List<TalkCommentInfo> getAllCommentByTalk(int talkId);

}
