$(function(){

	$("#G").show(1500);
	$("#X").show(200,function(){
		$("#D").show(400);
		$("#top_menu ul").show(400);
	});
	$("#C").show(1500);

	//判断是否已经登录
	$.ajax({
		url : '${pageContext.request.contextPath}/User_login_hasLogin',
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
		error : function(){
			/*alert("服务器繁忙，请稍候重试..");*/
		}
	});
	
	
	//用户退出
	$("#userLeave").click(function(){
		$.ajax({
			url : '${pageContext.request.contextPath}/User_login_out',
			data : {},
			type : 'POST',
			dataType : 'json',
			success: function(data){
				var userLearve = eval("("+data+")");
				if(userLearve.msg){
					location.href = "/myBlog/index.jsp";
				}
			},
			error : function(){
				
			}
		});
	});
	
	
	//显示右上角
	$("#ul_user").hover(function(){
		$("#ul_user li:not('#ul_user_fistli')").slideDown(300);
	},function(){
		$("#ul_user li:not('#ul_user_fistli')").slideUp(300);
	});
	
	
	//点击GXC图标,返回 main
	$(function(){
		$("#top_logo div").click(function(){
			location.href = "/myBlog/admin/main.jsp";
		})
	})
});