$(function(){
	$("#userhome_top_pic").show(450, function(){
		$("#userhome_main_head").show(400, function(){
			$("#detail-top").show(600);
		});
	});
	
	
	//修改头像
	var hcWidth = $("#edit-head-content").width();
	var windWidth = $(document).width();
	var leftWidth = (windWidth - hcWidth)/2;
	
	//编辑头像，显示隐藏
	$("#userhome_main_head").hover(function(){
		var uid = $("#user-id").val();
		var sessionId = $("#session-id").val();
		if(sessionId!=uid){
			return false;
		}
		else{
			$("#head-mask").show(0,function(){
				$("#edit-head-content").css("left",leftWidth);
			});
		}
	},
	function(){
		$("#head-mask").hide();
	});
	
	//点击头像
	$("#head-mask").click(function(){
		$("#mask").show(0,function(){
			$("#edit-head-content").slideDown(300);
		});
	});
	
	//头像被选中
	$("#edit-head-list img").click(function(){
		//获取图片名称
		var picName = $(this).attr("alt");
		//获取用户id
		var uid = $("#user-id").val();
		$.ajax({
			url : "userAction_editHead",
			data : {
				face : picName,
				userId : uid
			},
			type : "POST",
			dataType : "text",
			success : function(data){
				location.href = "userAction_userDetail?userId="+uid;
			},
			error:function(){}
		});
	});
})