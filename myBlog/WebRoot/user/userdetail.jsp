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
	
	var hcWidth = $("#edit-head-content").width();
	var windWidth = $(document).width();
	var leftWidth = (windWidth - hcWidth)/2;
	
	//返回主页
	$("#btn_back").click(function(){
		location.href = "${pageContext.request.contextPath}/User_goUserHome?uid=${user.uid}";
	});
	
	$("#edit_submit").click(function(){
		$("#form_edit")[0].submit();
	});
	
	//编辑头像，显示隐藏
	$("#userhome_main_head").hover(function(){
		var uid = $("#user-id").val();
		var sessionId = $("#session-id").val();
		if(sessionId!=uid){
			return false;
		}
		else{
			$("#head-mask").show(0,function(){
				$("#edit-head-content").css("left",leftWidth);
			});
		}
	},
	function(){
		$("#head-mask").hide();
	});
	
	//点击头像
	$("#head-mask").click(function(){
		$("#mask").show(0,function(){
			$("#edit-head-content").slideDown(300);
		});
	});
	
	//头像被选中
	$("#edit-head-list img").click(function(){
		var picName = $(this).attr("alt");
		var uid = $("#user-id").val();
		$.ajax({
			url : "${pageContext.request.contextPath}/User_editHead",
			data : {
				face : picName,
				uid : uid
			},
			type : "POST",
			dataType : "json",
			success : function(data){
				var id = $("#user-id").val();
				location.href = "${pageContext.request.contextPath}/User_goUserDetail?uid="+id;
			},
			error:function(){}
		});
	});
});
</script>
<style type="text/css">
#head-mask{
	position: absolute;
	top: 0;
	left: 0;
	opacity:0.7;
	width: inherit;
	height: inherit;
	background: black;
	
	text-align:center;
	cursor:pointer;
	display: none;
}
#head-mask img{
	width: 35px;
	height: 35px;
	margin-top: 45px;
}
#head-mask span{
	display: block;
	padding: 10px 0;
	color: white;
	font-size:14px;
	font-weight:600;
	letter-spacing: 2px;
}
</style>
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
				<img alt="head" src="${pageContext.request.contextPath}/images/user/${user.face}">
			</div>
		
			<div id="user-detail">
				<div id="detail-top">
					<div id="top-left">
						<span id="detail-span-username">${user.username }</span>
					</div>
					<div id="top-right">
						<s:if test="#session.user.uid==user.uid">
							<button id="btn_edit" type="button">编&nbsp;&nbsp;辑</button>
						</s:if>
						<button id="btn_back" type="button">返回主页</button>
					</div>
				</div>
				
				<input type="hidden" id="user-id" value="${user.uid }">
				<input type="hidden" id="session-id" value="${session.user.uid }">
				
				<!-- 真实姓名 -->
				<div id="div-realname" class="div-column">
					<span class="span-left">真实姓名</span>
					<span class="span-right">${empty user.realname ?'未填写':user.realname }</span>
				</div>
				
				<!-- gender -->
				<div id="div-gender" class="div-column">
					<span class="span-left">性别</span>
					<span class="span-right">${user.gender==0? '女':'男' }</span>
				</div>
				
				<!-- sign -->
				<div id="div-sign" class="div-column">
					<span class="span-left">个性签名</span>
					<span class="span-right">${empty user.sign ?'未填写':user.sign }</span>
				</div>
				
				<!-- address -->
				<div id="div-address" class="div-column">
					<span class="span-left">居住地</span>
					<%-- <span class="span-right">${empty privince.province ?'未填写':privince.province }  ${city.city }</span> --%>
					<span class="span-right">${empty pro.province ? '未填写': pro.province }&nbsp;&nbsp;&nbsp;${cit.city}</span>
				</div>
				
				<!-- email -->
				<div id="div-email" class="div-column">
					<span class="span-left">邮箱</span>
					<span class="span-right">${empty user.email ?'未填写':user.email }</span>
				</div>
				
				<!-- telephone -->
				<div id="div-telephone" class="div-column">
					<span class="span-left">电话</span>
					<span class="span-right">${empty user.telephone ?'未填写':user.telephone }</span>
				</div>
				
				<!-- registDate -->
				<div id="div-registDate" class="div-column">
					<span class="span-left">注册时间</span>
					<span class="span-right">
						<s:date name="%{user.registDate}" format="yyyy-MM-dd HH:mm:ss"/>
					</span>
				</div>
				
				<!-- note -->
				<div id="div-note" class="div-column">
					<span class="span-left">简介</span>
					<span class="span-right">${empty user.note ?'未填写':user.note }</span>
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
			<form action="User_edit" id="form_edit" method="post">
				<input type="hidden" name="user.uid" value="${user.uid }">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td class="td-column">真实姓名</td>
						<td>
							<s:textfield id="realname" name="realname" value="%{user.realname}"></s:textfield>
						</td>
					</tr>
					<tr>
						<td class="td-column">性别</td>
						<td>
							<input type="radio" value="1" name="gender" ${user.gender==1 ? "checked='checked'" :''}>&nbsp;男&nbsp;&nbsp;&nbsp;
							<input type="radio" value="0" name="gender" ${user.gender==0 ? "checked='checked'" :''}>&nbsp;女
						</td>
					</tr>
					<tr>
						<td class="td-column">个性签名</td>
						<td>
							<s:textfield id="sign" name="sign" value="%{user.sign}"></s:textfield>
						</td>
					</tr>
					<tr>
						<td class="td-column">居住地</td>
						<td class="td-city">
							<select name="province" id="province" class="${user.province }"></select>&nbsp;&nbsp;
							<select name="city" id="city" class="${user.city }">
								<option value="${user.city }">${cit.city }</option>
							</select>
						</td>
					</tr>
					<tr>
						<td class="td-column">邮箱</td>
						<td>
							<s:textfield id="email" name="email" value="%{user.email}"></s:textfield>
						</td>
					</tr>
					<tr>
						<td class="td-column">电话</td>
						<td>
							<s:textfield id="telephone" name="telephone" value="%{user.telephone}"></s:textfield>
						</td>
					</tr>
					<tr id="tr-note">
						<td class="td-column">简介</td>
						<td>
							<s:textarea id="note" name="note" value="%{user.note}"></s:textarea>
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
				<%-- <span><s:property value="#i"/></span> --%>
				<img alt="head_0<s:property value="#i"/>.jpg" src="${pageContext.request.contextPath}/images/user/head_0<s:property value="#i"/>.jpg">
			</s:iterator>
		</div>
	</div>
</body>
</html>