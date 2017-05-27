package com.llf.qqcommon.pojo;

import java.util.List;

public class Message implements java.io.Serializable{

    private String mesType;
    
	private int senderQQNo;
	private int getterQQNo;
	private String sender;
	private String getter;
	private String content;
	private String sendTime;
	private QQUser qquser;
	private QQUser qqfriend;
	private List<QQUser> qqfriends;
	private int QQ_No_find;
	private String QQ_webname_find;
	public String getMesType() {
		return mesType;
	}
	public void setMesType(String mesType) {
		this.mesType = mesType;
	}
	public int getSenderQQNo() {
		return senderQQNo;
	}
	public void setSenderQQNo(int senderQQNo) {
		this.senderQQNo = senderQQNo;
	}
	public int getGetterQQNo() {
		return getterQQNo;
	}
	public void setGetterQQNo(int getterQQNo) {
		this.getterQQNo = getterQQNo;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getGetter() {
		return getter;
	}
	public void setGetter(String getter) {
		this.getter = getter;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSendTime() {
		return sendTime;
	}
	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}
	public QQUser getQquser() {
		return qquser;
	}
	public void setQquser(QQUser qquser) {
		this.qquser = qquser;
	}
	public List<QQUser> getQqfriends() {
		return qqfriends;
	}
	public void setQqfriends(List<QQUser> qqfriends) {
		this.qqfriends = qqfriends;
	}
	public int getQQ_No_find() {
		return QQ_No_find;
	}
	public void setQQ_No_find(int qQ_No_find) {
		QQ_No_find = qQ_No_find;
	}
	public String getQQ_webname_find() {
		return QQ_webname_find;
	}
	public void setQQ_webname_find(String qQ_webname_find) {
		QQ_webname_find = qQ_webname_find;
	}
	public QQUser getQqfriend() {
		return qqfriend;
	}
	public void setQqfriend(QQUser qqfriend) {
		this.qqfriend = qqfriend;
	}
	
}
