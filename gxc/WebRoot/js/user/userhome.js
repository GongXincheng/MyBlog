$(function(){
	$("#userhome_top_pic").show(450, function(){
		$("#userhome_main_head").show(400, function(){
			$(".userhome_content_list").each(function(i){
				$(this).slideDown(400,function(){
					$("#list_page_content").show();
				});
			});
			
			$("#main_info").slideDown(300);
		});
	});

	//主题
	$("#li_a_1").click(function(){
		$("#content_menu_bottom").css("margin-left",(1*32)-2+"px");
	});
	
	//回复
	$("#li_a_2").click(function(){
		$("#content_menu_bottom").css({
			"margin-left":(2*32)+(1*27)+"px"
		});
	});
	
	//留言
	$("#li_a_3").click(function(){
		$("#content_menu_bottom").css("margin-left",(3*32)+(2*27)+"px");
	});
});