package com.llf.qqzone.Entity;

import java.io.Serializable;
import java.util.Date;

public class TalkComment implements Serializable{
	
	private int talkCommentId;
	private String talkCommentContent;
	private java.util.Date publishDate;
	private int talkId;
	private int QQ_No;
	public int getTalkCommentId() {
		return talkCommentId;
	}
	public void setTalkCommentId(int talkCommentId) {
		this.talkCommentId = talkCommentId;
	}
	public String getTalkCommentContent() {
		return talkCommentContent;
	}
	public void setTalkCommentContent(String talkCommentContent) {
		this.talkCommentContent = talkCommentContent;
	}
	public java.util.Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(java.util.Date publishDate) {
		this.publishDate = publishDate;
	}
	public int getTalkId() {
		return talkId;
	}
	public void setTalkId(int talkId) {
		this.talkId = talkId;
	}
	public int getQQ_No() {
		return QQ_No;
	}
	public void setQQ_No(int qQNo) {
		QQ_No = qQNo;
	}
	public TalkComment() {
		super();
	}
	public TalkComment(int talkCommentId, String talkCommentContent,
			Date publishDate, int talkId, int qQNo) {
		super();
		this.talkCommentId = talkCommentId;
		this.talkCommentContent = talkCommentContent;
		this.publishDate = publishDate;
		this.talkId = talkId;
		QQ_No = qQNo;
	}

}
