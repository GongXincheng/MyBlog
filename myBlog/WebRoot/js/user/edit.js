$(function(){
	
	var $edit = $(".edit-content");
	var winHight = $(window).height();
	var winWidth = $(window).width();
	var editWidth = $edit.width();
	
	$("#btn_edit").click(function(){
		var editLeft = (winWidth-editWidth)/2;
		$("#mask").show();
		$edit.css("left",editLeft+"px").slideDown(330,function(){
			$.ajax({
				url : "${pageContext.request.contextPath}/User_getAllProvince",
				data : {},
				type : "POST",
				dataType : "json",
				success : function(info){
					var data = eval("("+info+")");
					//获取用户原本的province
					var proCode = $("#province").attr("class");
					//清空省市
					$("#province").empty();
					//添加省份项
					$.each(data,function(index, pro){
						if(proCode==pro.provinceid)
							$("#province").append("<option value='"+pro.provinceid+"' selected='selected'>"+pro.province+"</option>");
						else
							$("#province").append("<option value='"+pro.provinceid+"'>"+pro.province+"</option>");
					})
				},
				error : function(){}
			});
		});
	});
	
	$("#province").change(function(){
		//清空城市选项
		$("#city").empty();
		var proCode = $(this).val();
		$.ajax({
			url : "${pageContext.request.contextPath}/User_getCity",
			data : {
				proCode : proCode
			},
			type : "POST",
			dataType : "json",
			success : function(info){
				var data = eval("("+info+")");
				var cityCode = $("#city").attr("class");
				$.each(data, function(index, cit){
					if(cit.city == cityCode)
						$("#city").append("<option value='"+cit.cityid+"' selected='selected'>"+cit.city+"</option>")
					else
						$("#city").append("<option value='"+cit.cityid+"'>"+cit.city+"</option>")
				});
			},
			error:function(){}
		});
	});
	
	
	//关闭
	$("#edit_close,#edit-content-top img").click(function(){
		$(".edit-content").slideUp(250);
		$("#mask").hide();
	});
	$("#edit-content-top img").hover(function(){
		$(this).attr("src","/myBlog/images/close_red_18.png");
	},function(){
		$(this).attr("src","/myBlog/images/close_18x18.png");
	});
})