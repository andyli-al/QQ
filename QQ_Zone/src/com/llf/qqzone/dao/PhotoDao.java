package com.llf.qqzone.dao;

import java.util.List;

import com.llf.qqzone.Entity.PageData;
import com.llf.qqzone.Entity.Photo;

public interface PhotoDao {
	
	/**
	 * �ϴ���Ƭ
	 * @param p
	 */
	public void addPhoto(Photo p);
	/**
	 * ɾ����Ƭ
	 * @param photoId
	 */
	public void deletePhoto(int photoId);
	
	  /**
     * ��ȡָ����������Ƭ��
     * @param photoAlbumId
     * @return int 
     */
	public int getRowcount(int photoAlbumId); 
	/**
	 * ��ҳ��ȡָ��������Ƭ�б�
	 * @param pd
	 * @return List<Photo>
	 */
	public List<Photo> getPhotosByPage(PageData pd);
	/**
	 * ���ݵ�ǰphoto��ȡ��һ��photo(ͬһ���)
	 * @param p
	 * @return
	 */
	public Photo nextImg(Photo p);
    /**
     * ���ݵ�ǰphoto��ȡ��һ��photo(ͬһ���)
     * @param p
     * @return
     */
	public Photo lastImg(Photo p);
	

	

}
