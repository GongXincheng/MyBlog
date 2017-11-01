$(function(){
	
	/*window.moveTo(0, 0);//移动窗口   
	window.onresize=new Function("window.resizeTo(1500,1300);");
	window.resizeTo(2000, 600);//改变大小   */	
	
	/*$("#G").show(1500);
	$("#X").show(200,function(){
		$("#top_menu ul").show(400);
	});
	$("#C").show(1500);*/
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
	
	$("#ul_user").hover(function(){
		$("#ul_user li:not('#ul_user_fistli')").slideDown(300);
	},function(){
		$("#ul_user li:not('#ul_user_fistli')").slideUp(300);
	});
	
});