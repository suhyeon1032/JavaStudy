<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script>
		$(function(){
			$("h1").click(function(){
				location.href='/myapp/ajaxView';
			});
		});
	</script>
</head>
<body>
<h1>
	ajax (비동기식 통신) 페이지로 이동하기
</h1>

</body>
</html>
