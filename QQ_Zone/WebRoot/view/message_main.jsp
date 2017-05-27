<%@ page language="java" import="java.util.*,com.llf.qqzone.Entity.*,java.text.*,com.llf.qqzone.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html lang="en-US">
  <head>
    <base href="<%=basePath%>">
  
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <title>${sessionScope.webname}的留言板</title>
	
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
function publish_message()
{
    if($("#messageContentdiv").text()=='')
    {
       $("#messageContentdiv").text("内容不能为空喔...")
    }else
    {
       $("#messageContent").val($("#messageContentdiv").text());
       $("#form_msg").submit();
    }
}
</script>

<style type="text/css">
    *{margin:0;padding:0;}
	body{font-size:12px;font-family:"微软雅黑";color:#666;}
	.show {width:940px;height:100px;border:2px solid #A1A1A1;font-size:16px;}
	.publish_bt{width:100px;height:35px;background-color:#94DF5A;float:right;margin-top:10px;color:#fff;font-size:14px;margin-right:20px;}
</style>
</head>

<%
    List<MessageInfo> mis=(List<MessageInfo>)request.getAttribute("result");
    int rowCount=Integer.parseInt(request.getAttribute("rowCount").toString());
    int pageIndex=Integer.parseInt(request.getAttribute("pageIndex").toString());
    int pageCount=Integer.parseInt(request.getAttribute("pageCount").toString());
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
   <font style="font-size:18px;color:#A85C5C;">${sessionScope.webname}的留言板</font><hr style="margin-bottom:20px;"/>
    <div id="messageContentdiv" class="show" contentEditable=true></div>
    <form id="form_msg" action="addMessage.do" method="post">
    <input type="hidden" id="messageContent" name="messageContent"/>
    <input type="hidden" id="QQ_No" value=${sessionScope.qqno} name="QQ_No" />
    <input type="hidden" id="QQ_friend" value=${sessionScope.qqno} name="QQ_friend" />
    </form>
    <button onclick="publish_message();" class="publish_bt">留言</button>
    <hr/>
    <table>
    <%
       for(int i=0;i<mis.size();i++)
       {
          MessageInfo mi=mis.get(i);
          String publishDate = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(mi.getPublishDate()); 
     %>
     <tr>
     <td>
     <table>
     <tr><td><font style="font-size:15px;"><%=publishDate %>&nbsp;&nbsp;<%=mi.getQquser().getQQ_webname() %>留言：</font></td></tr>
     <tr><td><font style="font-size:18px;"><%=mi.getMessageContent() %></font></td></tr>
     <tr><td><a style="float:left;" onclick="return confirm('确定要删除吗?')" href="deleteMessage.do?messageId=<%=mi.getMessageId() %>&QQ_No=${sessionScope.qqno}&pageIndex=<%=pageIndex %>">删除</a></td></tr>
     </table>
     </td>
     </tr> 
     <tr><td><hr/></td></tr>  
     <%
       }
      %>
    </table>
    
     <!-- 分页 -->
     <font style="font-size:14px;"> 共<%=rowCount %>条记录,共<%=pageCount %>页,当前第<%=pageIndex %>页</font>
      <%
        if(pageIndex!=1)
        {
       %>
       <a href="getMessageListByPage.do?QQ_No=${sessionScope.qqno}&pageIndex=<%=pageIndex-1 %>">上一页</a>
       <%
       }
       if(pageIndex!=pageCount)
       {
        %>
        <a href="getMessageListByPage.do?QQ_No=${sessionScope.qqno}&pageIndex=<%=pageIndex+1 %>">下一页</a>
        <%
        }
        %>
        
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