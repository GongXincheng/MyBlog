<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GXC's blog</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css">
<script type="text/javascript">
	$(function(){
		$("#content_msg div").slideDown(1800);
	})
</script>
</head>
<body>
	<jsp:include page="top.jsp"></jsp:include>
	
		<div id="content_msg">
			<div>
				<h2 align="center">欢迎，正在努力建设中...</h2><br/>
				<h3 align="center">敬请期待</h3>
			</div>
		</div>
	
</body>
</html>