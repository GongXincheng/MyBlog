$(function(){
	
	//登录之前判断session中是有user
	$.ajax({
		url : '${pageContext.request.contextPath}/User_hasLogin',
		data : {},
		type : 'POST',
		dataType : 'json',
		success: function(data){
			var hasLogind = eval("("+data+")");
			if(hasLogind.msg){
				//如果已经登录
				$("#img_user").hide();
				$("#ul_user").show(500);
			}
			else{
				$("#img_user").fadeIn(300);
			}
		},
		error : function(data){
			alert("服务器繁忙，请稍候...");
		}
	});
	
	
	
	
	
	/*登录的验证*/	
	//用户名
	$("#username").blur(function(){
		$("#msg_login").hide();
		var username = $(this).val();
		if(username.length==0){
			$("#msg_login").show(550);
			$("#login_span_msg").text("用户名不能为空");
			return;
		}
	});
	
	//密码
	$("#password").blur(function(){
		$("#msg_login").hide();
		var password = $(this).val();
		if(password.length==0){
			$("#msg_login").show(550);
			$("#login_span_msg").text("请输入密码");
			return false;
		}
	});

	//点击登录
	$("#btn_login").click(function(){
		
		var username = $("#username").val();
		var password = $("#password").val();
		var validate = $("#validate").val();
		
		if(username.length==0){
			$("#msg_login").show(550);
			$("#login_span_msg").text("用户名不能为空");
			return;
		}
		
		if(username.length>10 || username.length<5){
			$("#msg_login").show(550);
			$("#login_span_msg").text("用户名长度为5~10");
			return;
		}
		
		if(password.length==0){
			$("#msg_login").show(550);
			$("#login_span_msg").text("请输入密码");
			return false;
		}
		
		if(validate.length==0){
			$("#msg_login").show(550);
			$("#login_span_msg").text("请输入验证码");
			return false;
		}
		
		//跳转到LoginAction
		$.ajax({
			url : '${pageContext.request.contextPath}/User_login',
			data: {
				username : username,
				password : password,
				validate : validate
			},
			type: 'POST',
			dataType: 'json',
			
			success: function(date){
				var login = eval("("+date+")");
				
				if(login.msg=="success"){
					$("#login_regist_content").hide();
					$("#mask").hide();
					//刷新当前页面
					window.location.reload();
				}
				else{
					$("#msg_login").hide();
					if(login.msg=="error_validate"){
						//验证码错误
						$("#msg_login").show(550);
						$("#login_span_msg").text("验证码错误");
						$("#validate").val("");
						//更新验证码
						$("#login_captcha").attr("src","${pageContext.request.contextPath}/captchaAction?time"+new Date().getTime());
						return false;
					}
				}
			},
			
			error: function(date){
				alert("服务器繁忙，请稍候...");
			}
		});
		
	});
	
	
	
	//用户注销
	$("#userLeave").click(function(){
		$.ajax({
			url : '${pageContext.request.contextPath}/User_out',
			data : {},
			type : 'POST',
			dataType : 'json',
			success: function(data){
				var userLearve = eval("("+data+")");
				if(userLearve.msg){
					window.location.reload();
				}
			},
			error : function(data){
				alert("服务器繁忙，请稍候重试..");
			}
		});
	});
	
	
	$("input[type='text'],input[type='password']").focus(function(){
		$(this)[0].style.boxShadow = "0px 0px 8px #06C";
	})
	$("input[type='text'],input[type='password']").blur(function(){
		$(this)[0].style.boxShadow = "";
	})
	
	
	//注册验证
	$("#btn_regist").click(function(){
		$("#msg_regist").hide();
		var username = $("#form_regist #username").val();
		var password = $("#form_regist #password").val();
		
		if(username.length==0 || password.length==0){
			$("#msg_regist").show(550);
			$("#regist_span_msg").text("用户名或密码不能为空");
			return;
		}
	});
});