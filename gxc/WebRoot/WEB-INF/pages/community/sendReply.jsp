<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/community/sendReply.css" />

<div id="sendReply-wrap">
	<div id="sendReply-top">
		<span>回复</span>
	</div>
	<div id="sendReply-content">
		<form action="${pageContext.request.contextPath}/replyAction_sendReply" id="form_sendReply" method="post">
			<s:hidden name="user.userId" value="%{#session.loginUser.userId}"></s:hidden>
			<s:hidden name="topic.topicId" value="%{topicId}"></s:hidden>
			<div id="sendReply-content">
				<s:textarea name="replyContent" placeholder="回复内容"></s:textarea>
			</div>
			<input type="button" id="btn-send-reply" value="回复">
		</form>
	</div>
</div>
