<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>QQ空间登录</title>
    
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
		    if($("#QQ_No").val()==''||$("#QQ_pswd").val()=='')
		    {
		       layer.alert("账号和密码不能为空!");
		       return false;
		    }
		    else
		    {
		       $("#form_login").submit();
		    }
		}
		</script>
	</head>
	<body>
		<div class="wrap login_wrap">
			<div class="content">
				
				<div class="logo"></div>
				
				<div class="login_box">	
					
					<div class="login_form">
						<div class="login_title">
							QQ空间登录
						</div>
						<form id="form_login" action="login.do" method="post">
							
							<div class="form_text_ipt">
								<input name="QQ_No" id="QQ_No" type="text" placeholder="QQ账号">
							</div>
							<div class="ececk_warning"><span>账号不能为空</span></div>
							<div class="form_text_ipt">
								<input name="QQ_pswd" id="QQ_pswd" type="password" placeholder="密码">
							</div>
							<div class="ececk_warning"><span>密码不能为空</span></div>
							<div class="form_check_ipt">
								<div class="left check_left">
									<label><input name="" type="checkbox"> 下次自动登录</label>
								</div>
								<div class="right check_right">
									<a href="javascript:void(0)">忘记密码</a>
								</div>
							</div>
							<div class="form_btn">
								<button onclick="return check();" type="button">登录</button>
							</div>
							<div class="form_reg_btn">
								<span>还没有帐号？</span><a href="view/register.jsp">马上注册</a>
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
	</body>
</html>
