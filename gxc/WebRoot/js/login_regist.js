$(function(){
	
	var $content = $("#login_regist_content");
	var $login = $("#login_content");
	var $regist = $("#regist_content");
	
	//获取文档高度
	var docWidth = $(document).width();	//1438
	
	//获取$Content的高度宽度
	var contentWidth = $content.width();

	//--------------- img Click ---------------
	$("#img_user").click(function(){
		//隐藏注册
		$regist.hide();
		
		//显示遮罩层		
		$("#mask").show();	
		
		//设置位置
		var contentLeft = (docWidth-contentWidth)/2 +"px";
		$content.css('left',contentLeft);
		
		//显示content
		$content.slideDown(100);
		
		//显示登录界面
		$login.slideDown(430);
		$("#a_left").css({
			"color":"#32a5e7",
			"font-size":"21px"
		});
		
		//将右边的变为黑色
		$("#a_right").css({
			"color":"rgb(37,42,48)",
			"font-size":"14px"
		});
		
	})
	
	
	//--------------- Click Login ---------------------------
	$("#a_left").click(function(){
		$("#form_regist")[0].reset();
		
		if($("#msg_regist:visible")){
			$("#msg_regist").hide();
		}
		
		//重新刷新验证码
		$("#login_captcha").attr("src","${pageContext.request.contextPath}/captchaAction?time="+new Date().getTime());
		
		//将被点击放大变色
		$("#a_left").css({
			"color":"#32a5e7",
			"font-size":"21px"
		});
		
		$regist.hide();
		$login.fadeIn(500);
		
		//另一边变色缩小
		$("#a_right").css({
			"color":"rgb(37,42,48)",
			"font-size":"14px"
		});
	});
	
	//--------------- Click Regist  ----------------
	$("#a_right").click(function(){
		$("#form_login")[0].reset();
		if($("#msg_login:visible")){
			$("#msg_login").hide();
		}
		//重新刷新验证码
		$("#regist_captcha").attr("src","${pageContext.request.contextPath}/captchaAction?time="+new Date().getTime());

		//将被点击放大变色
		$("#a_right").css({
			"color":"#32a5e7",
			"font-size":"21px"
		});
		//初始化错误显示
		$("#msg_regist").css({
			"background-color":"#ffd1ca",
			"border" : "1px solid pink"
		});
		$("#regist_error_img").attr("src","/gxc/images/error_16x16.png");
		
		$login.hide();
		$regist.fadeIn(500);
		
		//另一边变色缩小
		$("#a_left").css({
			"color":"rgb(37,42,48)",
			"font-size":"14px"
		});
	});
	
	
	//点击更换验证码
	$("#login_captcha").click(function(){
		$(this).attr("src","${pageContext.request.contextPath}/captchaAction?time="+new Date().getTime());
	});
	$("#regist_captcha").click(function(){
		$(this).attr("src","${pageContext.request.contextPath}/captchaAction?time="+new Date().getTime());
	});
	
	//文本框边框颜色
	$("#login_form input, #regist_form input").focus(function(){
		$(this)[0].style.boxShadow = "0px 0px 8px #06C";
	})
	$("#login_form input, #regist_form input").blur(function(){
		$(this)[0].style.boxShadow = "";
	})
});
