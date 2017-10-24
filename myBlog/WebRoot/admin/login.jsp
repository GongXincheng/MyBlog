<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员登录</title>
<link rel="icon" href="${pageContext.request.contextPath}/images/blog.ico" type="image/x-icon" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/admin/login.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/admin/login.js"></script>
<style type="text/css">
</style>

</head>
<body>
	<div id="content">
		
		<div id="content_top">
			<h1>GXC 后台管理</h1>
		</div>	
		
		<div id="content_main">
			<div id="login_regist_content">
				<div id="login_regist_top">
						<a href="javascript:void(0);" id="a_left">登 录</a>
				</div>
				
				<!------------ 登录 ------------>
				<div id="login_content">
					<div id="login_msg">
						<div id="msg_login">
							<img id="login_error_img" alt="error" src="${pageContext.request.contextPath}/images/error_16x16.png"> 
							<span id="login_span_msg"></span>
						</div>
					</div>
					<div id="login_form">
						<form action="${pageContext.request.contextPath}/User_login" method="post" id="form_login">
							<table cellpadding="0" cellspacing="0">
								<tr>
									<td>
										<s:textfield name="username" id="username" placeholder="用户名" theme="simple"></s:textfield>
									</td>
								</tr>
								<tr>
									<td>
										<s:password name="password" id="password" placeholder="密码" theme="simple"></s:password>
									</td>
								</tr>
								<tr>
									<td>
										<div id="div_validate">
											<div id="validate_left">
												<s:textfield name="validate" id="validate" placeholder="验证码" theme="simple"></s:textfield>
											</div>
											<div id="validate_right">
												<img id="login_captcha" alt="验证码" src="${pageContext.request.contextPath}/captchaAction">
											</div>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<button type="button" id="btn_login">登 录</button>
									</td>
								</tr>
							</table>
						</form>
						<div id="login_regist_foot"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
