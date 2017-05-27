package com.llf.qqzone.dao;

import java.util.List;

import com.llf.qqzone.Entity.PageData;
import com.llf.qqzone.Entity.Photo;

public interface PhotoDao {
	
	/**
	 * 上传照片
	 * @param p
	 */
	public void addPhoto(Photo p);
	/**
	 * 删除照片
	 * @param photoId
	 */
	public void deletePhoto(int photoId);
	
	  /**
     * 获取指定相册的总照片数
     * @param photoAlbumId
     * @return int 
     */
	public int getRowcount(int photoAlbumId); 
	/**
	 * 分页获取指定相册的照片列表
	 * @param pd
	 * @return List<Photo>
	 */
	public List<Photo> getPhotosByPage(PageData pd);
	/**
	 * 根据当前photo获取下一张photo(同一相册)
	 * @param p
	 * @return
	 */
	public Photo nextImg(Photo p);
    /**
     * 根据当前photo获取上一张photo(同一相册)
     * @param p
     * @return
     */
	public Photo lastImg(Photo p);
	

	

}
