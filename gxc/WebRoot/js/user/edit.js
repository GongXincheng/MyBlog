$(function(){
	
	var $edit = $(".edit-content");
	var winHight = $(window).height();
	var winWidth = $(window).width();
	var editWidth = $edit.width();
	
	$("#btn_edit").click(function(){
		var editLeft = (winWidth-editWidth)/2;
		$("#mask").show();
		$edit.css("left",editLeft+"px").slideDown(330);
	});
	
	$("#province").change(function(){
		var provinceId = $(this).val();
		$("#city").html("<option value=''>--- 请选择 ---</option>");
		$.ajax({
			url : "${pageContext.request.contextPath}/cityAction_findAllCitiesByProvince?province.provinceId="+provinceId,
			data : {},
			type : "POST",
			dataType : "text",
			success : function(info){
				var data = eval("("+info+")");
				
				$.each(data,function(index, obj){
					$("#city").append("<option value='"+obj.cityId+"'>"+obj.cityName+"</option>");
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