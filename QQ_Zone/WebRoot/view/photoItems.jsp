<%@ page language="java" import="java.util.*,com.llf.qqzone.Entity.*,java.text.*,com.llf.qqzone.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<<!DOCTYPE HTML>
<html lang="en-US">
  <head>
    <base href="<%=basePath%>">
  
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <title>${sessionScope.webname}的相册</title>
	
    <link rel="shortcut icon" href="style/images/favicon.png"/>
   <link rel="stylesheet" type="text/css" href="style.css" media="all" />
   <link rel="stylesheet" type="text/css" href="style/css/view.css" media="all" />
   <link rel="stylesheet" type="text/css" href="style/type/marketdeco.css" media="all" />
   <link rel="stylesheet" type="text/css" href="style/type/merriweather.css" media="all" />
   <link rel="stylesheet" type="text/css" href="style/css/queries.css" media="all" />

<script type="text/javascript" src="style/js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="style/js/ddsmoothmenu.js"></script>
<script type="text/javascript" src="style/js/html5.js"></script>
<script type="text/javascript" src="style/js/jquery.fitvids.js"></script>
<script type="text/javascript" src="style/js/selectnav.js"></script>
<script type="text/javascript" src="style/js/twitter.min.js"></script>

<script type="text/javascript">
 function photoShow(photoId,photoAlbumId,photoName)
 {
    $("#pid").val(photoId);
    $("#paid").val(photoAlbumId);
    $("#pname").val(photoName);
    $("#waitshowImg").attr("src","photos/"+photoName);
    $("#waitshowImg").css({"width":"60%","height":"60%"});
    $("#photo_show").show();
    $("#a_del").show();
 }
 
 function exit()
 {
    $("#photo_show").hide();
 }
 
 function nextImg()
 {
   $.ajax({
			url : "nextImg.do",
			type : "post",
			dataType : "json",
			data : {
				photoId : $("#pid").val(),
				photoAlbumId : $("#paid").val()
			},
			success : function(photo){
			    if(photo==null)
			    alert("没有了");
			    else
			    {
				$("#pid").val(photo.photoId);
				$("#waitshowImg").attr("src","photos/"+photo.photoName);
                $("#waitshowImg").css({"width":"60%","height":"60%"});
                $("#a_del").hide();
                }
			}
		});
 }
 
 function lastImg()
 {
     $.ajax({
			url : "lastImg.do",
			type : "post",
			dataType : "json",
			data : {
				photoId : $("#pid").val(),
				photoAlbumId : $("#paid").val()
			},
			success : function(photo){
			    if(photo==null)
			    alert("没有了");
			    else
			    {
				$("#pid").val(photo.photoId);
				$("#waitshowImg").attr("src","photos/"+photo.photoName);
                $("#waitshowImg").css({"width":"60%","height":"60%"});
                $("#a_del").hide();
                }
			}
		});
 }
 
 function show_upload()
 {
    $("#upload_box").show();
 }
 
 function giveup()
 {
    $("#upload_box").hide();
    return false;
 }
 
 function to_upload()
 {
    $("#form_upload").submit();
 }
 
 function deletePhoto(photoAlbumName,pageIndex)
 {
    if (confirm('确认删除该照片吗?')) {
		var photoId=$("#pid").val();
        var photoName=$("#pname").val();
        var photoAlbumId=$("#paid").val();
        $("#form_delete").attr("action", "deletePhoto.do?photoId="+photoId+"&photoName="+photoName+"&photoAlbumId="+photoAlbumId+"&photoAlbumName="+photoAlbumName+"&pageIndex="+pageIndex+"");
        $("#form_delete").submit();	
    }
 }
