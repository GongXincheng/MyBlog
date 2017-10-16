<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GXC's blog</title>
<link rel="icon" href="images/blog.ico" type="image/x-icon" />
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<link rel="stylesheet" type="text/css" href="css/index.css">
<script type="text/javascript">
	
	$(function(){
		$("#content_msg div").slideDown(1800);
		
		//获取屏幕高度和宽度
		var screenHeight = $(window).height();
		var screenWidth = $(window).width();
		//alert(screenHeight+","+screenWidth);
		//获取文档高度
		var docHeight = $(document).height();  //676
		var docWidth = $(document).width();	//1438
		//alert(screenHeight+","+screenWidth);
		$("#mask")
	})
</script>
<style type="text/css">

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
		<div id="aaa"></div>
	</div>
	
	<!-- 遮罩层 -->
	<div id="mask">
		
	</div>
</body>
</html>