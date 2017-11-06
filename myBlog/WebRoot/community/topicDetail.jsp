<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主题</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/community/topicDetail.css">

</head>
<body>
<jsp:include page="../top.jsp"></jsp:include>
	<div id="content">
		<div id="topicDetail-content">
	    	<!-- 用户信息 -->
	        <div id="topicDetail-left">
	        	<div id="left_userDetail">
	            	<a href="#">${user.username}</a>
	                <div id="userDetail-head">
	               		<img alt="${user.face}" src="${pageContext.request.contextPath}/images/user/${user.face}"/>
	                </div>
	                
	                <div id="top-rep-num">
	                	<span>主题 &nbsp; <a href="#">${user.topicSet.size()}</a></span>
	                	<span>回复 &nbsp; <a href="#">${user.replySet.size()}</a></span>
	                </div>
	            </div>
	        </div>
	        
	        <!-- right -->
	        <div id="topicDetail-right">
	        	
	        	<div id="topic-right-content">
	        		<div id="topic-right-top">
		        		<span id="topicTitle-span">${title}</span>
		        		<a id="a-read">${visitNum}</a>
						<a id="a-reply">${replySet.size()}</a>
						<a id="a-zan">${zanNum }</a>
						<a id="a-date">${createDate }</a>
						<div id="clear"></div>
					</div>
					<div id="div-topicContent">
						<span id="span-topicContent">
							${topicContent }<br/>
						</span>
					</div>
					<div id="topic-content-menu">
						
					</div>
	        	</div>
	        	
	        </div>
	        
	    </div>
	</div>
	
</body>
</html>