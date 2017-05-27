package com.llf.qqzone.dao;

import java.util.List;

import com.llf.qqzone.Entity.PhotoAlbum;

public interface PhotoAlbumDao {
	
	/**
	 * 添加相册
	 * @param pa
	 */
	public void addPhotoAlbum(PhotoAlbum pa);
	/**
	 * 更改相册信息(相册名)
	 * @param pa
	 */
	public void updatePhotoAlbum(PhotoAlbum pa);
	/**
	 * 删除相册(其下照片会被一并删除)
	 * @param photoAlbumId
	 */
	public void deletePhotoAlbum(int photoAlbumId);
	/**
	 * 获取指定QQ的所有相册
	 * @param QQ_No
	 * @return
	 */
	public List<PhotoAlbum> getPhotoAlbumList(int QQ_No);
	/**
	 * 更新相册封面
	 * @param photoAlbumImg
	 */
	public void updatePhotoAlbumImg(PhotoAlbum pa);
}
