$(function(){
	$("#G").animate({
		left:'0px',
		opacity : 1
	},
	250,function(){
		$("#X").animate({
			left:'0px',
			opacity : 1
		},
		250,function(){
			$("#C").animate({
				left:'0px',
				opacity : 1
			},
			250,function(){
			});	
		});	
	});	
	
	//点击遮罩层取消
	$("#mask").click(function(){
		//登陆注册div 
		$("#login_regist_content").slideUp(250);
		//留言板div
		$("#board_wrap").slideUp(250);
		//修改信息
		$(".edit-content").slideUp(250);
		//修改头像
		$("#edit-head-content").hide();
		//发帖
		$("#sendTopic-wrap").slideUp(250);
		
		//清空登录，注册，留言内容
		$("#form_login")[0].reset();
		$("#form_regist")[0].reset();
		$("#form_board")[0].reset();
		
		$("#a_right").css("color","#32a5e7");
		$("#a_left").css("color","#32a5e7");
		$("#msg_login").hide();
		$("#regist_content");
		$("#login_content").hide();
		$(this).hide();
	});
	
	
	$("#ul_user").hover(function(){
		$("#ul_user li:not('#ul_user_fistli')").slideDown(300);
	},function(){
		$("#ul_user li:not('#ul_user_fistli')").slideUp(300);
	});
	
});