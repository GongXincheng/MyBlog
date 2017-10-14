<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GXC's blog</title>
<link rel="icon" href="images/blog.ico" type="image/x-icon" />
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript">
	
	$(function(){
		$("#content_msg div").slideDown(1800);
	})
</script>
<style type="text/css">
#content_msg{
	background-color: rgb(36, 41, 46);
    height: 120px;
    width: 400px;
    margin: 100px auto;
	margin-top: 50px;
	padding-top: 60px;
}
#content_msg div{
	display: none;
}
h2,h3{
	color: rgb(0, 235, 249);
}
</style>
</head>
<body>
	<jsp:include page="top.jsp"></jsp:include>
	<div id="content">
		<div id="content_msg">
			<div>
				<h2 align="center">欢迎，正在努力建设中...</h2><br/>
				<h3 align="center">敬请期待</h3>
			</div>
		</div>
	</div>
</body>
</html>