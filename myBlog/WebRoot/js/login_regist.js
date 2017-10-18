$(function(){
	
	var $content = $("#login_regist_content");
	var $login = $("#login_content");
	var $regist = $("#regist_content");
	
	//获取屏幕高度和宽度
	var screenHeight = $(window).height();
	/*var screenWidth = $(window).width();*/
	
	//获取文档高度
	var docHeight = $(document).height();  //676
	var docWidth = $(document).width();	//1438

	//获取$Content的高度宽度
	/*var contentHeight = $content.height();*/
	var contentWidth = $content.width();

	//设置遮罩层的高度
	$("#mask").css("height",docHeight);
	
	//--------------- img Click ---------------
	$("#img_user").click(function(){
		//显示遮罩层		
		$("#mask").show();	
		//显示content
		$content.show(0);
		
		//设置位置
		/*var top = $("");*/
		var contentLeft = (docWidth-contentWidth)/2 +"px";
		/*var contentTop = (docWidth*0.15)+"px";*/
		$content.css({
			'top':'13%',
			'left':contentLeft
		});
		
		//显示登录界面
		$login.slideDown(350);
		//将登录变色
		$("#a_left").css("color","rgb(43, 49, 55)");
	})
	
	
	//--------------- Click Login ---------------------------
	$("#a_left").click(function(){
		$("#form_regist")[0].reset();
		if($("#msg_regist:visible")){
			$("#msg_regist").hide();
		}
		$("#a_right").css("color","#32a5e7");
		$regist.hide();
		$login.fadeIn(350);
		$("#a_left").css("color","rgb(43, 49, 55)");
	});
	
	//--------------- Click Regist  ----------------
	$("#a_right").click(function(){
		$("#form_login")[0].reset();
		if($("#msg_login:visible")){
			$("#msg_login").hide();
		}
		/*$("#form_login").each(function(){
			$(this).val("");
		});*/
		$("#a_left").css("color","#32a5e7");
		$login.hide();
		$regist.fadeIn(350);
		$("#a_right").css("color","rgb(43, 49, 55)");
	});
	
	
	
	//点击遮罩层取消
	$("#mask").click(function(){
		$content.slideUp(250);
		$("#form_login")[0].reset();
		$("#form_regist")[0].reset();
		$("#a_right").css("color","#32a5e7");
		$("#a_left").css("color","#32a5e7");
		$("#msg_login").hide();
		$regist.hide();
		$login.hide();
		$(this).hide();
	});
	
	//点击更换验证码
	$("#login_captcha").click(function(){
		$(this).attr("src","${pageContext.request.contextPath}/captchaAction?time"+new Date().getTime());
	});
	$("#regist_captcha").click(function(){
		$(this).attr("src","${pageContext.request.contextPath}/captchaAction?time"+new Date().getTime());
	});
});
