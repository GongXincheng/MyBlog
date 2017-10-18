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
				$("#ul_user").show();
			}
		},
		error : function(data){
			alert("服务器繁忙，请稍候...");
		}
	});
	
	var flag = false;
	//登录的验证
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
		
		alert(41+":"+flag);
		
		//跳转到LoginAction
		if(true){
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
					}else{
						alert("登录失败");
					}
				},
				
				error: function(date){
					alert("服务器繁忙，请稍候...");
				}
			});
		}
	});
	
	$("#validate").change(function(){
		$.ajax({
			url : '${pageContext.request.contextPath}/User_captcha',
			data: {
				validate : validate
			},
			type: 'POST',
			dataType: 'json',
			
			success: function(date){
				var vali = eval("("+date+")");
				alert(vali.msg+"86");
				if(vali.msg){
					//如果验证码正确
					falg = true;
				}
				else{
					flag = false;
					//验证码错误
					$("#msg_login").show(550);
					$("#login_span_msg").text("验证码错误");
				}
			},
			
			error: function(){
				alert("服务器繁忙，请稍候...");
			}
		});
	});
	
	
	
	/*//判断验证码
	$("#validate").change(function(){
		$("#msg_login").hide();
		var validate = $("#form_login #validate").val();
		$.ajax({
			url : '${pageContext.request.contextPath}/User_captcha',
			data : {
				validate : validate
			},
			type : 'POST',
			dataType : 'json',
			success: function(data){
				var captcha = eval("("+data+")");
				if(!captcha.msg){
					$("#msg_login").show(550);
					$("#login_span_msg").text("验证码错误");
					flag = false;
				}
			},
			error : function(data){
				alert("服务器繁忙，请稍候重试..");
			}
		});
	});*/
	
	
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