<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
	$(function(){
		$("#uploadForm").submit(function(){
			event.preventDefault();
			var url = "/cfrCelebrity";
			var data = new FormData($("#uploadForm")[0]);
			$.ajax({
				type : 'post',
				dataType : 'text',
				url : url,
				processData : false,
				contentType : false,
				data : data,
				success : function(result){
					$("#text").val(result);
				}
			});
		});
	});
</script>

</head>
<body>

<form method="post" id="uploadForm" enctype="multipart/form-data">
	이미지 선택 : <input type="file" name="image" id="image" />
	<button>확인</button>
</form>
<textarea id="text" rows="10" cols="100"></textarea>

</body>
</html>