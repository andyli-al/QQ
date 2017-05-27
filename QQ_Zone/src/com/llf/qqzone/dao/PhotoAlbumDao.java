package com.llf.qqzone.dao;

import java.util.List;

import com.llf.qqzone.Entity.PhotoAlbum;

public interface PhotoAlbumDao {
	
	/**
	 * ������
	 * @param pa
	 */
	public void addPhotoAlbum(PhotoAlbum pa);
	/**
	 * ���������Ϣ(�����)
	 * @param pa
	 */
	public void updatePhotoAlbum(PhotoAlbum pa);
	/**
	 * ɾ�����(������Ƭ�ᱻһ��ɾ��)
	 * @param photoAlbumId
	 */
	public void deletePhotoAlbum(int photoAlbumId);
	/**
	 * ��ȡָ��QQ���������
	 * @param QQ_No
	 * @return
	 */
	public List<PhotoAlbum> getPhotoAlbumList(int QQ_No);
	/**
	 * ����������
	 * @param photoAlbumImg
	 */
	public void updatePhotoAlbumImg(PhotoAlbum pa);
}
