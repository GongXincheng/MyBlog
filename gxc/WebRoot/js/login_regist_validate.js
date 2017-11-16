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
			url : '${pageContext.request.contextPath}/userAction_login',
			data: {
				username : username,
				password : password,
				validate : validate
			},
			type: 'POST',
			dataType: 'text',
			
			success: function(data){
				var login = eval("("+data+")");
				/*alert(login.login_msg);*/
				if(login.login_msg=="success"){
					//修改成功后的图片和颜色
					$("#msg_login").css({
						"background-color":"rgb(238,255,245)",
						"border" : "1px solid #26C267"
					}).show(550);
					$("#login_error_img").attr("src","/gxc/images/yes-green.png");
					$("#login_span_msg").text("登录成功");
					
					//定时器
					setTimeout(function() {
						$("#login_regist_content").hide();
						$("#mask").hide();
						//刷新当前页面
						window.location.reload();
					}, 1500)
				}
				else{
					$("#msg_login").hide();
					
					//错误信息
					$("#msg_login").show(550);
					$("#login_span_msg").text(login.login_msg);
					$("#validate").val("");
					//更新验证码
					$("#login_captcha").attr("src","${pageContext.request.contextPath}/captchaAction?time="+new Date().getTime());
					return false;
					
				}
			},
			error: function(){
				
			}
		});
		
	});
		
	
	//------------- 注册验证 ------------------------------------
	
	/*用户名*/
	$("#form_regist #username").change(function(){
		$("#msg_regist").hide();
		
		var username = $(this).val().trim();
		
		if(username.length==0){
			$("#msg_regist").show(550);
			$("#regist_span_msg").text("用户名不能为空");
			return;
		}
		if(username.length>10 || username.length<3){
			$("#msg_regist").show(550);
			$("#regist_span_msg").text("用户名长度为3~10");
			return;
		}
		
		$.ajax({
			url : "${pageContext.request.contextPath}/userAction_hasUser",
			data : {
					username : username
			   	},
			type : "POST",
			dataType : "text",
			success : function(data){
				var info = eval("("+data+")");
				
				if(info.msg=="success"){ }
				else{
					$("#msg_regist").show(550);
					$("#regist_span_msg").text(info.msg);
				}
			},
			error:function(){
				
			}
		});
	});
	
	//密码
	$("#form_regist #password").change(function(){
		$("#msg_regist").hide();
		var password = $(this).val();
		if(password.length==0){
			$("#msg_regist").show(550);
			$("#regist_span_msg").text("密码不能为空");
			return;
		}
		if(password.length>16 || password.length<3){
			$("#msg_regist").show(550);
			$("#regist_span_msg").text("密码长度为3~16");
			return;
		}
	});
	
	//确认密码
	$("#form_regist #rePassword").blur(function(){
		$("#msg_regist").hide();
		var password = $("#form_regist #password").val();
		var rePassword = $(this).val();
		
		if(password!=rePassword){
			$("#msg_regist").show(550);
			$("#regist_span_msg").text("确认密码和密码不一致,请重新输入");
			return;
		}
	});
	
	//注册被点击
	$("#btn_regist").click(function(){
		$("#msg_regist").hide();
		var username = $("#form_regist #username").val().trim();
		var password = $("#form_regist #password").val();
		var rePassword = $("#form_regist #rePassword").val();
		var validate = $("#form_regist #validate").val().trim();
		
		//用户名
		if(username.length==0){
			$("#msg_regist").show(550);
			$("#regist_span_msg").text("用户名不能为空");
			return;
		}
		if(username.length>10 || username.length<3){
			$("#msg_regist").show(550);
			$("#regist_span_msg").text("用户名长度为3~10");
			return;
		}
		
		//密码
		if(password.length==0){
			$("#msg_regist").show(550);
			$("#regist_span_msg").text("密码不能为空");
			return;
		}
		if(password.length>16 || password.length<3){
			$("#msg_regist").show(550);
			$("#regist_span_msg").text("密码长度为3~16");
			return;
		}
		if(password!=rePassword){
			$("#msg_regist").show(550);
			$("#regist_span_msg").text("确认密码和密码不一致,请重新输入");
			return;
		}
		
		//验证码
		if(validate.length==0){
			$("#msg_regist").show(550);
			$("#regist_span_msg").text("请输入验证码");
			return;
		}
		
		$.ajax({
			url : "${pageContext.request.contextPath}/userAction_regist" ,
			data : {
				username : username,
				password : password,
				rePassword : rePassword,
				validate : validate
			},
			type : "POST",
			dataType : "text",
			success : function(data){
				var regist = eval("("+data+")");
				
				if(regist.msg=="success"){
					
					//修改注册成功的图片和颜色
					$("#msg_regist").css({
						"background-color":"rgb(238,255,245)",
						"border" : "1px solid #26C267"
					}).show(550);
					
					$("#regist_error_img").attr("src","/gxc/images/yes-green.png");
					$("#regist_span_msg").text("注册成功,3秒后跳转完善个人信息...");
					
					//计时器
					var num = 2;
					var regist_time = setInterval(function() {
						if(num>=1){
							$("#regist_span_msg").text("注册成功,"+num--+"秒后跳转完善个人信息...");
						}else{
							clearInterval(regist_time);
							/*$("#a_left").click();*/
							//注册成功后，跳转到个人信息页面完善个人信息
							location.href = "${pageContext.request.contextPath}/userAction_userDetail?userId="+regist.userId;
						}
					}, 1000);
				}
				else{
					$("#msg_regist").hide();
					//验证码错误
					$("#msg_regist").show(550);
					$("#regist_span_msg").text(regist.msg);
					$("#form_regist #validate").val("");
					//更新验证码
					$("#regist_captcha").attr("src","${pageContext.request.contextPath}/captchaAction?time="+new Date().getTime());
					return false;
				}
			},
			error : function(){
				
			}
		});
		
	});
});