</script>
<style type="text/css">
.photosBox{position: relative;margin-top:20px;margin-bottom:30px;height:320px;border:1px solid #C1B9B9;padding-bottom:25px;padding-top:25px;}
.photosBox ul li{display: block;
	position:relative;
	width: 170px;
	height: 160px;
	background-color: rgba(255,255,255,.5);
	color: #999;
	font-size: 14px;
	margin-right: 0px;
	float: left;
	cursor: pointer;
	line-height: 20px;
	text-align: center;
	}
	
	.new_bt{width:100px;height:35px;background-color:#94DF5A;}
	#new_pa,#edit_pa{display:none;width:300px;height:100px;position:fixed;top:350px;left:550px;border:1px solid #D0D0D0;border-radius:5px;padding-top:10px;padding-left:10px;padding-bottom:10px;background-color:#D8D8D8;}
	#photo_show{display:none;position:absolute;top:270px;left:400px;width:auto;height:auto;max-width:800px;max-height:800px;border:1px solid #2C2C2C;background-color:#2C2C2C;}
	.bt_add{width:100px;height:35px;background-color:#94DF5A;}
	#upload_box{display:none;width:380px;height:300px;position:fixed;top:280px;left:520px;border:1px solid #D0D0D0;border-radius:5px;padding-top:20px;padding-left:20px;padding-bottom:20px;background-color:#D8D8D8;}
	#upload_box input{width:320px;height:35px;background-color:#F5DEDE}
</style>
</head>
 
<%
    List<Photo> ps=(List<Photo>)request.getAttribute("result");
    int rowCount=Integer.parseInt(request.getAttribute("rowCount").toString());
    int pageIndex=Integer.parseInt(request.getAttribute("pageIndex").toString());
    int pageCount=Integer.parseInt(request.getAttribute("pageCount").toString());
    String photoAlbumName=Tools.getNewString(request.getAttribute("photoAlbumName").toString());
    int photoAlbumId=Integer.parseInt(request.getAttribute("photoAlbumId").toString());
    int qqno=(Integer.parseInt(request.getSession().getAttribute("qqno").toString()));
    int qqno2=(Integer.parseInt(request.getSession().getAttribute("qqno2").toString()));
 %>
<body>
<div id="page" class="hfeed">
<div id="wrapper">
<header id="branding" role="banner">
  <h1 id="site-title"> 
  	${sessionScope.webname}的QQ空间
  </h1>
  <div class="social">
    <div class="widget_search">
      <form method="get" class="search-form">
         <input type="button" value="Search" class="search-submit-button" />
        <input type="text" value="Search" onfocus="this.value=''" onblur="this.value='Search'" name="s" class="search-text-box" />
      </form> 
      <a style="float:right;margin-right:8px;" href="logout.do">退出</a>
    </div>
  </div>
  <nav id="access" class="access" role="navigation">
        <div id="menu" class="menu">
        	<ul id="tiny">
				<li><a href="view/qqzone_main.jsp">主页</a></li>
				<li><a href="javascript:void(0)">日志</a></li>
				<li><a href="getAllTalks.do?QQ_No=${sessionScope.qqno}">说说</a></li>
				<li><a href="getPhotoAlbumList.do?QQ_No=${sessionScope.qqno}">相册</a></li>
				<li><a href="getMessageListByPage.do?QQ_No=${sessionScope.qqno}&pageIndex=1">留言板</a></li>
				<li><a href="to_personalMain.do?QQ_No=${sessionScope.qqno}">个人档</a></li>
			</ul>
		</div>
		<div class="triangle-l"></div>
		<div class="triangle-r"></div>
  </nav>
  <!-- #access --> 
</header>
<!-- #branding -->

<div id="main">

<div id="primary">
    <div id="content" role="main">
    <font style="font-size:18px;font-weight:bold;color:#AF6363;margin-right:10px;"><%=photoAlbumName %></font>
    <%
       if(qqno==qqno2)
       {
     %>
    <button class="bt_add" onclick="show_upload();">上传照片</button>
    <%
       }
     %>
     <div class="photosBox">
      <ul>
      <%
         for(int i=0;i<ps.size();i++)
         {
            Photo p=ps.get(i);
       %>
      <li><div style="border:1px solid #D8CBCB;width:160px;height:140px;overflow:hidden;"><a href="javascript:photoShow(<%=p.getPhotoId() %>,<%=p.getPhotoAlbumId() %>,'<%=p.getPhotoName() %>');"><img src="photos/<%=p.getPhotoName() %>" title="<%=p.getPhotoName() %>" /></a></div></li>
      <%
         }
       %>
      </ul>
      </div>
      
      <!-- 分页 -->
             共<%=rowCount %>条记录,共<%=pageCount %>页,当前第<%=pageIndex %>页
      <%
        if(pageIndex!=1)
        {
       %>
       <a href="getPhotoListByPage.do?photoAlbumId=<%=photoAlbumId %>&photoAlbumName=<%=photoAlbumName %>&pageIndex=<%=pageIndex-1 %>">上一页</a>
       <%
       }
       if(pageIndex!=pageCount)
       {
        %>
        <a href="getPhotoListByPage.do?photoAlbumId=<%=photoAlbumId %>&photoAlbumName=<%=photoAlbumName %>&pageIndex=<%=pageIndex+1 %>">下一页</a>
        <%
        }
        %>
   
       <div id="photo_show">
       <input type="hidden" id="pid"/>
       <input type="hidden" id="paid"/>
       <input type="hidden" id="pname"/>
       <a style="float:right;margin-top:3px;margin-right:5px;font-size:16px;" href="javascript:exit();">关闭</a><a id="a_del" style="float:right;margin-top:3px;margin-right:5px;font-size:16px;" href="javascript:deletePhoto('<%=photoAlbumName %>',<%=pageIndex %>);">删除</a>
       <a href="javascript:nextImg();">上一张</a>
       <img id="waitshowImg"/>
       <a href="javascript:lastImg();">下一张</a>
       </div>
       
       <form id="form_delete" action="" method="post">
       </form>
       
       <div id="upload_box">
       <span style="font-family:楷体;">温馨提示：一次最多只能上传<strong>5</strong>张图片喔!</span>
       <form id="form_upload" action="photoUpload.do?photoAlbumId=<%=photoAlbumId %>&photoAlbumName=<%=photoAlbumName %>" method="post" enctype="multipart/form-data">
       <input type="file" name="file" />  <br/> 
       <input type="file" name="file" />   <br/>
       <input type="file" name="file" />   <br/>
       <input type="file" name="file" />   <br/>
       <input type="file" name="file" />   <br/>
       <button style="margin-left:50px;margin-right:40px;margin-top:20px;" onclick="return to_upload();" class="bt_add">上传</button><button onclick="return giveup();" class="bt_add">放弃</button>
        </form>
       </div>
    </div>
  </div>
  </div>
  
		<div id="site-generator">
			Copyright 2017 - QQ Zone
		</div>
		
	</div><!-- #wrapper -->
</div><!-- #page -->

<script type="text/javascript" src="style/js/scripts.js"></script>
<div style="display:none"></div>
</body>
</html>