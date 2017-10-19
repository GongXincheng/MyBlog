$(function(){
	$("#G").show(1500);
	$("#X").show(200,function(){
		$("#top_menu ul").show(400);
	});
	$("#C").show(1500);
	
	$("#ul_user").hover(function(){
		$("#ul_user li:not('#ul_user_fistli')").slideDown(300);
	},function(){
		$("#ul_user li:not('#ul_user_fistli')").slideUp(300);
	});
	
	
});