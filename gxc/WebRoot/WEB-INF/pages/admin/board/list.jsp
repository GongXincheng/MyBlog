<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>留言板</title>
<style type="text/css">
td{
	text-align: center;
	padding: 7px 10px;
}
#topsss{
	height: 50px; 
	line-height: 50px;
	text-align: center;
	
}
#topsss a{
	color: red;
	text-decoration: none;
}
</style>
</head>
<body>
<jsp:include page="../top.jsp"></jsp:include>

<div id="topsss" >
	<s:a action="AdminAction_message_allMessageByDesc" namespace="/admin">
		最近留言
	</s:a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<s:a action="AdminAction_message_allMessageByAsc" namespace="/admin">
		最早留言
	</s:a>
</div>

<table border="1">
	<tr>
		<td>Message ID</td>
		<td>用户名</td>
		<td>邮箱</td>
		<td>标题</td>
		<td>内容</td>
		<td>创建时间</td>
	</tr>
	<s:iterator value="allMessage">
		<tr>
			<td>${messageId}</td>
			<td>
				<s:a action="userAction_userHome" namespace="/">
					<s:param name="userId" value="user.userId"></s:param>${user.username}
				</s:a>
			</td>
			
			<td>${user.email}</td>
			<td>${messageTitle }</td>
			<td>${messageContent }</td>
			<td>
				<s:date name="sendMessageDate" format="yyyy-MM-dd HH:mm"/>
			</td>
		</tr>
	</s:iterator>
	
</table>
</body>
</html>