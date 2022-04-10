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
		$("#senti").click(function(){
			if($("#content").val() == ''){
				alert("글을 입력하세요");
				return;
			}
			var url = '/sentimentOk';
			$.ajax({
				type : 'post',
				dataType : 'text',
				url : url,
				data : {
					content : $("#content").val()
				},
				success : function(result){
					///////////////////////////////
					$("#sentimentResult").append(result+"<br/>");
				},error : function(e){
					console.log(e.responseText);
				}
				
			});
		});
	});
</script>

</head>
<body>

<textarea rows="10" cols="100" id="content"></textarea>
<button id="senti">감정평가(neutral:중립, positive:긍정, negative:부정)</button>
<div id='sentimentResult' style='background-color:#ddd;'></div>

</body>
</html>