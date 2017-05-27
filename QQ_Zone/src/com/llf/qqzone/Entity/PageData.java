package com.llf.qqzone.Entity;

public class PageData {
	
	private int start_index;
	private int end_index;
	private int QQ_No;
	private int photoAlbumId;
	public int getStart_index() {
		return start_index;
	}
	public void setStart_index(int startIndex) {
		start_index = startIndex;
	}
	public int getEnd_index() {
		return end_index;
	}
	public void setEnd_index(int endIndex) {
		end_index = endIndex;
	}
	public int getQQ_No() {
		return QQ_No;
	}
	public void setQQ_No(int qQNo) {
		QQ_No = qQNo;
	}
	public int getPhotoAlbumId() {
		return photoAlbumId;
	}
	public void setPhotoAlbumId(int photoAlbumId) {
		this.photoAlbumId = photoAlbumId;
	}
	public PageData() {
		super();
	}
	public PageData(int startIndex, int endIndex, int qQNo, int photoAlbumId) {
		super();
		start_index = startIndex;
		end_index = endIndex;
		QQ_No = qQNo;
		this.photoAlbumId = photoAlbumId;
	}
	
}
