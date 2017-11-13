<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人资料</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/user/detail.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/user/edit.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/user/detail.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/user/edit.js"></script>
<script type="text/javascript">
$(function(){
	//返回主页
	$("#btn_back").click(function(){
		location.href = "${pageContext.request.contextPath}/userAction_userHome?userId=${userId}";
	});
	//修改信息
	$("#edit_submit").click(function(){
		$("#form_edit")[0].submit();
	});
});
</script>
</head>
<body id="bodyContent">
	<jsp:include page="../top.jsp"></jsp:include>
	
	<div id="content">
	
		<!-- 顶部图片 -->
		<div id="userhome_top_pic">
			<img alt="background" src="${pageContext.request.contextPath}/images/336903-106.jpg">
		</div>
		
		<div id="userhome_main">
			<div id="userhome_main_head">
				<div id="head-mask">
					<img alt="camera" src="${pageContext.request.contextPath}/images/camera_35x35.png">
					<span>编辑头像</span>
				</div>
				<img alt="head" src="${pageContext.request.contextPath}/images/user/${face}">
			</div>
		
			<div id="user-detail">
				<div id="detail-top">
					<div id="top-left">
						<span id="detail-span-username">${username }</span>
					</div>
					<div id="top-right">
						<s:if test="#session.loginUser.userId==userId">
							<button id="btn_edit" type="button">编&nbsp;&nbsp;辑</button>
						</s:if>
						<button id="btn_back" type="button">返回主页</button>
					</div>
				</div>
				
				<input type="hidden" id="user-id" value="${userId}">
				<input type="hidden" id="session-id" value="${session.loginUser.userId}">
				
				<!-- 真实姓名 -->
				<div id="div-realname" class="div-column">
					<span class="span-left">真实姓名</span>
					<span class="span-right">${empty realname ? '未填写' : realname }</span>
				</div>
				
				<!-- gender -->
				<div id="div-gender" class="div-column">
					<span class="span-left">性别</span>
					<span class="span-right">${empty gender ? 'null' : gender }</span>
				</div>
				
				<!-- sign -->
				<div id="div-sign" class="div-column">
					<span class="span-left">个性签名</span>
					<span class="span-right">${empty sign ? '未填写' : sign }</span>
				</div>
				
				<!-- address -->
				<div id="div-address" class="div-column">
					<span class="span-left">居住地</span>
					<span class="span-right">修改</span>
<%-- 				<span class="span-right">${empty pro.province ? '未填写': pro.province }&nbsp;&nbsp;&nbsp;${cit.city}</span> --%>
				</div>
				
				<!-- email -->
				<div id="div-email" class="div-column">
					<span class="span-left">邮箱</span>
					<span class="span-right">${empty email ? '未填写' : email }</span>
				</div>
				
				<!-- telephone -->
				<div id="div-telephone" class="div-column">
					<span class="span-left">电话</span>
					<span class="span-right">${empty telephone ? '未填写' : telephone }</span>
				</div>
				
				<!-- registDate -->
				<div id="div-registDate" class="div-column">
					<span class="span-left">注册时间</span>
					<span class="span-right">
						<s:date name="%{registDate}" format="yyyy-MM-dd HH:mm:ss"/>
					</span>
				</div>
				
				<!-- note -->
				<div id="div-note" class="div-column">
					<span class="span-left">简介</span>
					<span class="span-right">${empty note ? '未填写' : note }</span>
				</div>
				
			</div>
			
		</div>	
	</div>
	
	
	<%-- 修改个人信息 --%>
	<div class="edit-content">
		<div id="edit-content-top">
			<span>编辑个人信息</span>
			<img alt="close" src="${pageContext.request.contextPath}/images/close_18x18.png">
		</div>
		
		<div id="edit-content">
			<form action="userAction_edit" id="form_edit" method="post">
				<input type="hidden" name="userId" value="${userId}">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td class="td-column">真实姓名</td>
						<td>
							<s:textfield id="realname" name="realname"></s:textfield>
						</td>
					</tr>
					<tr>
						<td class="td-column">性别</td>
						<td>
							<s:radio list="{'男','女'}" name="gender"></s:radio>
							<%-- <input type="radio" value="1" name="gender" ${user.gender==1 ? "checked='checked'" :''}>&nbsp;男&nbsp;&nbsp;&nbsp;
							<input type="radio" value="0" name="gender" ${user.gender==0 ? "checked='checked'" :''}>&nbsp;女 --%>
						</td>
					</tr>
					<tr>
						<td class="td-column">个性签名</td>
						<td>
							<s:textfield id="sign" name="sign"></s:textfield>
						</td>
					</tr>
					<%-- <tr>
						<td class="td-column">居住地</td>
						<td class="td-city">
							<select name="province" id="province" class="${user.province }"></select>&nbsp;&nbsp;
							<select name="city" id="city" class="${user.city }">
								<option value="${user.city }">${cit.city }</option>
							</select>
						</td>
					</tr> --%>
					<tr>
						<td class="td-column">邮箱</td>
						<td>
							<s:textfield id="email" name="email"></s:textfield>
						</td>
					</tr>
					<tr>
						<td class="td-column">电话</td>
						<td>
							<s:textfield id="telephone" name="telephone"></s:textfield>
						</td>
					</tr>
					<tr id="tr-note">
						<td class="td-column">简介</td>
						<td>
							<s:textarea id="note" name="note"></s:textarea>
						</td>
					</tr>
				</table>
				<div id="edit_btn">
					<button id="edit_submit" class="edit_btn">确定</button>
					<button id="edit_close" type="button" class="edit_btn" >取消</button>
				</div>
			</form>
		</div>
		
	</div>
	
	
	<div id="edit-head-content">
		<div id="edit-head-list">
			<s:iterator begin="0" end="9" var="i">
				<img alt="head_0<s:property value="#i"/>.jpg" src="${pageContext.request.contextPath}/images/user/head_0<s:property value="#i"/>.jpg">
			</s:iterator>
		</div>
	</div>
</body>
</html>