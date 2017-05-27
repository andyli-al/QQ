package com.llf.qqzone.Entity;

import java.io.Serializable;
import java.util.Date;

public class TalkCommentInfo implements Serializable{
	
	private int talkCommentId;
	private String talkCommentContent;
	private java.util.Date publishDate;
	private int talkId;
	private QQUser qquser;
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
	public QQUser getQquser() {
		return qquser;
	}
	public void setQquser(QQUser qquser) {
		this.qquser = qquser;
	}
	public TalkCommentInfo() {
		super();
	}
	public TalkCommentInfo(int talkCommentId, String talkCommentContent,
			Date publishDate, int talkId, QQUser qquser) {
		super();
		this.talkCommentId = talkCommentId;
		this.talkCommentContent = talkCommentContent;
		this.publishDate = publishDate;
		this.talkId = talkId;
		this.qquser = qquser;
	}

}
