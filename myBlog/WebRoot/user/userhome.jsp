<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的主页</title>
<link rel="icon" href="${pageContext.request.contextPath}/images/blog.ico" type="image/x-icon" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/user/userhome.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/user/userhome.js"></script>
<script type="text/javascript">
$(function(){
	$("#main_detail_a a").click(function(){
		location.href = "${pageContext.request.contextPath}/user/userdetail.jsp";
	});
	
	$("#btn_detail").click(function(){
		location.href = "${pageContext.request.contextPath}/user/userdetail.jsp";
	});
	
})
</script>
</head>
<body id="bodyContent">
	<jsp:include page="../top.jsp"></jsp:include>
	
	<div id="content">
		<div id="userhome_top_pic">
			<img alt="background" src="${pageContext.request.contextPath}/images/336903-106.jpg">
		</div>
		
		<div id="userhome_main">
			<div id="userhome_main_head">
				<img alt="head" src="${pageContext.request.contextPath}/images/user/head_1.png">
			</div>
			<div id="userhome_main_middle">
				<div id="main_info">
					<span id="mian_span_username"><B>宫新程</B></span>
					<span id="mian_span_sign"><B>一切为了更好的自己</B></span><br/>				
				</div>
				<div id="main_detail_a">
					<a href="javascript:void(0);" >查看详细信息</a>
				</div>
			</div>
			<div id="userhome_main_button">
				<div id="gender">
					<img alt="male" src="${pageContext.request.contextPath}/images/male.png">
					<!-- <img alt="female" src="${pageContext.request.contextPath}/images/female.png"> -->
				</div>
				<button id="btn_detail" type="button">个人资料</button>
			</div>
		</div>
		
		<!-- 清除浮动 -->
		<div id="clear"></div>
		
		<div id="userhome_content">
			<!-- Menu -->
			<div id="userhome_content_menu">
				<div id="content_menu_ul">
					<ul>
						<li><a id="li_a_1" href="javascript:void(0);">动态</a></li>
						<li><a id="li_a_2" href="javascript:void(0);">回复</a></li>
						<li><a id="li_a_3" href="javascript:void(0);">留言</a></li>
					</ul>
				</div>
				<div id="menu_detail">
					<span id="menu_detail_span">回复/查看</span>
				</div>
				<div id="clear"></div>
				<div id="content_menu_bottom"></div>
			</div>
			
			<!-- List1 -->
			<div class="userhome_content_list">
				<!-- left -->
				<div id="list_left">
					<div id="list_topic">
						<span>发布了主题</span>
						<a href="javascript:void(0);">哪本书适合推荐给 Java 初学者？</a>
					</div>
				</div>
				<!-- right -->
				<div id="list_right">
					<div id="list_detail">
						<span>20</span> |<span>180</span>
					</div>
				</div>
				<div id="clear"></div>
			</div>
			
			
			<!-- 可删除! -->
			<!-- List2 -->
			<div class="userhome_content_list">
				<!-- left -->
				<div id="list_left">
					<div id="list_topic">
						<span>发布了主题</span>
						<a href="javascript:void(0);">Java新手如何学习Spring、Struts、Hibernate三大框架？</a>
					</div>
				</div>
				<!-- right -->
				<div id="list_right">
					<div id="list_detail">
						<span>20</span> |<span>180</span>
					</div>
				</div>
				<div id="clear"></div>
			</div>
			<!-- List3 -->
			<div class="userhome_content_list">
				<!-- left -->
				<div id="list_left">
					<div id="list_topic">
						<span>发布了主题</span>
						<a href="javascript:void(0);">最良心的软件可以良心到什么程度？</a>
					</div>
				</div>
				<!-- right -->
				<div id="list_right">
					<div id="list_detail">
						<span>20</span> |<span>180</span>
					</div>
				</div>
				<div id="clear"></div>
			</div>
			<!-- List4 -->
			<div class="userhome_content_list">
				<!-- left -->
				<div id="list_left">
					<div id="list_topic">
						<span>发布了主题</span>
						<a href="javascript:void(0);">如何培养/训练自己的耐力、耐心？</a>
					</div>
				</div>
				<!-- right -->
				<div id="list_right">
					<div id="list_detail">
						<span>20</span> |<span>180</span>
					</div>
				</div>
				<div id="clear"></div>
			</div>
			<!-- List5 -->
			<div class="userhome_content_list">
				<!-- left -->
				<div id="list_left">
					<div id="list_topic">
						<span>发布了主题</span>
						<a href="javascript:void(0);">如果外挂遇上外挂，结果会怎样？</a>
					</div>
				</div>
				<!-- right -->
				<div id="list_right">
					<div id="list_detail">
						<span>20</span> |<span>180</span>
					</div>
				</div>
				<div id="clear"></div>
			</div>
			<div class="userhome_content_list">
				<!-- left -->
				<div id="list_left">
					<div id="list_topic">
						<span>发布了主题</span>
						<a href="javascript:void(0);">最良心的软件可以良心到什么程度？</a>
					</div>
				</div>
				<!-- right -->
				<div id="list_right">
					<div id="list_detail">
						<span>20</span> |<span>180</span>
					</div>
				</div>
				<div id="clear"></div>
			</div>
			<div class="userhome_content_list">
				<!-- left -->
				<div id="list_left">
					<div id="list_topic">
						<span>发布了主题</span>
						<a href="javascript:void(0);">最良心的软件可以良心到什么程度？</a>
					</div>
				</div>
				<!-- right -->
				<div id="list_right">
					<div id="list_detail">
						<span>20</span> |<span>180</span>
					</div>
				</div>
				<div id="clear"></div>
			</div>
			<div class="userhome_content_list">
				<!-- left -->
				<div id="list_left">
					<div id="list_topic">
						<span>发布了主题</span>
						<a href="javascript:void(0);">最良心的软件可以良心到什么程度？</a>
					</div>
				</div>
				<!-- right -->
				<div id="list_right">
					<div id="list_detail">
						<span>20</span> |<span>180</span>
					</div>
				</div>
				<div id="clear"></div>
			</div>
			<div class="userhome_content_list">
				<!-- left -->
				<div id="list_left">
					<div id="list_topic">
						<span>发布了主题</span>
						<a href="javascript:void(0);">最良心的软件可以良心到什么程度？</a>
					</div>
				</div>
				<!-- right -->
				<div id="list_right">
					<div id="list_detail">
						<span>20</span> |<span>180</span>
					</div>
				</div>
				<div id="clear"></div>
			</div>
			<div class="userhome_content_list">
				<!-- left -->
				<div id="list_left">
					<div id="list_topic">
						<span>发布了主题</span>
						<a href="javascript:void(0);">最良心的软件可以良心到什么程度？</a>
					</div>
				</div>
				<!-- right -->
				<div id="list_right">
					<div id="list_detail">
						<span>20</span> |<span>180</span>
					</div>
				</div>
				<div id="clear"></div>
			</div>
			<div class="userhome_content_list">
				<!-- left -->
				<div id="list_left">
					<div id="list_topic">
						<span>发布了主题</span>
						<a href="javascript:void(0);">最良心的软件可以良心到什么程度？</a>
					</div>
				</div>
				<!-- right -->
				<div id="list_right">
					<div id="list_detail">
						<span>20</span> |<span>180</span>
					</div>
				</div>
				<div id="clear"></div>
			</div>

			
			<!-- 分页 -->
			<div id="list_page_content">
				<div id="page_code">
					<a href="javascript:void(0);">1</a>
					<a href="javascript:void(0);">2</a>
					<a href="javascript:void(0);">3</a>
					<a href="javascript:void(0);">4</a>
					<a href="javascript:void(0);" id="nextPage">下一页</a>
				</div>
			</div>
		</div>
		
		<div id="userhome_content_right">
			
			<div id="right_notice_content">
				<span>公告</span><hr/>
				<ul>
					<li><a href="javascript:void(0);">如果有任何建议</a></li>
					<li><a href="javascript:void(0);">请联系 GXC </a></li>
					<li><a href="javascript:void(0);">QQ：757853223</a></li>
					<li><a href="javascript:void(0);">Tel：13563274342</a></li>
					<li><a href="javascript:void(0);">万分感谢 !</a></li>
				</ul>
			</div>
			
		</div>
	</div>
</body>
</html>