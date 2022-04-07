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
		$("#uploadForm").submit(function(){
			event.preventDefault();
			
			const file = $("#mp3file")[0];
			
			if(file.files.length===0){
				alert("mp3파일을 선택하세요");
				return;
			}
			
			var form = $("#uploadForm")[0];
			var formData = new FormData(form);
			$.ajax({
				type : 'post',
				dataType : 'text',
				url :"/speechRecOk",
				processData : false,
				contentType : false,
				data : formData,
				success : function(result){
					var jData = JSON.parse(result);
					$("#text").val(jData.text);
				}
			});
		});
	});
</script>

</head>
<body>

<form method="post" id="uploadForm" enctype="multipart/form-data">
	언어 선택 : <select name='language'>
				<option value="Kor">한국어</option>
				<option value="Eng">영어</option>
				<option value="Jpn">일본어</option>
				<option value="Chn">중국어</option>
			 </select><br/>
	mp3 파일 선택 : <input type="file" name="mp3file" id="mp3file" />
	<button>확인</button>
</form>
<textarea id="text" rows="10" cols="100"></textarea>

</body>
</html>