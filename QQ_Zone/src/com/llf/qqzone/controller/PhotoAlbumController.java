package com.llf.qqzone.controller;

import java.sql.Time;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.llf.qqzone.Entity.PhotoAlbum;
import com.llf.qqzone.dao.PhotoAlbumDao;

@Controller
public class PhotoAlbumController {
	
	@Autowired
	private PhotoAlbumDao photoAlbumDao;
	
	//获取指定QQ的所有相册
	@RequestMapping("/getPhotoAlbumList")
	public String getPhotoAlumList(@RequestParam("QQ_No")int QQ_No,Model model)
	{
		List<PhotoAlbum> result=photoAlbumDao.getPhotoAlbumList(QQ_No);
		model.addAttribute("result", result);
		return "photo_main";
	}
	
	//添加相册
	@RequestMapping("/addPhotoAlbum")
	@Transactional
	public String addPhotoAlbum(@RequestParam("photoAlbumName")String photoAlbumName,@RequestParam("QQ_No")int QQ_No,Model model)
	{
		PhotoAlbum pa=new PhotoAlbum();
		pa.setPhotoAlbumName(photoAlbumName);
		pa.setQQ_No(QQ_No);
		Calendar now=Calendar.getInstance();
		pa.setEditDate(new Time(now.getTimeInMillis()));
		
		photoAlbumDao.addPhotoAlbum(pa);
		
		//完成页面回发
		String res=getPhotoAlumList(QQ_No,model);
		
		return res;
		
	}
	
	//更改相册信息
	@RequestMapping("/updatePhotoAlbum")
	@Transactional
	public String updatePhotoAlbum(@RequestParam("photoAlbumId")int photoAlbumId,@RequestParam("photoAlbumName")String photoAlbumName,@RequestParam("QQ_No")int QQ_No,Model model)
	{
		PhotoAlbum pa=new PhotoAlbum();
		pa.setPhotoAlbumId(photoAlbumId);
		pa.setPhotoAlbumName(photoAlbumName);
		Calendar now=Calendar.getInstance();
		pa.setEditDate(new Time(now.getTimeInMillis()));
		
		photoAlbumDao.updatePhotoAlbum(pa);
		
		//完成页面回发
		String res=getPhotoAlumList(QQ_No,model);
		
		return res;
		
	}
	
	//删除相册(其下照片会被一并删除)
	@RequestMapping("/deletePhotoAlbum")
	@Transactional
	public String deletePhotoAlbum(@RequestParam("photoAlbumId")int photoAlbumId,@RequestParam("QQ_No")int QQ_No,Model model)
	{
		photoAlbumDao.deletePhotoAlbum(photoAlbumId);
		//完成页面回发
		String res=getPhotoAlumList(QQ_No,model);
		
		return res;
	}

}
