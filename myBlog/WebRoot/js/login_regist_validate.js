$(function(){
	//登录之前判断session中是有user
	
	//登录的验证
	$("#btn_login").click(function(){
		$("#msg_login").hide();
		var flag = true;
		var username = $("#form_login #username").val();
		var password = $("#form_login #password").val();
		var validate = $("#form_login #validate").val();
		if(username.length==0 || password.length==0){
			$("#msg_login").show(550);
			$("#login_span_msg").text("用户名或密码不能为空");
			flag = false;
		}
		else if(validate.length==0){
			$("#msg_login").show(550);
			$("#login_span_msg").text("请输入验证码");
			flag = false;
		}
		
		//跳转到LoginAction
		var url = $("#form_login").attr("action");
		if(flag){
			$.ajax({
				url : url,
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
						$("#img_user").hide();
						$("#login_regist_content").hide();
						$("#mask").hide();
						$("#ul_user").show();
					}else{
						alert("登录失败");
					}
				},
				error: function(date){
					alert(date+"错误");
				}
			});
		}
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