package com.llf.qqzone.Entity;

import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable{
	
	private int messageId;
	private String messageContent;
	private java.util.Date publishDate;
	private int QQ_No;
	private int QQ_friend;
	public int getMessageId() {
		return messageId;
	}
	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}
	public String getMessageContent() {
		return messageContent;
	}
	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
	public java.util.Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(java.util.Date publishDate) {
		this.publishDate = publishDate;
	}
	public int getQQ_No() {
		return QQ_No;
	}
	public void setQQ_No(int qQNo) {
		QQ_No = qQNo;
	}
	public int getQQ_friend() {
		return QQ_friend;
	}
	public void setQQ_friend(int qQFriend) {
		QQ_friend = qQFriend;
	}
	public Message() {
		super();
	}
	public Message(int messageId, String messageContent, Date publishDate,
			int qQNo, int qQFriend) {
		super();
		this.messageId = messageId;
		this.messageContent = messageContent;
		this.publishDate = publishDate;
		QQ_No = qQNo;
		QQ_friend = qQFriend;
	}
	

}
