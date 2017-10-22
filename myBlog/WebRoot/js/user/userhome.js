$(function(){
	$("#userhome_top_pic").show(450, function(){
		
		//div数组
		var $list = $(".userhome_content_list");
		
		$("#userhome_main_head").show(400, function(){
			$list.each(function(i){
				$(this).slideDown(100);
			});
			$("#main_info").slideDown(300);
		});
	});

	
	$("#li_a_1").click(function(){
		$("#content_menu_bottom").css("margin-left",(1*32)-2+"px");
	});
	$("#li_a_2").click(function(){
		$("#content_menu_bottom").css("margin-left",(2*32)+(1*27)+"px");
	});
	$("#li_a_3").click(function(){
		$("#content_menu_bottom").css("margin-left",(3*32)+(2*27)+"px");
	});
});