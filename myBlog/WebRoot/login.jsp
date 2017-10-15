<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<title>登 录</title>
<link rel="stylesheet" type="text/css" href="css/login.css">
<script type="text/javascript">
	$(function(){
		$("#login_content").slideDown(500);
		
		$("#btn_login").click(function(){
			$("#msg_content").hide();
			var username = $("#username").val();
			var password = $("#password").val();
			if(username.length==0 || password.length==0){
			$("#msg_content").show(300);
				$("#span_msg").text("用户名或密码不能为空");
			}
		});
	});
</script>
<style type="text/css">

</style>
</head>
<body>
	<jsp:include page="top.jsp"></jsp:include>
	<div id="content">
		<div id="inner_content">
			<div id="login_content">
				<div id="login_top">
					<h2>账号登录</h2>
				</div>
				<div id="login_msg">
					<div id="msg_content">
						<img alt="error" src="images/error_16x16.png">
						<span id="span_msg"></span>
					</div>
				</div>
				<div id="login_form">
					<form action="">
						<table>
							<tr><td>
								<input type="text" name="username" id="username" placeholder="用户名" />
							</td></tr>
							<tr><td>
								<input type="password" name="password" id="password" placeholder="密码" />
							</td></tr>
							<tr><td>
								<input type="text" name="validate" id="validate" placeholder="验证码"/>
								<!-- <img alt="验证码" src="#" id="valipic"> -->
							</td></tr>
							<tr id="tr_save"><td>
								<input type="checkbox" name="save" value="yes"/>
								<span id="span_save">记住登录状态</span>
							</td></tr>
							<tr><td>
								<button type="button" id="btn_login">登  录</button>
							</td></tr>
						</table>
					</form>
				</div>
				<div id="login_foot">
					<div id="foot_content">
						<a href="${pageContext.request.contextPath }/login.jsp" id="a_regist">注册</a>
						<a href="${pageContext.request.contextPath }/login.jsp" id="a_forget">忘记密码?</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>