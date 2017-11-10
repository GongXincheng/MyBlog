<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/community/sendTopic.css" />

<div id="sendTopic-wrap">
	<div id="sendTopic-top">
		<span>发表主题</span>
	</div>
	<div id="sendTopic-content">
		<form action="${pageContext.request.contextPath}/TopicAction_sendTopic" id="form_sendTopic" method="post">
			<%-- <s:hidden name="uid" value="%{#session.user.uid}"></s:hidden> --%>
			<div id="sendTopic-title">
				<s:textfield name="title" id="title" placeholder="标题内容"></s:textfield>
			</div>
			<div id="sendTopic-content">
				<s:textarea name="topicContent" placeholder="主题内容"></s:textarea>
			</div>
			<input type="button" id="btn-send" value="发表帖子">
		</form>
	</div>
</div>
