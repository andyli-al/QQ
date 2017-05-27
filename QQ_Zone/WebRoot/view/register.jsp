<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
     
    <title>QQ账号注册</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	    <link rel="stylesheet" href="css/reset.css" />
		<link rel="stylesheet" href="css/common.css" />
	
        <link rel="stylesheet" href="layui/css/layui.css" media="all" />
        <script type="text/javascript" src="layui/layui.js"></script>
        <script type="text/javascript" src="layui/lay/dest/layui.all.js"></script>
  	  
		<script type="text/javascript">
		function check()
		{
		  if($("#QQ_webname").val()==''||$("#QQ_pswd").val()==''||$("#QQ_pswd_confirm").val()=='')
		  {
		     layer.alert("请完善信息!");
		  }else
		  {
		     if($("#QQ_pswd").val()!=$("#QQ_pswd_confirm").val())
		     {
		         layer.alert("两次密码不一致!");
		     }else
		     {
			      $.ajax({  
	              url : "register.do", 
	              type : "post",  
	              data : $('#form_reg').serialize(),  
	               success : function(data){  
	                 layer.alert(data);
	               },  
	               error : function(data){
	                 layer.alert(data);  
	               }  
	               });  
		     }
		  }
		
		}
		</script>
		<style type="text/css">
		.tb{margin-left:28px;margin-top:10px;}
		.tb tr{height:35px;}
		input[type=checkbox]{margin-left:70px;}
		select{width:70px;height:20px;color:#645D5D;}
		</style>
	</head>
	<body>
		<div class="wrap login_wrap">
			<div class="content">
				
				<div class="logo"></div>
				
				<div class="login_box">	
					
					<div class="login_form">
						<div class="login_title">
							QQ注册
						</div>
						<form id="form_reg">
							
							<div class="form_text_ipt">
								<input name="QQ_webname" id="QQ_webname" type="text" placeholder="昵称">
							</div>
							<div class="ececk_warning"><span>昵称不能为空</span></div>
							<div class="form_text_ipt">
								<input name="QQ_pswd" id="QQ_pswd" type="password" placeholder="密码">
							</div>
							<div class="ececk_warning"><span>密码不能为空</span></div>
							<div class="form_text_ipt">
								<input name="QQ_pswd_confirm" id="QQ_pswd_confirm" type="password" placeholder="重复密码">
							</div>
							<div class="ececk_warning"><span>密码不能为空</span></div>
							
							<table class="tb">
							<tr>
							<td>
							<input type="checkbox" checked="checked" name="u_sex" value="男"/>男<input type="checkbox" name="u_sex" value="女"/>女
							</td>
							</tr>
							<tr>
							<td>
							<select>
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
					         </select>
							</td>
							</tr>
							<tr>
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
							</table>
							
							<div class="form_btn">
								<button onclick="check();" type="button">注册</button>
							</div>
							<div class="form_reg_btn">
								<span>已有帐号？</span><a href="view/login.jsp">马上登录</a>
							</div>
						</form>
						<div class="other_login">
							<div class="left other_left">
								<span>其它登录方式</span>
							</div>
							<div class="right other_right">
								<a href="javascript:void(0)">微信登录</a>
								<a href="javascript:void(0)">微博登录</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<script type="text/javascript" src="js/jquery.min.js" ></script>
		<script type="text/javascript" src="js/common.js" ></script>
	    <script type="text/javascript" src="js/provinceCity.js"></script> 
	</body>
</html>
