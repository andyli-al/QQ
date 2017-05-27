package com.llf.qqcommon.pojo;

import java.io.Serializable;

public class QQFriendInfo implements Serializable{

	private int QQ_friendId;
	private int QQ_No;
	private QQUser qqfriend;
	public int getQQ_friendId() {
		return QQ_friendId;
	}
	public void setQQ_friendId(int qQ_friendId) {
		QQ_friendId = qQ_friendId;
	}
	public int getQQ_No() {
		return QQ_No;
	}
	public void setQQ_No(int qQ_No) {
		QQ_No = qQ_No;
	}
	public QQUser getQqfriend() {
		return qqfriend;
	}
	public void setQqfriend(QQUser qqfriend) {
		this.qqfriend = qqfriend;
	}
}
