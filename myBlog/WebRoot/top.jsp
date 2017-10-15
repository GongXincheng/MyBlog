<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/top.css">
<script type="text/javascript" src="js/top_load.js"></script>
<script type="text/javascript">
	$(function(){
		$("#top_logo div").click(function(){
		//$(location).attr('href', '${pageContext.request.contextPath}/index.jsp');
		location.href = '${pageContext.request.contextPath}/index.jsp';
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
					<li><a href="index.jsp">首 页</a></li>
					<li><a href="#">文 章</a></li>
					<li><a href="#">社 区</a></li>
					<li><a href="#">留 言</a></li>
					<li><a href="#">关于我</a></li>
				</ul>
			</div>
			<div id="top_user">
				
				<div id="user_content">
					<ul id="ul_login">
						<li id="li_first">
							<img id="img_user" alt="user" src="images/user.png">
						</li>
						<li>
							<a href="${pageContext.request.contextPath }/login.jsp">登 录</a>
						</li>
						<li>
							<a href="${pageContext.request.contextPath }/login.jsp">注 册</a>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</body>
</html>