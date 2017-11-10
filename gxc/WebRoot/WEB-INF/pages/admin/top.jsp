<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/admin/top.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/admin/top.js"></script>
</head>
<body>
	<div id="top">
		<div id="top_content">
			<div id="top_logo">
				<div>
					<span id="G">G</span>
					<span id="X">X</span>
					<span id="C">C</span>
					<span id="D">后台</span>
				</div>
			</div>
			<div id="top_menu">
				<ul>
					<li><a href="${pageContext.request.contextPath}/index.jsp">博客首页</a></li>
					<li><a href="javascript:void(0);">最近登陆</a></li>
					<li><a href="javascript:void(0);">用户信息</a></li>
					<li><a href="javascript:void(0);">发帖</a></li>
					<li><a href="${pageContext.request.contextPath}/admin/Board_allBoardByDesc">留言板</a></li>
				</ul>
			</div>
			<div id="top_user">
				<div id="user_content">
					<%-- 登陆后 --%>
					<ul id="ul_user">
						<li id="ul_user_fistli">
							<img id="top_user_img_user" alt="head" src="${pageContext.request.contextPath }/images/head.png">
							<a href="#" id="top_user_a_user">
								<s:property value="#session.user.username"></s:property>
							</a>
						</li>
						<li class="li" id="ul_user_twoli"><a href="${pageContext.request.contextPath }/user/userhome.jsp">我的主页</a></li>
						<li class="li"><a href="#">个人资料</a></li>
						<li class="li" id="ul_user_lastli"><a id="userLeave" href="javascript:void(0);">退出</a></li>
					</ul>
				</div>
			</div> 
		</div>
	</div>
</body>
</html>