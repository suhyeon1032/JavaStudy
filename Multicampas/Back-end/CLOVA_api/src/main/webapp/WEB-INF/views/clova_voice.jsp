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
		$("#speakerBtn").click(function(){
			
			// 비동기식 처리를 할 수 있는 객체
			let xhr = new XMLHttpRequest();
			
			// 응답받은 데이터의 데이터타입 설정
			xhr.responseType = 'blob'; //binary code(이진수)로 받아라
			// 서버에서 응답받으면 호출되는
			xhr.onload = function(){
				var audioURL = URL.createObjectURL(this.response);
				var audio = new Audio();
				audio.src = audioURL;
				audio.play();
			}
			
			// 서버에 접속하기
			//		전송방식 , 매핑주소
			xhr.open('post', '/voiceOk');	// 서버접속
			xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded'); // 헤드 정보
			xhr.send("text="+$("#text").val()); // 서버로 보낼 정보	text=보낼문자열
			
		});
	});
</script>

</head>
<body>

<h1>CLOVA VOICE</h1>
<textarea id="text" rows="20" cols="100"></textarea>
<input type='button' value='스피커' id='speakerBtn'/>
</body>
</html>