$(function(){

	$("#G").show(1500);
	$("#X").show(200,function(){
		$("#D").show(400);
		$("#top_menu ul").show(400);
	});
	$("#C").show(1500);

	
	//用户退出
	$("#userLeave").click(function(){
		$.ajax({
			url : '/gxc/userAction_out',
			data : {},
			type : 'POST',
			dataType : 'text',
			success: function(data){
				var userLearve = eval("("+data+")");
				if(userLearve.msg){
					location.href = "/gxc/index.jsp";
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
			location.href = "/gxc/admin/main.jsp";
		})
	})
});