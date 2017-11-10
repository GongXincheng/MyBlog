$(function(){
	
	var $board = $("#board_wrap");
	var winHight = $(window).height();
	var winWidth = $(window).width();
	var boardWidth = $board.width();
	
	$("#top_menu_board").click(function(){
		var boardLeft = (winWidth-boardWidth)/2;
		$("#mask").show();
		$board.css("left",boardLeft+"px").slideDown(330);
		$("#board-submit").text("提交");
		$("#form_board")[0].reset();
	});
	
	$("#board-submit").click(function(){
		var uid = $("#form_board input[type='hidden']").val();
		var username = $("#boardUsername").val().trim();
		var email = $("#boardEmail").val().trim();
		var title = $("#boardTitle").val().trim();
		var message = $("#boardMessage").val().trim();
		
		if(title.length==0){
			if(confirm(" 标题不能为空 ")){
				$("#boardTitle").focus();
				return false;
			}
		}
		if(message.length==0){
			if(confirm(" 内容不能为空 ")){
				$("#boardMessage").focus();
				return false;
			}
		}
		
		$.ajax({
			url : '${pageContext.request.contextPath}/Board_saveBoard',
			data : {
				uid : uid,
				username : username,
				email : email,
				msgTitle : title,
				message : message
			},
			type : "POST",
			dataType : "json",
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