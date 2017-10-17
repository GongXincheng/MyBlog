$(function(){
	
	var $content = $("#login_regist_content");
	var $login = $("#login_content");
	var $regist = $("#regist_content");
	
	//获取屏幕高度和宽度
	var screenHeight = $(window).height();
	var screenWidth = $(window).width();
	
	//获取文档高度
	var docHeight = $(document).height();  //676
	/*var docWidth = $(document).width();	//1438*/

	//获取$Content的高度宽度
	/*var contentHeight = $content.height();*/
	var contentWidth = $content.width();

	//设置遮罩层的高度
	$("#mask").css("height",docHeight);
	
	$("#img_user").click(function(){
		//显示遮罩层		
		$("#mask").show();	
		//显示content
		$content.show(0);
		
		//设置位置
		var contentLeft = (screenWidth*0.6)+"px";
		var contentTop = (screenHeight*0.15)+"px";
		$content.css({
			'top':contentTop,
			'left':contentLeft
		});
		
		//显示登录界面
		$login.slideDown(350);
		//将登录变色
		$("#a_left").css("color","rgb(43, 49, 55)");
	})
	
	
	//--------------- click Login ---------------------------
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
	
	//--------------- click Regist  ----------------
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
		$regist.hide();
		$login.hide();
		$(this).hide();
	});
	
});


//登录的验证
$(function(){
	$("#btn_login").click(function(){
		$("#msg_login").hide();
		var username = $("#form_login #username").val();
		var password = $("#form_login #password").val();
		var validate = $("#form_login #validate").val();
		if(username.length==0 || password.length==0){
			$("#msg_login").show(550);
			$("#login_span_msg").text("用户名或密码不能为空");
			return;
		}
		if(validate.length==0){
			$("#msg_login").show(550);
			$("#login_span_msg").text("请输入验证码");
			return;
		}
	});
	
	$("input[type='text'],input[type='password']").focus(function(){
		$(this)[0].style.boxShadow = "0px 0px 8px #06C";
	})
	$("input[type='text'],input[type='password']").blur(function(){
		$(this)[0].style.boxShadow = "";
	})
	
	$("#btn_regist").click(function(){
		$("#msg_regist").hide();
		var username = $("#form_regist #username").val();
		if(username.length==0){
			$("#msg_regist").show(550);
			$("#regist_span_msg").text("用户名或密码不能为空");
			return;
		}
	});
});