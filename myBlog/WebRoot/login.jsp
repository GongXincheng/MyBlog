<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<title>登 录</title>
<link rel="stylesheet" type="text/css" href="css/login.css">
<script type="text/javascript">
	$(function(){
		$("#login_content").fadeIn(1200);
		
		$("#btn_login").click(function(){
			$("#msg_content").hide();
			var username = $("#username").val();
			var password = $("#password").val();
			var validate = $("#validate").val();
			if(username.length==0 || password.length==0){
				$("#msg_content").show(550);
				$("#span_msg").text("用户名或密码不能为空");
				return;
			}
			if(validate.length==0){
				$("#msg_content").show(550);
				$("#span_msg").text("请输入验证码");
				return;
			}
		});
		
		$("input[type='text'],input[type='password']").focus(function(){
			$(this)[0].style.boxShadow = "0px 0px 8px #06C";
		})
		$("input[type='text'],input[type='password']").blur(function(){
			$(this)[0].style.boxShadow = "";
		})
		
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
					<div id="left"><a href="#" id="a_left">登  录</a></div>
					<div id="right"><a href="#" id="a_right">注  册</a></div>
				</div>
				<div id="login_msg">
					<div id="msg_content">
						<img alt="error" src="images/error_16x16.png">
						<span id="span_msg"></span>
					</div>
				</div>
				<div id="login_form">
					<form action="">
						<table cellpadding="0" cellspacing="0">
							<tr><td>
								<s:textfield name="username" id="username" placeholder="用户名" theme="simple" ></s:textfield>
								<!-- <input type="text" name="username" id="username" placeholder="用户名" /> -->
							</td></tr>
							<tr><td>
								<s:password name="password" id="password" placeholder="密码" theme="simple"></s:password>
								<!-- <input type="password" name="password" id="password" placeholder="密码" /> -->
							</td></tr>
							<tr><td>
								<div id="div_validate">
									<div id="validate_left">
										<s:textfield name="validate" id="validate" placeholder="验证码" theme="simple"></s:textfield>
									</div>
									<div id="validate_right">
										<h1>5 4 3 2</h1>
									</div>
								</div>
								
								<!-- <input type="text" name="validate" id="validate" placeholder="验证码"/> -->
								<!-- <img alt="验证码" src="#" id="valipic"> -->
							</td></tr>
							<tr id="tr_save"><td>
								<input type="checkbox" name="save" value="yes"/>
								<span id="span_save">记住登录状态</span>
								<a href="${pageContext.request.contextPath }/login.jsp" id="a_forget">忘记密码?</a>
							</td></tr>
							<tr><td>
								<button type="button" id="btn_login">登  录</button>
							</td></tr>
						</table>
					</form>
				</div>
				<div id="login_foot"></div>
			</div>
		</div>
	</div>
</body>
</html>