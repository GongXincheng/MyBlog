$(function(){
	
	var $login = $("#login_content");
	var $regist = $("#regist_content");
	//获取屏幕高度和宽度
	var screenHeight = $(window).height();
	var screenWidth = $(window).width();
	
	//获取文档高度
	var docHeight = $(document).height();  //676
	var docWidth = $(document).width();	//1438

	//设置遮罩层的高度
	$("#mask").css("height",docHeight);
	
	//--------------------点击登录事件---------------------------
	$("#a_login,#a_left").click(function(){
		//显示遮罩层
		$("#mask").show();
		//隐藏注册界面
		$regist.hide();
		
		//获取login div 的宽度和高度 
		var loginHeight = $login.height();
		var loginWidth = $login.width();
		
		//设置位置
		var loginTop = (screenHeight-loginHeight)/2+"px";
		var loginLeft = (screenWidth-loginWidth)/2+"px";
		//显示login's div 
		$login.fadeIn(400).css({
			'top':loginTop,
			'left':loginLeft
		});
		$("#a_left").css("color","black");
		$("#a_right").css("color","#32a5e7");
	});
	
	//----------------点击注册事件----------------
	$("#a_regist,#a_right").click(function(){
		//显示遮罩层
		$("#mask").show();
		//隐藏登录界面
		$login.hide();
		
		
		var registHeight = $regist.height();
		var registWidth = $regist.width();
		
		//设置位置
		var registTop = (screenHeight-registHeight)/2+"px";
		var registLeft = (screenWidth-registWidth)/2+"px";
		
		$regist.fadeIn(400).css({
			'top':registTop,
			'left':registLeft
		});
		$("#a_left").css("color","#32a5e7");
		$("#a_right").css("color","black");
	});
	
	//点击遮罩层取消
	$("#mask").click(function(){
		$login.hide();
		$regist.hide();
		$(this).hide();
	});
	
});

//登录页面的验证
$(function(){
	$("#btn_login").click(function(){
		$("#msg_content").hide();
		var username = $("#username").val();
		var password = $("#password").val();
		var validate = $("#validate").val();
		if(username.length==0 || password.length==0){
			$("#msg_content").show(550);
			$("#span_msg").text("用户名或密码不能为空");
			return;
		}
		if(validate.length==0){
			$("#msg_content").show(550);
			$("#span_msg").text("请输入验证码");
			return;
		}
	});
	
	$("input[type='text'],input[type='password']").focus(function(){
		$(this)[0].style.boxShadow = "0px 0px 8px #06C";
	})
	$("input[type='text'],input[type='password']").blur(function(){
		$(this)[0].style.boxShadow = "";
	})
});