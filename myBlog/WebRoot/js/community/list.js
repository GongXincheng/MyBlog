$(function(){
	//动画
	$("#cmt_left").slideDown(700);
	
	$("#h1-1").animate({
		left:"200px",
		opacity:0.5
	},400,function(){
		$("#h1-1").animate({
			left:"-50px",
			opacity:0.8
		},function(){
			$("#h1-1").animate({
				left:"0px",
				opacity:1
			},200);
		});
	});
	
	$("#h1-2").animate({
		left:"-200px",
		opacity:0.5
	},400,function(){
		$("#h1-2").animate({
			left:"50px",
			opacity:0.8
		},function(){
			$("#h1-2").animate({
				left:"0px",
				opacity:1
			},200);
		});
	});
	
	$("#cmt_right").animate({
		top: "50px",
		opacity:0.4
	},
	400,function(){
		$("#cmt_right").animate({
			top: "-30px",
			opacity:0.9
		},
		400,function(){
			$("#cmt_right").animate({
				top: 0,
				opacity:1
			},
			400);
		});
	});
//---------------------------------------------	
	
	
});