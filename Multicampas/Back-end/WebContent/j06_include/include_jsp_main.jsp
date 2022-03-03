<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css" type="text/css"/>

</head>
<body>

<!-- top.jsp 파일 include 하기 -->
<!-- 액션태그 -->
<jsp:include page="top.jsp"/>
<section>
<!-- 	//name //top.jsp의 데이터는 호환되지 않는다. -->
	<img src="../img/5.jpg"/>
</section>
<jsp:include page="footer.jsp"/>

</body>
</html>