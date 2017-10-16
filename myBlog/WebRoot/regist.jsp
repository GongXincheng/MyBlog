<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注 册</title>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<link rel="stylesheet" type="text/css" href="css/regist.css">
</head>
<body>
	<jsp:include page="top.jsp"></jsp:include>
	<div id="regist_content">
				<div id="regist_top">
					<div id="left"><a href="javascript:void(0);" id="a_left">登  录</a></div>
					<div id="right"><a href="javascript:void(0)" id="a_right">注  册</a></div>
				</div>
				<div id="regist_msg">
					<div id="msg_content">
						<img alt="error" src="images/error_16x16.png">
						<span id="span_msg"></span>
					</div>
				</div>
				<div id="regist_form">
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
							</td></tr>
							<tr id="tr_save"><td>
								<input type="checkbox" name="save" value="yes"/>
								<span id="span_save">记住登录状态</span>
								<a href="${pageContext.request.contextPath }/regist.jsp" id="a_forget">忘记密码?</a>
							</td></tr>
							<tr><td>
								<button type="button" id="btn_regist">登  录</button>
							</td></tr>
						</table>
					</form>
				</div>
				<div id="regist_foot"></div>
			</div>
	
</body>
</html>