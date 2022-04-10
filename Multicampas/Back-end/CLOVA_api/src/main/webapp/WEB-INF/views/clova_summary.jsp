<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
	$(function(){
		$("#btn").click(function(){
			if($("#title").val()=='' || $("#content").val()==''){
				alert("제목, 글내용을 입력했는지 확인하세요");
				return;
			}
			
			$.ajax({
				type : 'post',
				dataType : 'text',
				url : '/summaryOk',
				data : {
					title : $("#title").val(),
					content : $("#content").val()
				},
				success : function(result){
					$("#resultView").append(result+"<br/>");
				}
			});
		});
	});
</script>

</head>
<body>

제목 : <input type="text" name="title" size="100" id="title"/><br/>
내용 : <textarea name="content" rows="20" cols="100" id="content"></textarea><br/>
<input type="button" id="btn" value="문장요약하기"/>
<div id="resultView"></div>

</body>
</html>