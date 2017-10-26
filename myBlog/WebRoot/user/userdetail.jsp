<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人信息</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/user/detail.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/user/edit.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/user/detail.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/user/edit.js"></script>
<script type="text/javascript">
$(function(){
	//返回主页
	$("#btn_back").click(function(){
		location.href = "${pageContext.request.contextPath}/user/userhome.jsp";
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
				<img alt="head" src="${pageContext.request.contextPath}/images/user/head_1.png">
			</div>
		
			<div id="user-detail">
				<div id="detail-top">
					<div id="top-left">
						<span id="detail-span-username">宫新程</span>
					</div>
					<div id="top-right">
						<button id="btn_edit" type="button">编&nbsp;&nbsp;辑</button>
						<button id="btn_back" type="button">返回主页</button>
					</div>
				</div>
				
				<!-- 真实姓名 -->
				<div id="div-realname" class="div-column">
					<span class="span-left">真实姓名</span>
					<span class="span-right">宫新程</span>
				</div>
				
				<!-- gender -->
				<div id="div-gender" class="div-column">
					<span class="span-left">性别</span>
					<span class="span-right">男</span>
				</div>
				
				<!-- sign -->
				<div id="div-sign" class="div-column">
					<span class="span-left">个性签名</span>
					<span class="span-right">一切只为更好的自己</span>
				</div>
				
				<!-- address -->
				<div id="div-address" class="div-column">
					<span class="span-left">居住地</span>
					<span class="span-right">山东 滕州</span>
				</div>
				
				<!-- email -->
				<div id="div-email" class="div-column">
					<span class="span-left">邮箱</span>
					<span class="span-right">gongxincheng1@163.com</span>
				</div>
				
				<!-- telephone -->
				<div id="div-telephone" class="div-column">
					<span class="span-left">电话</span>
					<span class="span-right">17863655266</span>
				</div>
				
				<!-- registDate -->
				<div id="div-registDate" class="div-column">
					<span class="span-left">注册时间</span>
					<span class="span-right">2012-12-24 12:00:00</span>
				</div>
				
				<!-- note -->
				<div id="div-note" class="div-column">
					<span class="span-left">简介</span>
					<span class="span-right">一只在奋发图强的程序猿</span>
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
			<form action="">
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
							<%-- <s:radio name="gender" id="gender" list="#{'1':'男','2':'女'}" value="1"></s:radio> --%>
							<input type="radio" value="1" name="gender" checked="checked">&nbsp;男&nbsp;&nbsp;&nbsp;
							<input type="radio" value="0" name="gender">&nbsp;女
						</td>
					</tr>
					<tr>
						<td class="td-column">个性签名</td>
						<td>
							<s:textfield id="sign" name="sign"></s:textfield>
						</td>
					</tr>
					<tr>
						<td class="td-column">居住地</td>
						<td class="td-city">
							<s:select name="province" id="province" list="#{'TZ':'滕州','SH':'上海','ZH':'珠海','qqhl':'齐齐哈尔'}"></s:select>省&nbsp;&nbsp;
							<s:select name="city" id="city" list="#{'TZ':'滕州','SH':'上海','ZH':'珠海','qqhl':'齐齐哈尔'}"></s:select>市
						</td>
					</tr>
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
					<s:submit id="edit_submit" cssClass="edit_btn" value="确定"></s:submit>
					<button id="edit_close" type="button" class="edit_btn" >取消</button>
				</div>
			</form>
		</div>
		
	</div>
</body>
</html>