<%@ page language="java" import="java.util.*,com.llf.qqzone.Entity.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html lang="en-US">
  <head>
    <base href="<%=basePath%>">
  
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <title>${sessionScope.webname}的QQ空间主页</title>
	
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
</head>

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
  
  <div class="intro">欢迎来到${sessionScope.webname}的QQ空间，请开始你的空间之旅吧!</div>
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