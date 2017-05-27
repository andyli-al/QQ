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
    <title>${sessionScope.webname}的说说</title>
	
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
function publish_talk()
{
    if($("#talkcontentdiv").text()=="")
    {
       $("#talkcontentdiv").text("内容不能为空喔....");
    }else
    {
       $("#talkcontent").val($("#talkcontentdiv").text());
       $("#form_talk").submit();
    }
}

function showComment(talkId,QQ_commentNo)
{
   $("#talkCommentContent").val("");
   $("#talkId").val(talkId);
   $("#QQ_commentNo").val(QQ_commentNo);
   $("#talkcomment_div").show();
}

function giveup()
{
   $("#talkcomment_div").hide();
}

function publishComment()
{
 if($("#talkCommentContent").val()!='')
  {
  $("#talkcomment_div").hide();
  $("#formComment").submit();
  }else
  {
    $("#talkcommentContent").val("内容不能为空喔...");
    return false;
  }
  
}
</script>

<style type="text/css">
	*{margin:0;padding:0;}
	body{font-size:12px;font-family:"微软雅黑";color:#666;}
	.qq{width:940px;height:100px;border:1px solid #D0D0D0;border-radius:5px;
	box-shadow: 0 0 2px rgba(0,0,0.2);
	}
	.qq .list_bq{width:120px;height:100px;background:#f8f8f8;border-right:1px solid #ccc;
	   float:left;}
	.qq .list_bq li{list-style:none;background:#fff;line-height:28px}
	.qq .qq_bq{width:820px;height:100px;}
	.qq .qq_bq ul li{float:left;padding:5px;list-style:none;}
	.show {width:940px;height:100px;border:2px solid #A1A1A1;font-size:16px;}
	.show img{padding:4px;}
	.tb1{font-size:19px;margin-top:10px;margin-bottom:30px;border:}
	.publish_bt{width:100px;height:35px;background-color:#94DF5A;float:right;margin-top:10px;color:#fff;font-size:14px;margin-right:20px;}
	#talkcomment_div{display:none;width:300px;height:150px;position:fixed;top:300px;left:500px;border:1px solid #D0D0D0;border-radius:5px;padding-top:10px;padding-left:10px;padding-bottom:10px;background-color:#D8D8D8;}
</style>
</head>

<%
    List<Talk> talks=(List<Talk>)request.getAttribute("result");
    List<List<TalkCommentInfo>> resultComments=(List<List<TalkCommentInfo>>)request.getAttribute("resultComments");
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
   <font style="font-size:18px;color:#A85C5C;">${sessionScope.webname}的说说</font><hr style="margin-bottom:20px;"/>
    <%
      if(qqno==qqno2)
      {
    %>
   <a href="javascript:change();">打开表情</a>
  <div id="talkcontentdiv" class="show" contentEditable=true></div>
  <form id="form_talk" action="addTalk.do" method="post">
  <input type="hidden" id="talkcontent" name="talkcontent"/>
  <input type="hidden" id="QQ_No" value=${sessionScope.qqno2 } name="QQ_No"/>
  </form>
    <div class="qq" id="myQQ">
    <ul class="list_bq">
    <li>QQ-空间表情</li>
    </ul>
    <div class="qq_bq">
    <ul>
     <li><img src="images/1.gif" width="40px" height="60px" title="太可爱"/></li>
    <li><img src="images/2.gif" width="40px" height="60px" title="偷笑"/></li>
     <li><img src="images/3.gif" width="40px" height="60px" title="激动"/></li>
     <li><img src="images/4.gif" width="40px" height="60px" title="感动"/></li>
     <li><img src="images/5.gif" width="40px" height="60px" title="吃货"/></li>
     <li><img src="images/6.gif" width="40px" height="60px" title="恭喜"/></li>
     <li><img src="images/7.gif" width="40px" height="60px" title="无语"/></li>
     <li><img src="images/8.gif" width="40px" height="60px" title="惊慌"/></li>
     <li><img src="images/9.gif" width="40px" height="60px" title="鄙视"/></li>
     <li><img src="images/10.gif" width="40px" height="60px" title="羞愧"/></li>
     <li><img src="images/11.gif" width="40px" height="60px" title="奸笑"/></li>
     <li><img src="images/12.gif" width="40px" height="60px" title="得意"/></li>
     <li><img src="images/13.gif" width="40px" height="60px" title="伤心"/></li>   
    </ul>
    </div>
    </div>
    <button onclick="publish_talk();" class="publish_bt">发表说说</button>
    <%
    }
     %>
   
    <script type="text/javascript">
      
      function change()
      {
        $("#myQQ").toggle("solw");
      }
     $(function()
	 {
	    $(".qq_bq").find("li").click(function(){
          var img=$(this).find("img").clone();
			 $(".show").append(img);
		});
	 });
     
    </script>
   
   <hr/>
  <table class="tb1">
   <%
      for(int i=0;i<talks.size();i++)
      {
        Talk t=talks.get(i);
        String talkTime = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(t.getTalkTime()); 
   %> 
     <tr>
    <td>
    <font style="font-family:楷体;font-size:15px;"><%=talkTime %></font>&nbsp;&nbsp;<%=t.getTalkcontent() %>&nbsp;&nbsp;<a href="javascript:showComment(<%=t.getTalkId() %>,${sessionScope.qqno});"><font style="font-family:楷体;">评论</font></a>&nbsp;&nbsp;<a href="deleteTalk.do?talkId=<%=t.getTalkId() %>&QQ_No=${sessionScope.qqno}" onclick="return confirm('确定要删除吗?')"><font style="font-family:楷体;">删除</font></a>
    <%
        for(int j=0;j<resultComments.size();j++)
        {
           List<TalkCommentInfo> temp=resultComments.get(j);
           if(temp.size()>0)
           {
           if(temp.get(0).getTalkId()==t.getTalkId())
           {
        
     %>
         <table style="font-size: 16px;">
         <%
            for(TalkCommentInfo ti:temp)
            {
              String publishDate = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(ti.getPublishDate()); 
          %>
         <tr>
         <td><font style="font-family:楷体;font-size:15px;color:#AB5F5F;"><%=publishDate %></font>&nbsp;&nbsp;<%=ti.getQquser().getQQ_webname() %>评论：<%=ti.getTalkCommentContent() %>&nbsp;&nbsp;<a href="deleteTalkComment.do?talkCommentId=<%=ti.getTalkCommentId() %>&QQ_No=${sessionScope.qqno}" onclick="return confirm('确定要删除吗?')">删除</a></td>
         </tr>
           <%
            }
            %>
         </table>
     <%
           }
           }
        }
      %>
    </td>
     </tr> 
     <tr>
     <td><hr/></td>
     </tr>
    <%
      }
    %>
  </table>
  </div>
  </div>
  </div>
  
  <div id="talkcomment_div">
  <form id="formComment" action="addTalkomment.do" method="post">
  <input type="hidden" id="talkId" name="talkId"/>
  <input type="hidden" id="QQ_commentNo" name="QQ_commentNo"/>
  <input type="hidden" value=${sessionScope.qqno2 } name="QQ_No"/>
  <table>
  <tr>
  <td><textarea id="talkCommentContent" name="talkCommentContent" placeholder="内容不能为空喔..." style="width:280px;height:100px;"></textarea></td>
  </tr>
  </table>
  </form>
  <table>
   <tr>
  <td align="right"><button onclick="giveup();" class="publish_bt">放弃</button ><button onclick="return publishComment();" class="publish_bt">评论</button></td>
  </tr>
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