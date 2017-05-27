<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Test</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	

  </head>
  
  <body>
     <a href="addPermission.do?QQ_No=10000&QQ_friend=10004">添加访问权限</a>
     <a href="addTalk.do?talkcontent=go go go&QQ_No=10000">发表说说</a>
     <a href="getAllTalks.do?QQ_No=10000">获取所有的说说</a>
     <a href="deleteTalk.do?talkId=1&QQ_No=10000">删除说说</a>
     <a href="addTalkomment.do?talkCommentContent=wo ai ni&talkId=2&QQ_commentNo=10002&QQ_No=10000">添加说说评论</a>
     <a href="deleteTalkComment.do?talkCommentId=3&QQ_No=10000">删除说说评论</a>
     <a href="addMessage.do?messageContent=liuyan la&QQ_No=10000&QQ_friend=10004">添加留言</a>
     <a href="deleteMessage.do?messageId=1">删除留言</a>
     <a href="getMessageListByPage.do?QQ_No=10000&pageIndex=1">分页查询留言</a>
     <a href="addPhotoAlbum.do?photoAlbumName=family&QQ_No=10000">添加相册</a>
     <a href="updatePhotoAlbum.do?photoAlbumId=1&photoAlbumName=family222">更改相册信息</a>
     <a href="deletePhotoAlbum.do?photoAlbumId=1">删除相册</a>
     <a href="getPhotoAlbumList.do?QQ_No=10000">获取所有的相册</a>
     
     
  </body>
</html>
