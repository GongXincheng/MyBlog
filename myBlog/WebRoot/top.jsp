<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/top.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login_regist.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/top_load.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/login_regist.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/login_regist_validate.js"></script>
<script type="text/javascript">
	$(function(){
		$("#top_logo div").click(function(){
			location.href = "${pageContext.request.contextPath}/index.jsp";
		})
	})
</script>
</head>
<body>
	<div id="top">
		<div id="top_content">
			<div id="top_logo">
				<div>
					<span id="G">G</span>
					<span id="X">X</span>
					<span id="C">C</span>
				</div>
			</div>
			<div id="top_menu">
				<ul>
					<li><a href="${pageContext.request.contextPath}/index.jsp">首 页</a></li>
					<li><a href="#">文 章</a></li>
					<li><a href="${pageContext.request.contextPath}/community/list.jsp">社 区</a></li>
					<li><a href="#">留 言</a></li>
					<li><a href="#">关于我</a></li>
				</ul>
			</div>
			<div id="top_user">
				<div id="user_content">
					<img id="img_user" alt="user" src="${pageContext.request.contextPath}/images/user.png">
					<ul id="ul_user">
						<li id="ul_user_fistli">
							<img id="top_user_img_user" alt="head" src="${pageContext.request.contextPath }/images/head.png">
							<a href="#" id="top_user_a_user">
								<s:property value="#session.loginName"/>
							</a>
						</li>
						<li class="li" id="ul_user_twoli"><a href="#">个人信息</a></li>
						<li class="li"><a href="#">设置</a></li>
						<li class="li"><a id="userLeave" href="javascript:void(0);">注销</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	
	<!-- 遮罩层 -->
	<div id="mask">
		<div id="login"></div>
		<div id="regist"></div>
	</div>
	
	<!---------------------------登录&注册----------------------------------->
	<div id="login_regist_content">
		<div id="login_regist_top">
			<div id="left">
				<a href="javascript:void(0);" id="a_left">登 录</a>
			</div>
			<div id="right">
				<a href="javascript:void(0)" id="a_right">注 册</a>
			</div>
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
										<!-- <h1>5 4 3 2</h1> -->
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
			</div>
		</div>
		
		<!-- 注册 -->
		<div id="regist_content">
			<div id="regist_msg">
				<div id="msg_regist">
					<img id="regist_error_img" alt="error" src="${pageContext.request.contextPath}/images/error_16x16.png"> 
					<span id="regist_span_msg"></span>
				</div>
			</div>
			<div id="regist_form">
				<form action="" id="form_regist">
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
								<s:password name="rePassword" id="rePassword" placeholder="确认密码" theme="simple"></s:password>
							</td>
						</tr>
						<tr>
							<td>
								<div id="div_validate">
									<div id="validate_left">
										<s:textfield name="validate" id="validate" placeholder="验证码" theme="simple"></s:textfield>
									</div>
									<div id="validate_right">
										<!-- <h1>7 5 7 8</h1> -->
										<img id="regist_captcha" alt="验证码" src="${pageContext.request.contextPath}/captchaAction">
									</div>
								</div>
							</td>
						</tr>
						<tr>
							<td>
								<button type="button" id="btn_regist">注 册</button>
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>

		<div id="login_regist_foot"></div>
	</div>
</body>

</html>