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
	
	var flag = false;
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
		flag = true;
	});
	
	//密码
	$("#password").blur(function(){
		$("#msg_login").hide();
		var password = $(this).val();
		if(password.length==0){
			$("#msg_login").show(550);
			$("#login_span_msg").text("请输入密码");
			return;
		}
		flag = true;
	});
	
	//验证码
	$("#validate").change(function(){
		$("#msg_login").hide();
		
		var validate = $("#validate").val();
		if(validate.length==0){
			$("#msg_login").show(550);
			$("#login_span_msg").text("请输入验证码");
			return;
		}
		flag = true;
		$.ajax({
			url : '${pageContext.request.contextPath}/User_captcha',
			data: {
				validate : validate
			},
			type: 'POST',
			dataType: 'json',
			
			success: function(date){
				var vali = eval("("+date+")");
				if(vali.msg){
					//如果验证码正确
					falg = true;
					$("#login_span_msg").text("验证码正确");
				}
				else{
					flag = false;
					//验证码错误
					$("#msg_login").show(550);
					$("#login_span_msg").text("验证码错误");
					//更新验证码
					$("#login_captcha").attr("src","${pageContext.request.contextPath}/captchaAction?time"+new Date().getTime());
				}
			},
			
			error: function(){
				alert("服务器繁忙，请稍候...");
			}
		});
	});
	
	//点击登录
	$("#btn_login").click(function(){
		
		var username = $("#username").val();
		var password = $("#password").val();
		var validate = $("#validate").val();
		
		//跳转到LoginAction
		if(falg){
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
						
						alert("登录失败");
					}
				},
				
				error: function(date){
					alert("服务器繁忙，请稍候...");
				}
			});
		}
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