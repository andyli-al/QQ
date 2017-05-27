<%@ page language="java" import="java.util.*,java.text.*,com.llf.qqzone.Entity.*,com.llf.qqzone.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html lang="en-US">
  <head>
    <base href="<%=basePath%>">
  
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <title>${sessionScope.webname}的个人档</title>
	
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
<script type="text/javascript" src="js/provinceCity.js"></script> 

<script type="text/javascript">
function show_edit()
{
    $("#personal_msg").hide();
    $("#edit_personnal_msg").show();
}

function edit_personal_msg()
{
   $("#form_edit").submit();
}
</script>

<style type="text/css">
.personal_bt{width:100px;height:35px;background-color:#94DF5A;}
#personal_msg{position: relative;margin-top:20px;margin-bottom:30px;height:auto;min-height:355px;border:1px solid #C1B9B9;padding-bottom:25px;}
#personal_msg table{margin-left:12px;margin-top:15px;}
#edit_personnal_msg,#permission_set{display:none;position: relative;margin-top:20px;margin-bottom:30px;height:auto;min-height:355px;border:1px solid #C1B9B9;padding-bottom:25px;}
#edit_personnal_msg table{margin-left:12px;margin-top:15px;}
#edit_personnal_msg table tr{height:40px;}
</style>
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
   <font style="font-size:18px;color:#A85C5C;">个人档(${sessionScope.webname})</font><hr style="margin-bottom:15px;"/>
   <button style="margin-right:20px;" class="personal_bt" onclick="show_edit();">编辑资料</button><button class="personal_bt">权限设置</button>
  
  <!-- 个人资料 -->
  <div id="personal_msg">
  <h4><font style="margin-left:5px;font-size:18px;">基本资料</font></h4>
  <hr style="margin-bottom:10px;"/>
  <table>
   <tr>
   <td><strong>QQ号码：</strong></td>
   <td>${sessionScope.qquser.QQ_No }</td>
   </tr>
  <tr>
   <td><strong>昵称：</strong></td>
   <td>${sessionScope.qquser.QQ_webname }</td>
  </tr>
   <tr>
   <td><strong>个性签名：</strong></td>
   <td>${sessionScope.qquser.QQ_sign }</td>
  </tr>
   <tr>
   <td><strong>性别：</strong></td>
   <td>${sessionScope.qquser.u_sex }</td>
  </tr>
   <tr>
   <td><strong>年龄：</strong></td>
   <td>${sessionScope.qquser.u_age }</td>
  </tr>
  <tr>
   <td><strong>生日：</strong></td>
   <%
   QQUser qu=(QQUser)request.getSession().getAttribute("qquser");
   String s_birthday=new SimpleDateFormat("yyyy-MM-dd").format(qu.getU_birthday()); 
   String[] temp=s_birthday.split("-");
   String s_contellation=ConstellationUtil.getConstellation(ConstellationUtil.getConstellationByDate(temp[1],temp[2]));
    %>
   <td><%=s_birthday %></td>
  </tr>
  <tr>
  <td><strong>星座：</strong></td>
  <td><%=s_contellation %></td>
  </tr>
   <tr>
   <td><strong>故乡：</strong></td>
   <td>${sessionScope.qquser.u_hometown }</td>
  </tr>
    <tr>
   <td><strong>所在地：</strong></td>
   <td>${sessionScope.qquser.u_staycity }</td>
  </tr>
    <tr>
   <td><strong>学历：</strong></td>
   <td>${sessionScope.qquser.u_education }</td>
  </tr>
    <tr>
   <td><strong>职业：</strong></td>
   <td>${sessionScope.qquser.u_profession }</td>
  </tr>
  </table>
  </div>
  
  <div id="edit_personnal_msg">
  <h4><font style="margin-left:5px;font-size:18px;">编辑资料</font></h4>
  <hr style="margin-bottom:10px;"/>
  <form id="form_edit" action="editPersonnalMsg.do" method="post">
  <input type="hidden" value=${sessionScope.qqno} name="QQ_No" />
  <table>
  <tr>
   <td><strong>昵称：</strong></td>
   <td><input type="text" value=${sessionScope.qquser.QQ_webname } name="QQ_webname"/></td>
  </tr>
   <tr>
   <td><strong>个性签名：</strong></td>
   <td><textarea name="QQ_sign">${sessionScope.qquser.QQ_sign}</textarea>
   </td>
  </tr>
   <tr>
   <td><strong>性别：</strong></td>
   <td><input type="checkbox" checked="checked" name="u_sex" value="男"/>男<input type="checkbox" name="u_sex" value="女"/>女</td>
  </tr>
   <tr>
   <td><strong>生日：</strong></td>
   <td><select>
                             <option>生日</option>
					         </select>
					         <select name="birth_year">
					         <%
					            for(int i=2017;i>=1900;i--)
					            {
					          %>
					         <option value=<%=i %>><%=i %></option>
					         <%
					            }
					          %>
					         </select>
					         <select name="birth_month">
					         <%
					            for(int j=1;j<=12;j++)
					            {
					          %>
					         <option value=<%=j %>><%=j %>月</option>
					         <%
					            }
					          %>
					         </select>
					         <select name="birth_date">
					         <%
					            for(int k=1;k<=31;k++)
					            {
					          %>
					         <option value=<%=k %>><%=k %>日</option>
					         <%
					            }
					          %>
					         </select></td>
  </tr>
  <tr>
  <td><strong>故乡</strong></td>
  <td>
  <select>
                             <option>故乡</option>
					         </select>
							<select id="hometown_county" name="hometown_county">
					         <option value="中国">中国</option>
					         </select>
					         <select id="hometown_province" name="hometown_province" onchange="change_province2();">
					         <option value="北京">北京</option>
					         <option value="上海">上海</option>
					         <option value="天津">天津</option>
					         <option value="重庆">重庆</option>
					         <option value="江苏">江苏</option>
					         <option value="浙江">浙江</option>
					         <option value="广东">广东</option>
					         <option value="福建">福建</option>
					         <option value="山东">山东</option>
					         <option value="辽宁">辽宁</option>
					         <option value="内蒙古">内蒙古</option>
					         </select>
					         <select id="hometown_city" name="hometown_city">
					         <option value="东城">东城</option>
					         <option value="西城">西城</option>
					         <option value="朝阳">朝阳</option>
					         <option value="海淀">海淀</option>
					         <option value="昌平">昌平</option>
					         </select>
  </td>
  </tr>
  <tr>
  <td><strong>现居地</strong></td>
  <td>
  <select>
                             <option>现居地</option>
					         </select>
							<select id="stayCity_county" name="stayCity_county">
					         <option value="中国">中国</option>
					         </select>
					         <select id="stayCity_province" name="stayCity_province" onchange="change_province();">
					         <option value="北京">北京</option>
					         <option value="上海">上海</option>
					         <option value="天津">天津</option>
					         <option value="重庆">重庆</option>
					         <option value="江苏">江苏</option>
					         <option value="浙江">浙江</option>
					         <option value="广东">广东</option>
					         <option value="福建">福建</option>
					         <option value="山东">山东</option>
					         <option value="辽宁">辽宁</option>
					         <option value="内蒙古">内蒙古</option>
					         </select>
					         <select id="stayCity_city" name="stayCity_city">
					         <option value="东城">东城</option>
					         <option value="西城">西城</option>
					         <option value="朝阳">朝阳</option>
					         <option value="海淀">海淀</option>
					         <option value="昌平">昌平</option>
					         </select>
  </td>
  </tr>
  <tr>
  <td><strong>学历</strong></td>
  <td>
  <select name="u_education">
  <option>小学</option>
  <option>初中</option>
  <option>高中</option>
  <option>专科</option>
  <option>本科</option>
  <option>硕士</option>
  <option>博士</option>
  </select>
  </td>
  </tr>
  <tr>
  <td><strong>职业</strong></td>
  <td>
  <select name="u_profession">
  <option>计算机/互联网/通信</option>
  <option>生产/工艺/制造</option>
  <option>医疗/护理/制药</option>
  <option>金融/银行/投资/保险</option>
  <option>商业/服务业/个体经营</option>
  <option>文化/广播/传媒</option>
  <option>娱乐/艺术/表演</option>
  <option>律师/法务</option>
  <option>教育/培训</option>
  <option>公务员/行政/事业单位</option>
  <option>模特/空姐</option>
  <option>学生</option>
  <option>其他</option>
  </select>
  </td>
  </tr>
  </table>
  </form>
  <table>
  <tr>
  <td colspan=2><button onclick="edit_personal_msg();" class="personal_bt">修改</button></td>
  </tr>
  </table>
  </div>
 
  <div id="permission_set">
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