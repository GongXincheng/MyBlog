$(function(){
	$("#G").show(1500);
	$("#X").show(200,function(){
		$("#top_menu ul").show(400);
	});
	$("#C").show(1500);
	
	//top'login hide&show
	$("#ul_login li:not('#li_first')").hide();
	$("#ul_login").mouseenter(function(){
		$("#ul_login li:not('#li_first')").slideDown(300);
	});
	$("#ul_login").mouseleave(function(){
		$("#ul_login li:not('#li_first')").slideUp(300);
	});
	
});