$(function(){
	
	var $board = $("#board_content");
	var winHight = $(window).height();
	var winWidth = $(window).width();
	var boardWidth = $board.width();
	
	$("#top_menu_board").click(function(){
		var boardLeft = (winWidth-boardWidth)/2;
		$("#mask").show();
		$board.css("left",boardLeft+"px").show(430);
	});
	
});