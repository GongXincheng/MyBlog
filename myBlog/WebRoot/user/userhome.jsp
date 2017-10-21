<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的主页</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/user/userhome.css">
</head>
<body id="bodyContent">
	<jsp:include page="../top.jsp"></jsp:include>
	
	<div id="content">
		<div id="userhome_top_pic">
			<img alt="background" src="${pageContext.request.contextPath}/images/336903-106.jpg">
		</div>
		
		<div id="userhome_main">
			<div id="userhome_main_head">
				<img alt="head" src="${pageContext.request.contextPath}/images/user/head_1.png">
			</div>
			<div id="userhome_main_middle">
				<div id="main_info">
					<span id="mian_span_username"><B>宫新程</B></span>
					<span id="mian_span_sign"><B>一切为了更好的自己</B></span><br/>				
				</div>
				<div id="main_detail_a">
					<a href="javascipt:void(0);" >查看详细信息</a>
				</div>
			</div>
			<div id="userhome_main_button">
				<button id="btn_detail" type="button">编辑个人资料</button>
			</div>
		</div>
		
		<div id="userhome_content">
			
		</div>
	</div>
</body>
</html>