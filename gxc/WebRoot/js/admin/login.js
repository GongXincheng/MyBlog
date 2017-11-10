$(function(){
	
	/*-----------------------登录的验证------------------------*/	
	//用户名
	$("#username").change(function(){
		$("#msg_login").hide();
		var username = $(this).val();
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
	});
	
	//密码
	$("#password").change(function(){
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
		$("#msg_login").hide();
		var username = $("#username").val();
		var password = $("#password").val();
		var validate = $("#validate").val();
		
		//用户名
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
		
		//密码
		if(password.length==0){
			$("#msg_login").show(550);
			$("#login_span_msg").text("请输入密码");
			return false;
		}
		
		//验证码
		if(validate.length==0){
			$("#msg_login").show(550);
			$("#login_span_msg").text("请输入验证码");
			return false;
		}
		
		//跳转到LoginAction验证
		$.ajax({
			url : '${pageContext.request.contextPath}/User_login_login',
			data: {
				username : username,
				password : password,
				validate : validate
			},
			type: 'POST',
			dataType: 'json',
			
			success: function(data){
				var login = eval("("+data+")");
				
				if(login.msg=="success"){
					//修改成功后的图片和颜色
					$("#msg_login").css({
						"background-color":"rgb(238,255,245)",
						"border" : "1px solid #26C267"
					}).show(550);
					$("#login_error_img").attr("src","/myBlog/images/yes-green.png");
					$("#login_span_msg").text("登录成功");
					
					//定时器
					setTimeout(function() {
						//刷新当前页面
						location.href = "/myBlog/admin/main.jsp";
					}, 1500)
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
			error: function(){
				
			}
		});
	});
	
	
	//点击更换验证码
	$("#login_captcha").click(function(){
		$(this).attr("src","${pageContext.request.contextPath}/captchaAction?time"+new Date().getTime());
	});
	
	//文本框边框颜色
	$("#login_form input").focus(function(){
		$(this)[0].style.boxShadow = "0px 0px 8px #06C";
	})
	$("#login_form input").blur(function(){
		$(this)[0].style.boxShadow = "";
	})
	
	$("#content_main").show(400);
});