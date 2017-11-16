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
			500,function(){
				$("#div-btn-sendTopic").show(320,function(){
					$("#div-btn-signIn").show(320);
				});
			});
		});
	});
//---------------------------------------------	
	//点击发帖按钮
	$("#btn-sendTopic").click(function(){
		//未登录?
		var flag = $("#img_user").is(":visible");
		if(flag){
			$("#img_user").click();
		}
		//已登录
		else{
			var windowWidth = $(window).width();
			var sendTWidth = $("#sendTopic-wrap").width();
			var leftSend = (windowWidth-sendTWidth)/2;
			
			$("#mask").show(0,function(){
				$("#sendTopic-wrap").css("left",leftSend).slideDown(365);
			});
		}
	});
	
	//点击回复按钮
	$("#a-sendReply,#a-sendReply2").click(function(){
		//未登录?
		var flag = $("#img_user").is(":visible");
		if(flag){
			$("#img_user").click();
		}
		//已登录
		else{
			var windowWidth = $(window).width();
			var windowHeight = $(window).height();
			var sendTWidth = $("#sendReply-wrap").width();
			var sendTHeight = $("#sendReply-wrap").height();
			var leftSend = (windowWidth-sendTWidth)/2;
			var topSend = (windowHeight-sendTHeight)/2;
			
			$("#mask").show(0,function(){
				$("#sendReply-wrap").css({
					"left":leftSend+"px"
				}).slideDown(365);
			});
		}
	});
	
	
	//点击发表
	$("#btn-send").click(function(){
		var title = $("#title").val();
		var content = $("#topicContent").val();
		
		if(title.length==0){
			if(confirm(" 标题不能为空 ")){
				$("#title").focus();
				return false;
			}
			$("#title").focus();
			return false;
		}
		if(title.length>80){
			if(confirm(" 标题长度不能超过80 ")){
				$("#title").focus();
				return false;
			}
			$("#title").focus();
			return false;
		}
		if(content.length==0){
			if(confirm(" 内容不能为空 ")){
				$("#topicContent").focus();
				return false;
			}
			$("#topicContent").focus();
			return false;
		}
		if(content.length>250){
			if(confirm(" 内容长度不能超过250 ")){
				$("#topicContent").focus();
				return false;
			}
			$("#topicContent").focus();
			return false;
		}
		
		$("#form_sendTopic")[0].submit();
	});
	//点击回复
	$("#btn-send-reply").click(function(){
		
		var content = $("#replyContent").val();
		
		if(content.length==0){
			if(confirm(" 内容不能为空 ")){
				$("#topicContent").focus();
				return false;
			}
			$("#topicContent").focus();
			return false;
		}
		if(content.length>250){
			if(confirm(" 内容长度不能超过250 ")){
				$("#topicContent").focus();
				return false;
			}
			$("#topicContent").focus();
			return false;
		}
		
		
		$("#form_sendReply")[0].submit();
	});
	
	
	//点击签到
	$("#div-btn-signIn").click(function(){
		alert("功能暂未完成,敬请期待!");
	});
	
	
	//回车搜索
	/*$("").focus(function(){*/
	$('#topicSearch').keypress(function(event){  
	    var keycode = (event.keyCode ? event.keyCode : event.which);  
	    if(keycode == '13'){  
	        alert('功能暂未完成,敬请期待!');    
	    }  
	}); 
	
});