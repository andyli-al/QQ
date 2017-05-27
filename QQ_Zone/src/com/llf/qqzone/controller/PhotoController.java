package com.llf.qqzone.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Time;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.llf.qqzone.Entity.PageData;
import com.llf.qqzone.Entity.Photo;
import com.llf.qqzone.Entity.PhotoAlbum;
import com.llf.qqzone.dao.PhotoAlbumDao;
import com.llf.qqzone.dao.PhotoDao;
import com.llf.qqzone.util.ByteSwitchUtil;
import com.llf.qqzone.util.GetPageIndex;

@Controller
public class PhotoController {
	
	/**
	 * springMVC批量上传 http://530247683.iteye.com/blog/1027783
	 */
	
	@Autowired
	private PhotoDao photoDao;
	@Autowired
	private PhotoAlbumDao photoAlbumDao;
	
	//分页获取指定相册照片
	@RequestMapping("/getPhotoListByPage")
	public String getPhotoListByPage(@RequestParam("photoAlbumId")int photoAlbumId,@RequestParam("photoAlbumName")String photoAlbumName,@RequestParam("pageIndex")int pageIndex,Model model)
	{
		 int rowCount=photoDao.getRowcount(photoAlbumId);
		 int pageCount=(rowCount-1)/10+1;
		 PageData pd=GetPageIndex.getData(pageIndex, 10);
		 pd.setPhotoAlbumId(photoAlbumId);
		 List<Photo> result=photoDao.getPhotosByPage(pd);
		 
		 model.addAttribute("result", result);
	   	 model.addAttribute("pageIndex", pageIndex);
	   	 model.addAttribute("rowCount", rowCount);
	   	 model.addAttribute("pageCount", pageCount);
	   	 model.addAttribute("photoAlbumName", photoAlbumName);
	   	 model.addAttribute("photoAlbumId", photoAlbumId);
	   	 
		return "photoItems";
	}
	
	
	//批量上传照片
	@RequestMapping("/photoUpload")
	@Transactional
	public String photoUpload(MultipartHttpServletRequest request,@RequestParam("photoAlbumName")String photoAlbumName,Model model)
	{
		int photoAlbumId=Integer.parseInt(request.getParameter("photoAlbumId"));
		List<MultipartFile> file = request.getFiles("file");  
		Photo p=null;
		
		boolean temp=false;
		int index=0;
		for(int i=0;i<file.size();i++)
		{
			MultipartFile mf_temp=file.get(i);
			if(mf_temp.getOriginalFilename()!=null&&!mf_temp.getOriginalFilename().equals(""))
			{
				index=i;
				temp=true;
			}
		}
		
		if(temp==true)
		{
			//获得服务器下附件文件夹路径
			String path=request.getSession().getServletContext().getRealPath("/photos");
			 File f=new File(path);
			 if(!f.exists())
				 f.mkdir();
			 
			 for(MultipartFile mf:file)
			 {
				 if(mf.getOriginalFilename()!=null&&!mf.getOriginalFilename().equals(""))
				 {
				 try {
						FileOutputStream fo=new FileOutputStream(path+"/"+mf.getOriginalFilename());
						InputStream is=mf.getInputStream(); 
						int n=0;
						byte[] b=new byte[1024];
						while((n=is.read(b))!=-1)
						{
							fo.write(b);
						}
						fo.flush();
						is.close();
						fo.close();
						
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					//持久化
					p=new Photo();
					p.setPhotoAlbumId(photoAlbumId);
					p.setPhotoName(mf.getOriginalFilename());
					p.setSize(ByteSwitchUtil.getPrintSize(mf.getSize()));
					Calendar now=Calendar.getInstance();
					p.setUploadDate(new Time(now.getTimeInMillis()));
					
					photoDao.addPhoto(p);
				   
				 }
					
			 }
		}
		
		//更新相册封面
		PhotoAlbum pa=new PhotoAlbum();
		pa.setPhotoAlbumId(photoAlbumId);
		MultipartFile mf=file.get(index);
		pa.setPhotoAlbumImg(mf.getOriginalFilename());
		photoAlbumDao.updatePhotoAlbumImg(pa);
		
		
		//完成页面回发，跳转到第一页
		String res=getPhotoListByPage(photoAlbumId,photoAlbumName,1,model);
		return res;
	}
	
	//删除照片
	@RequestMapping("/deletePhoto")
	@Transactional
	public String deletePhoto(@RequestParam("photoId")int photoId,@RequestParam("photoName")String photoName,@RequestParam("photoAlbumId")int photoAlbumId,@RequestParam("photoAlbumName")String photoAlbumName,@RequestParam("pageIndex")int pageIndex,Model model,HttpServletRequest request)
	{
		System.out.println(photoId);
		System.out.println(photoName);
		System.out.println(photoAlbumId);
		System.out.println(photoAlbumName);
		System.out.println(pageIndex);
		
		photoDao.deletePhoto(photoId);
		//删除服务器下对应图片
		String path=request.getSession().getServletContext().getRealPath("/photos")+"/"+photoName;
	    File f=new File(path);
	    f.delete();
	    
	    //完成页面回发，跳转到当前页
	    String res=getPhotoListByPage(photoAlbumId,photoAlbumName,pageIndex,model);
		return res;
		
	}
	
	//根据photoId获取下一张图片(同一相册)
	@RequestMapping("/nextImg")
	public void nextImg(@RequestParam("photoId")int photoId,@RequestParam("photoAlbumId")int photoAlbumId,HttpServletResponse response) throws IOException
	{
		Photo p=new Photo();
		p.setPhotoId(photoId);
		p.setPhotoAlbumId(photoAlbumId);
		Photo p_res=photoDao.nextImg(p);
		
		response.setContentType("text/html;charset=utf-8"); 
		JSONObject obj=JSONObject.fromObject(p_res);
		response.getWriter().print(obj);
	}
	
	//根据photoId获取上一张图片(同一相册)
	@RequestMapping("/lastImg")
	public void lastImg(@RequestParam("photoId")int photoId,@RequestParam("photoAlbumId")int photoAlbumId,HttpServletResponse response) throws IOException
	{
		Photo p=new Photo();
		p.setPhotoId(photoId);
		p.setPhotoAlbumId(photoAlbumId);
		Photo p_res=photoDao.lastImg(p);
		
		response.setContentType("text/html;charset=utf-8"); 
		JSONObject obj=JSONObject.fromObject(p_res);
		response.getWriter().print(obj);
	}
	
	
}
