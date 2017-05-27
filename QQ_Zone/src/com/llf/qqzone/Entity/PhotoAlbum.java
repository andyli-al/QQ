package com.llf.qqzone.Entity;

import java.io.Serializable;
import java.util.Date;

public class PhotoAlbum implements Serializable{
	
	private int photoAlbumId;
	private String photoAlbumName;
	private java.util.Date EditDate;
	private String photoAlbumImg;
	private int QQ_No;
	public int getPhotoAlbumId() {
		return photoAlbumId;
	}
	public void setPhotoAlbumId(int photoAlbumId) {
		this.photoAlbumId = photoAlbumId;
	}
	public String getPhotoAlbumName() {
		return photoAlbumName;
	}
	public void setPhotoAlbumName(String photoAlbumName) {
		this.photoAlbumName = photoAlbumName;
	}
	public java.util.Date getEditDate() {
		return EditDate;
	}
	public void setEditDate(java.util.Date editDate) {
		EditDate = editDate;
	}
	public String getPhotoAlbumImg() {
		return photoAlbumImg;
	}
	public void setPhotoAlbumImg(String photoAlbumImg) {
		this.photoAlbumImg = photoAlbumImg;
	}
	public int getQQ_No() {
		return QQ_No;
	}
	public void setQQ_No(int qQNo) {
		QQ_No = qQNo;
	}
	public PhotoAlbum() {
		super();
	}
	public PhotoAlbum(int photoAlbumId, String photoAlbumName, Date editDate,
			String photoAlbumImg, int qQNo) {
		super();
		this.photoAlbumId = photoAlbumId;
		this.photoAlbumName = photoAlbumName;
		EditDate = editDate;
		this.photoAlbumImg = photoAlbumImg;
		QQ_No = qQNo;
	}
	

}
