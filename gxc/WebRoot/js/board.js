$(function(){
	
	var $board = $("#board_wrap");
	var winHight = $(window).height();
	var winWidth = $(window).width();
	var boardWidth = $board.width();
	
	//点击留言
	$("#top_menu_board").click(function(){
		var boardLeft = (winWidth-boardWidth)/2;
		//判断是否已经登录
		var flag = $("#img_user").is(":visible");
		
		//未登录
		if(flag){
			$("#img_user").click();
		}	
		else{
			$("#mask").show();
			$board.css("left",boardLeft+"px").slideDown(330);
			$("#board-submit").text("提交");
			$("#form_board")[0].reset();
		}
	});
	
	//提交建议
	$("#board-submit").click(function(){
		
		var userId = $("#form_board input[type='hidden']").val();
		var messageTitle = $("#boardTitle").val().trim();
		var messageContent = $("#boardMessage").val().trim();
		
		if(messageTitle.length==0){
			if(confirm(" 标题不能为空 ")){
				$("#boardTitle").focus();
				return false;
			}
		}
		if(messageContent.length==0){
			if(confirm(" 内容不能为空 ")){
				$("#boardMessage").focus();
				return false;
			}
		}
		
		$.ajax({
			url : 'messageAction_saveMessage?user.userId='+userId,
			data : {
				messageTitle : messageTitle,
				messageContent : messageContent
			},
			type : "POST",
			dataType : "text",
			success : function(info){
				var data = eval("("+info+")");
				if(data.msg=="success"){
					$("#board-submit").text("谢谢您的建议,已提交");
					setTimeout(function() {
						$("#board_wrap").slideUp(250);
						$("#mask").hide();
					}, 1000)
				}
				else{
					$("#board-submit").text(data.msg);
					setTimeout(function() {
						$("#board_wrap").slideUp(250);
						$("#mask").hide();
					}, 1000)
				}
			},
			error : function(){}
		});
		
	});
	
});