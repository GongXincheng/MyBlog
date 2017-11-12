<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
<link rel="icon" href="${pageContext.request.contextPath}/images/blog.ico" type="image/x-icon" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/top.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login_regist.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/board.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/backTop.css">

<script type="text/javascript" src="${pageContext.request.contextPath}/js/top_load.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/login_regist.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/login_regist_validate.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/board.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/backTop.js"></script>
<script type="text/javascript">
//跳回首页
	$(function(){
		$("#top_logo div").click(function(){
			location.href = "${pageContext.request.contextPath}/index.jsp";
		})
	});
</script>
</head>
<body id="bodyContent">
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
					<li><a href="javascript:void(0);">文 章</a></li>
					<li><a href="UIAction_community_list">社 区</a></li>
					<li><a href="javascript:void(0);" id="top_menu_board">留 言</a></li>
					<s:if test="#session.user.role==1">
						<li><a href="${pageContext.request.contextPath}/admin/main.jsp">后台管理</a></li>
					</s:if>
				</ul>
			</div>
			<div id="top_user">
				<div id="user_content">
					<%-- 登陆前 --%>
					<img id="img_user" alt="user" src="${pageContext.request.contextPath}/images/user.png">
					<%-- 登陆后 --%>
					<ul id="ul_user">
						<li id="ul_user_fistli">
							<img id="top_user_img_user" alt="head" src="${pageContext.request.contextPath }/images/user/user.png">
							<a href="javascript:void(0);" id="top_user_a_user">
								${session.user.username.length()>5 ? session.user.username.substring(0,4).concat("...") : session.user.username }
							</a>
						</li>
						<li class="li" id="ul_user_twoli">
							<s:a action="User_goUserHome">
								<s:param name="uid" value="#session.user.uid"></s:param>我的主页
							</s:a>
						</li>
						<li class="li">
							<s:a action="User_goUserDetail">
								<s:param name="uid" value="#session.user.uid"></s:param>个人资料
							</s:a>
						</li>
						<li class="li" id="ul_user_lastli"><a id="userLeave" href="javascript:void(0);">退出</a></li>
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
	
	<!-- 留言板 -->
	<div id="board_wrap">
	<div id="clear"></div>
		<div id="board-title">
			<span>留言板</span>
		</div>
		
		<div id="board-content">
			<form action="#" id="form_board">
				<input type="hidden" value="${session.user.uid }" />
				<div id="board-content-username">
					<s:textfield name="username" value="%{#session.user.username}" id="boardUsername" placeholder="用户名  (可不填写)" ></s:textfield>
				</div>
				<div id="board-content-email">
					<s:textfield name="email" value="%{#session.user.email}" id="boardEmail" placeholder="邮 箱  (可不填写)"></s:textfield>
				</div>
				<div id="board-content-title">
					<s:textfield name="msgTitle" id="boardTitle" placeholder="标 题   (必填)"></s:textfield>
				</div>
				<div id="board-content-message">
					<s:textarea name="message" id="boardMessage" placeholder="留言内容(必填)"></s:textarea>
				</div>
				<div id="board-content-submit">
					<button type="button" id="board-submit" >提交</button>
				</div>
			</form>
			
		</div>
		
	</div>
	
	<!-- 返回顶部 -->
	<a href="javascript:void(0);" id="back_top" title="回到顶部"></a>
	
</body>

</html>