package com.llf.qqzone.Entity;

import java.io.Serializable;
import java.util.Date;

public class Daily implements Serializable{
	
	private int dailyId;
	private String dailyTitle;
	private String dailyContentFile;
	private java.util.Date publishDate;
	private int QQ_No;
	public int getDailyId() {
		return dailyId;
	}
	public void setDailyId(int dailyId) {
		this.dailyId = dailyId;
	}
	public String getDailyTitle() {
		return dailyTitle;
	}
	public void setDailyTitle(String dailyTitle) {
		this.dailyTitle = dailyTitle;
	}
	public String getDailyContentFile() {
		return dailyContentFile;
	}
	public void setDailyContentFile(String dailyContentFile) {
		this.dailyContentFile = dailyContentFile;
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
	public Daily() {
		super();
	}
	public Daily(int dailyId, String dailyTitle, String dailyContentFile,
			Date publishDate, int qQNo) {
		super();
		this.dailyId = dailyId;
		this.dailyTitle = dailyTitle;
		this.dailyContentFile = dailyContentFile;
		this.publishDate = publishDate;
		QQ_No = qQNo;
	}

}
