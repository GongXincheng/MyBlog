<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主题</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/community/topicDetail.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/community/list.js"></script>
</head>
<body>
<jsp:include page="../top.jsp"></jsp:include>
	<div id="content">
		<div id="topicDetail-content">
		
	    	<!-- 用户信息 -->
	        <div id="topicDetail-left">
	        	<div id="left_userDetail">
	        		<s:a action="userAction_userHome" namespace="/">
	        			<s:param name="userId" value="%{user.userId}"></s:param>${user.username}
	        		</s:a>
	                <div id="userDetail-head">
	                	<s:a action="userAction_userHome" namespace="/">
	        				<s:param name="userId" value="%{user.userId}"></s:param>
	               			<img alt="${user.face}" src="${pageContext.request.contextPath}/images/user/${user.face}"/>
	        			</s:a>
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
	        		<!-- 主题头 -->
	        		<div id="topic-right-top">
		        		<span id="topicTitle-span">${toicTitle}</span>
		        		<a id="a-read">${visitNum}</a>
						<a id="a-reply">${replySet.size()}</a>
						<a id="a-zan">${zanNum }</a>
						<a id="a-date">
							<s:date name="sendTopicDate" format="yyyy-MM-dd HH:mm:ss"/>
						</a>
						<a id="floor-name">楼主</a>		
						<a id="floor">#1</a>
					</div>
					
					<!-- 主题内容 -->
					<div id="div-topicContent">
						<span id="span-topicContent">
							${topicContent }<br/>
						</span>
					</div>
					
					<!-- 点赞 -->
					<div id="topic-content-menu">
						<div>
							<a id="topicZan-a">520</a>
						</div>
						<div id="clear"></div>
					</div>
	        	</div>
	        </div>
	        
	        
	        
	        <!-- 回复 列表-->
	        
	        <!-- 用户信息  left  1-->
	        
	        <s:iterator value="replySet" status="vs">
		        <div id="topicDetail-left">
		        	<div id="left_userDetail">
		            	<s:a action="userAction_userHome">
	        				<s:param name="userId" value="%{user.userId}"></s:param>${user.username}
	        			</s:a>
		                <div id="userDetail-head">
		                	<s:a action="userAction_userHome">
	        					<s:param name="userId" value="%{user.userId}"></s:param>
		               			<img alt="${user.face}" src="${pageContext.request.contextPath}/images/user/${user.face}"/>
	        				</s:a>
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
		        		<!-- 回复头 -->
		        		<div id="topic-right-top" class="right-top-reply">
							<a id="a-date" class="a-date-class">
								<s:date name="replyDate" format="yyyy-MM-dd HH:mm:ss"/>
							</a>
							<s:if test="#vs.count==1">
								<a id="floor-name" style="background-color: red;">沙发</a>
							</s:if>	
							<s:if test="#vs.count==2">
								<a id="floor-name" style="background-color: rgb(10, 160, 254);">板凳</a>
							</s:if>	
							<a id="floor">#<s:property value="#vs.count + 1"/></a>
						</div>
						
						<!-- 回复内容 -->
						<div class="div-replyContent">
							<span id="span-topicContent">
								${replyContent}<br/>
							</span>
						</div>
		        	</div>
		        </div><!-- right -->
	       </s:iterator>
	        
	        
		</div><!-- topicDetail-content -->
	</div><!-- content -->
	
	<a href="javascript:void(0);" id="a-sendReply2" >回复</a>
	<jsp:include page="sendReply.jsp"></jsp:include>
</body>
</html>