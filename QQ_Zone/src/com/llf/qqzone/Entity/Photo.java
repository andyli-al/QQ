package com.llf.qqzone.Entity;

import java.io.Serializable;
import java.util.Date;

public class Photo implements Serializable{
	
  private int photoId;
  private String photoName;
  private String size;
  private java.util.Date uploadDate;
  private int photoAlbumId;
public int getPhotoId() {
	return photoId;
}
public void setPhotoId(int photoId) {
	this.photoId = photoId;
}
public String getPhotoName() {
	return photoName;
}
public void setPhotoName(String photoName) {
	this.photoName = photoName;
}
public String getSize() {
	return size;
}
public void setSize(String size) {
	this.size = size;
}
public java.util.Date getUploadDate() {
	return uploadDate;
}
public void setUploadDate(java.util.Date uploadDate) {
	this.uploadDate = uploadDate;
}
public int getPhotoAlbumId() {
	return photoAlbumId;
}
public void setPhotoAlbumId(int photoAlbumId) {
	this.photoAlbumId = photoAlbumId;
}
public Photo() {
	super();
}
public Photo(int photoId, String photoName, String size, Date uploadDate,
		int photoAlbumId) {
	super();
	this.photoId = photoId;
	this.photoName = photoName;
	this.size = size;
	this.uploadDate = uploadDate;
	this.photoAlbumId = photoAlbumId;
}
  
  
}
