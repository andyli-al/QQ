package com.llf.qqzone.Entity;

import java.io.Serializable;
import java.util.Date;

public class MessageInfo implements Serializable{
	
	private int messageId;
	private String messageContent;
	private java.util.Date publishDate;
	private int QQ_No;
	private QQUser qquser;
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
	public QQUser getQquser() {
		return qquser;
	}
	public void setQquser(QQUser qquser) {
		this.qquser = qquser;
	}
	public MessageInfo() {
		super();
	}
	public MessageInfo(int messageId, String messageContent, Date publishDate,
			int qQNo, QQUser qquser) {
		super();
		this.messageId = messageId;
		this.messageContent = messageContent;
		this.publishDate = publishDate;
		QQ_No = qQNo;
		this.qquser = qquser;
	}

}
