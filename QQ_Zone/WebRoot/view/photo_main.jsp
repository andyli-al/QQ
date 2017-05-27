<%@ page language="java" import="java.util.*,com.llf.qqzone.Entity.*,java.text.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
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
function showNew()
{
    $("#new_pa").show();
}
function giveup()
{
    $("#new_pa").hide();
}
function tonew()
{
   if($("#photoAlbumName").val()=='')
   {
      $("#photoAlbumName").val("相册名称不能为空喔...");
      return false;
   }else
   {
       $("#form_new").submit();
   }
}

function showEdit(photoAlbumId,photoAlbumName)
{
   $("#photoAlbumId").val(photoAlbumId);
   $("#photoAlbumName2").val(photoAlbumName);
   $("#edit_pa").show();
}

function giveup_edit()
{
    $("#edit_pa").hide();
}

function toedit()
{
   if($("#photoAlbumName2").val()=='')
   {
      $("#photoAlbumName2").val("相册名称不能为空喔...");
      return false;
   }else
   {
       $("#form_edit").submit();
   }
}
</script>
<style type="text/css">
.photoAlbumBox{position: relative;margin-top:20px;margin-bottom:30px;height:auto;min-height:355px;border:1px solid #C1B9B9;padding-bottom:25px;}
.photoAlbumBox ul li{display: block;
	position:relative;
	width: 150px;
	height: 180px;
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
</style>
</head>
 
<%
   List<PhotoAlbum> pas=(List<PhotoAlbum>)request.getAttribute("result");
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
    <font style="font-size:18px;color:#A85C5C;">${sessionScope.webname}的相册</font><hr style="margin-bottom:20px;"/>
    <%
      if(qqno==qqno2)
      {
     %>
    <button class="new_bt" onclick="showNew();">新建相册</button>
    <%
     }
     %>
     <div class="photoAlbumBox">
      <ul>
      <%
         for(int i=0;i<pas.size();i++)
         {
            PhotoAlbum pa=pas.get(i);
       %>
      <li><table><tr><td><a href="getPhotoListByPage.do?photoAlbumId=<%=pa.getPhotoAlbumId() %>&photoAlbumName=<%=pa.getPhotoAlbumName() %>&pageIndex=1">
      <%
          if(pa.getPhotoAlbumImg()==null||pa.getPhotoAlbumImg().equals(""))
          {
       %>
      <img src="img/default_photoAlbum.png" style="width:135px;height:140px;"/>
       <%
          }else
          {
        %>
      <img src="photos/<%=pa.getPhotoAlbumImg() %>" style="width:135px;height:140px;"/>
       <%
         }
       %>
      </a></td></tr><tr><td><%=pa.getPhotoAlbumName() %>__<a href="javascript:showEdit(<%=pa.getPhotoAlbumId() %>,'<%=pa.getPhotoAlbumName() %>');">编辑</a>__<a href="deletePhotoAlbum.do?photoAlbumId=<%=pa.getPhotoAlbumId() %>&QQ_No=${sessionScope.qqno}" onclick="return confirm('确定要删除吗?')">删除</a></td></tr></table></li>
      <%
        }
       %>
      </ul>
      </div>
    </div>
  </div>
  </div>
  
  <div id="new_pa">
  <form id="form_new" action="addPhotoAlbum.do?QQ_No=${sessionScope.qqno}" method="post">
  <table>
  <tr style="height:50px;"><td>相册名称:<input type="text" style="width:200px;" id="photoAlbumName" name="photoAlbumName"/></td></tr>
  </table>
  </form>
  <table>
   <tr><td><button style="width:60px;margin-right:20px;margin-left:70px;" class="new_bt" onclick="return tonew();">创建</button><button style="width:60px;" class="new_bt" onclick="giveup();">放弃</button></td></tr>
  </table>
  </div>
  
  <div id="edit_pa">
  <form id="form_edit" action="updatePhotoAlbum.do?QQ_No=${sessionScope.qqno}" method="post">
  <input type="hidden" name="photoAlbumId" id="photoAlbumId"/>
  <table>
  <tr style="height:50px;"><td>相册名称:<input type="text" style="width:200px;" id="photoAlbumName2" name="photoAlbumName"/></td></tr>
  </table>
  </form>
  <table>
   <tr><td><button style="width:60px;margin-right:20px;margin-left:70px;" class="new_bt" onclick="return toedit();">更改</button><button style="width:60px;" class="new_bt" onclick="giveup_edit();">放弃</button></td></tr>
  </table>
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