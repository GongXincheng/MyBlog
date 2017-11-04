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
		 			<li><a href="#">最新主题</a></li>
		 			<li><a href="#">时间顺序</a></li>
		 			<li><a href="#">热门查看</a></li>
		 		</ul>
		 	</div>
		 	<div id="cmt_top_right">
		 		
		 	</div>
		 </div>
		 
		 <%-- left --%>
		 <div id="cmt_left">
		 
		 	<!-- 帖子1 -->
			<div id="topic-list">
				<div id="topic-headpic">
					<img alt="head_1.png" src="${pageContext.request.contextPath}/images/user/head_1.png">
				</div>
				<div id="topic-content">
					<div id="topic-title">
						<a id="topic-title-a" href="#">WPS Office 是不是金山公司抄袭微软 Office 的？</a>
					</div>
					<div id="clear"></div>
					<div id="topic-detail">
						<a href="#" id="topic-a-user">宫新程</a>
						<a id="a-read">1555</a>
						<a id="a-reply">855</a>
						<a id="a-zan">855</a>
						<a id="a-date">2017-11-15 08:55</a>
					</div>
				</div>
				<div id="clear"></div>
			</div>
			
			<!-- 帖子2 -->
			<div id="topic-list">
				<div id="topic-headpic">
					<img alt="head_04.jpg" src="${pageContext.request.contextPath}/images/user/head_04.jpg">
				</div>
				<div id="topic-content">
					<div id="topic-title">
						<a id="topic-title-a" href="#">为什么很多程序员喜欢linux系统？</a>
					</div>
					<div id="clear"></div>
					<div id="topic-detail">
						<a href="#" id="topic-a-user">薛令令</a>
						<a id="a-read">125</a>
						<a id="a-reply">8</a>
						<a id="a-zan">54</a>
						<a id="a-date">2017-11-15 08:55</a>
					</div>
				</div>
				<div id="clear"></div>
			</div>
			
			<!-- 帖子3 -->
			<div id="topic-list">
				<div id="topic-headpic">
					<img alt="head_03.jpg" src="${pageContext.request.contextPath}/images/user/head_03.jpg">
				</div>
				<div id="topic-content">
					<div id="topic-title">
						<a id="topic-title-a" href="#">有哪些明明是 bug，却被说成是 feature 的例子？</a>
					</div>
					<div id="clear"></div>
					<div id="topic-detail">
						<a href="#" id="topic-a-user">王昱烜</a>
						<a id="a-read">1555</a>
						<a id="a-reply">855</a>
						<a id="a-zan">855</a>
						<a id="a-date">2017-11-15 08:55</a>
					</div>
				</div>
				<div id="clear"></div>
			</div>
			
			<!-- 帖子4 -->
			<div id="topic-list">
				<div id="topic-headpic">
					<img alt="head_09jpg" src="${pageContext.request.contextPath}/images/user/head_09.jpg">
				</div>
				<div id="topic-content">
					<div id="topic-title">
						<a id="topic-title-a" href="#">Flow耳机官网有没有货，是不是放几条意思意思就把这个项目烂尾了？</a>
					</div>
					<div id="clear"></div>
					<div id="topic-detail">
						<a href="#" id="topic-a-user">杨昆</a>
						<a id="a-read">1555</a>
						<a id="a-reply">855</a>
						<a id="a-zan">855</a>
						<a id="a-date">2017-11-15 08:55</a>
					</div>
				</div>
				<div id="clear"></div>
			</div>
			
			
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
	 
</body>
</html>