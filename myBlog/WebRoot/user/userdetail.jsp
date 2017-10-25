<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人信息</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/user/detail.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/user/detail.js"></script>
<script type="text/javascript">
$(function(){
	//返回主页
	$("#btn_back").click(function(){
		location.href = "${pageContext.request.contextPath}/user/userhome.jsp";
	});
});
</script>
</head>
<body id="bodyContent">
	<jsp:include page="../top.jsp"></jsp:include>
	
	<div id="content">
	
		<!-- 顶部图片 -->
		<div id="userhome_top_pic">
			<img alt="background" src="${pageContext.request.contextPath}/images/336903-106.jpg">
		</div>
		
		<div id="userhome_main">
			<div id="userhome_main_head">
				<img alt="head" src="${pageContext.request.contextPath}/images/user/head_1.png">
			</div>
		
			<div id="user-detail">
				<div id="detail-top">
					<div id="top-left">
						<span id="detail-span-username">宫新程</span>
					</div>
					<div id="top-right">
						<button id="btn_edit" type="button">编&nbsp;&nbsp;辑</button>
						<button id="btn_back" type="button">返回主页</button>
					</div>
				</div>
				
				<!-- 真实姓名 -->
				<div id="div-realname" class="div-column">
					<span class="span-left">真实姓名</span>
					<span class="span-right">宫新程</span>
				</div>
				
				<!-- gender -->
				<div id="div-gender" class="div-column">
					<span class="span-left">性别</span>
					<span class="span-right">男</span>
				</div>
				
				<!-- sign -->
				<div id="div-sign" class="div-column">
					<span class="span-left">个性签名</span>
					<span class="span-right">一切只为更好的自己</span>
				</div>
				
				<!-- address -->
				<div id="div-address" class="div-column">
					<span class="span-left">居住地</span>
					<span class="span-right">山东 滕州</span>
				</div>
				
				<!-- email -->
				<div id="div-email" class="div-column">
					<span class="span-left">邮箱</span>
					<span class="span-right">gongxincheng1@163.com</span>
				</div>
				
				<!-- telephone -->
				<div id="div-telephone" class="div-column">
					<span class="span-left">电话</span>
					<span class="span-right">17863655266</span>
				</div>
				
				<!-- registDate -->
				<div id="div-registDate" class="div-column">
					<span class="span-left">注册时间</span>
					<span class="span-right">2012-12-24 12:00:00</span>
				</div>
				
				<!-- note -->
				<div id="div-note" class="div-column">
					<span class="span-left">简介</span>
					<span class="span-right">一只在奋发图强的程序猿</span>
				</div>
				
			</div>
			
		</div>	
	</div>
</body>
</html>