<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>index.jsp</title>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript">
$(function(){
	window.location.href = "${pageContext.request.contextPath}/topicAction_AllTopic";
})
</script>
</head>
<body>
	<%-- <jsp:forward page="/WEB-INF/pages/index.jsp"></jsp:forward> --%>
</body>
</html>