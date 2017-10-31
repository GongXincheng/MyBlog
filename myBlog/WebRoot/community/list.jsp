<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/community/topicList.css">
<script type="text/javascript">
	$(function(){
		$("h1").show(500,function(){
			$("#cmt_left").slideDown(420);
		});
	});
</script>
<title>社 区</title>
</head>
<body id="bodyContent">
	 <jsp:include page="../top.jsp"></jsp:include>
	 
	 <div id="content">
	 	 <br/>
		 <h1>Welcome To GXC's Community</h1>
		 <br/>
		 
		 <div id="cmt_top">cmt_top</div>
		 
		 <%-- left --%>
		 <div id="cmt_left">
		 
		 	<!-- 帖子1 -->
			<div id="topic-list">
				<div id="topic-headpic"></div>
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
				<div id="topic-headpic"></div>
				<div id="topic-content">
					<div id="topic-title">
						<a id="topic-title-a" href="#">为什么很多程序员喜欢linux系统？</a>
					</div>
					<div id="clear"></div>
					<div id="topic-detail">
						<a href="#" id="topic-a-user">宫新程</a>
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
				<div id="topic-headpic"></div>
				<div id="topic-content">
					<div id="topic-title">
						<a id="topic-title-a" href="#">有哪些明明是 bug，却被说成是 feature 的例子？</a>
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
			
			<!-- 帖子4 -->
			<div id="topic-list">
				<div id="topic-headpic"></div>
				<div id="topic-content">
					<div id="topic-title">
						<a id="topic-title-a" href="#">Flow耳机官网有没有货，是不是放几条意思意思就把这个项目烂尾了？</a>
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
			
			
	     </div>
		 
		  <%-- right --%>
		 <div id="cmt_right">cmt_right</div>
		 
	 </div>
	 
	
</body>
</html>