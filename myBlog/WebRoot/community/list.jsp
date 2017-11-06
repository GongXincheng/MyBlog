<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/community/topicList.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/community/list.js"></script>
<title>社 区</title>
</head>
<body id="bodyContent">
	 <jsp:include page="../top.jsp"></jsp:include>
	 
	 <div id="content">
		 <div id="div-h">
		 	<h1 id="h1-1">Welcome To</h1>
			<h1 id="h1-2">&nbsp;GXC's Community</h1>
		 </div>
		 
		 <div id="cmt_top">
		 	<div id="cmt_top_left">
		 		<ul>
		 			<li><a href="${pageContext.request.contextPath}/TopicAction_findAll">最新主题</a></li>
		 			<li><a href="${pageContext.request.contextPath}/TopicAction_findAllAsc">最早发布</a></li>
		 			<li><a href="${pageContext.request.contextPath}/TopicAction_findAllByVisiteNum">热门查看</a></li>
		 		</ul>
		 	</div>
		 	<div id="cmt_top_right">
		 		
		 	</div>
		 </div>
		 
		 <%-- left --%>
		 <div id="cmt_left">
		 
			<s:iterator value="topicList">
				<div id="topic-list">
					<div id="topic-headpic">
						<img alt="${user.face}" src="${pageContext.request.contextPath}/images/user/${user.face}">
					</div>
					<div id="topic-content">
						<div id="topic-title">
							<s:a action="TopicAction_showTopic" id="topic-title-a" >
								 <s:param name="tid" value="%{tid}"></s:param>${title }
							</s:a>
						</div>
						<div id="clear"></div>
						<div id="topic-detail">
							<s:a action="User_goUserHome" id="topic-a-user">
								<s:param name="uid" value="%{user.uid}"></s:param>${user.username.length()>6 ? user.username.substring(0,6).concat("..."):user.username}
							</s:a>
							<a id="a-read">${visitNum }</a>
							<a id="a-reply">${replySet.size() }</a>
							<a id="a-zan">${zanNum }</a>
							<a id="a-date"><s:date name="createDate" format="yyyy-MM-dd HH:mm"/></a>
						</div>
					</div>
					<div id="clear"></div>
				</div>
			</s:iterator>
			
	     </div>
		 
		  <%-- right --%>
		 <div id="cmt_right">
		 
		 	<%--发帖--%>
		 	<div id="div-btn-sendTopic">
		 		<button type="button" id="btn-sendTopic">发帖</button>
		 	</div>
		 
		 	<%--签到 --%>
		 	<div id="div-btn-signIn">
		 		<div id="signIn_left">
		 			<div id="btn-signIn">&nbsp;&nbsp;&nbsp;&nbsp;签到</div>
		 		</div>
		 		
		 		<div id="signIn_right">
		 			<div id="sign_num">
		 				<span id="span1">今日签到</span>
		 				<span id="span2">1152人</span>
		 			</div>
		 		</div>
		 	</div>
		 	<div id="clear"></div>
		 
		 
		 	<!-- 搜索 -->
		 	<div id="topic-search-content">
		 		<s:textfield id="topicSearch" placeholder="请输入搜索内容"></s:textfield>
		 	</div>
		 
		 	<%-- 公告 --%>
			<div id="right_notice_content">
				<span>公告</span><hr/>
				<ul>
					<li><a href="javascript:void(0);">如果有任何建议</a></li>
					<li><a href="javascript:void(0);">请写在留言,或 </a></li>
					<li><a href="javascript:void(0);">QQ：757853223</a></li>
					<li><a href="javascript:void(0);">Tel：13563274342</a></li>
					<li><a href="javascript:void(0);">万分感谢 !</a></li>
				</ul>
			</div>
			
		 
		 </div>
		 
	 </div>
	 
	 <jsp:include page="sendTopic.jsp"></jsp:include>
	 
</body>
</html>