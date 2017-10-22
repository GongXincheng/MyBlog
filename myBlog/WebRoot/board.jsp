<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>留言板</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>

<style type="text/css">
h2{
	
}
#board_content{
	width: 45%;
	margin: 40px auto;
	border: 2px solid #999;
	height:415px;
	padding: 20px;
}
/*标题*/
#board_title{
	width: 90%;
	margin: 20px auto; 
}
#board_title span{
	display:block;
	width: 100px;
	font-size: 20px;
	font-weight: 700;
	padding: 10px 0px;
}
#sgtTitle{
	width:95%;
	height:40px;
	padding-left: 10px;;
	margin: 0;
	display: block;
}

/*内容*/
#board_content_content{
	width:90%;
	margin: 20px auto; 
}
#board_content_content span{
	display:block;
	width: 100px;
	font-size: 20px;
	font-weight: 700;
	padding: 10px 0px;
}
#sgtContent{
	width:95%;
	height:150px;
	display: block;
	padding-left: 10px;
	padding-top: 10px;
	font-size: 15px;
	font-weight: 400;
	border: 1px solid #ccc;
}

/* Button */
#board_button{
	width:90%;
	margin: 20px auto; 
	margin-top: 30px;
}
button{
	width: 80px;
    height: 30px;
    font-size: 14px;
    line-height: 30px;
    text-align: center;
    cursor: pointer;
    background-color: #32a5e7;
    color: #fff;
    border-radius: 2px;
    border: none;
    display: inline;
    float: right;
    margin-top: 10px;
    margin-right: 10px;
}
#btn-reset{
	margin-right: 15px;
}
</style>

</head>
<body id="body_content">
	<jsp:include page="top.jsp"></jsp:include>
	<div id="content">
		<br><br><br><br>
		<h2 align="center">留下您的建议，才能离完美更近一步</h2><br><br>
		<h2 align="center">万分感谢</h2>
		
		<div id="board_content">
			<s:form>
				<div id="board_title">
					<span>标题</span>
					<s:textfield name="suggest" id="sgtTitle"></s:textfield>
				</div>
				<div id="board_content_content">
					<span>内容</span>
					<s:textarea name="sgtContent" id="sgtContent"></s:textarea>
				</div>
				<div id="board_button">
					<button type="button" id="btn-submit">提  交</button>
					<button type="reset" id="btn-reset">重  置</button>
				</div>
			</s:form>
		</div>
	</div>
</body>
</html>