<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>접속자의 쿠키 확인하기</h1>
<%
	//클라이언트 쿠키 가져오기
	Cookie coo[] = request.getCookies();

	for(Cookie c : coo){
		%>
		<li><%=c.getName() %> : <%=c.getValue() %></li>
		<% 
	}
%>
</body>
</html>