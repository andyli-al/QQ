package com.llf.qqzone.Entity;

import java.io.Serializable;
import java.util.Date;

public class Talk implements Serializable{

	private int talkId;
	private String talkcontent;
	private java.util.Date talkTime;
	private int QQ_No;
	public int getTalkId() {
		return talkId;
	}
	public void setTalkId(int talkId) {
		this.talkId = talkId;
	}
	public String getTalkcontent() {
		return talkcontent;
	}
	public void setTalkcontent(String talkcontent) {
		this.talkcontent = talkcontent;
	}
	public java.util.Date getTalkTime() {
		return talkTime;
	}
	public void setTalkTime(java.util.Date talkTime) {
		this.talkTime = talkTime;
	}
	public int getQQ_No() {
		return QQ_No;
	}
	public void setQQ_No(int qQNo) {
		QQ_No = qQNo;
	}
	public Talk() {
		super();
	}
	public Talk(int talkId, String talkcontent, Date talkTime, int qQNo) {
		super();
		this.talkId = talkId;
		this.talkcontent = talkcontent;
		this.talkTime = talkTime;
		QQ_No = qQNo;
	}
}
