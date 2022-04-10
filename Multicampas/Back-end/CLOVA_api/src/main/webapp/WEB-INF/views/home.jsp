<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>AI Service API</h1>
	<ol>
		<li><a href="/cfrform">CFRecognition:얼굴감지</a></li>
		<li><a href="/cfrform2">CFRecognition:유명인감지</a></li>
		<li><a href="/voiceform">Voice:텍스트를 음성으로 변환</a></li>
		<li><a href="/speechform">Speech:입력된 언어와 음성 데이터를 CSR 서버로 전송하고 인식 결과를 텍스트로 반환</a></li>
		<li><a href="/sentimentform">Sentiment:텍스트에 담긴 감정(긍정/부정/중립)을 분석해주는 API </a></li>
		<li><a href="/summaryform">Summary:문장을 요약</a></li>
	</ol>
</body>
</html>