<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>session 데이터 저장하기</h1>
<p>할당된 sessionId : <%=session.getId() %></p>
<%
	//session 내장객체
	//					변수명, 데이터
	session.setAttribute("userid","daram");
	session.setAttribute("username", "다람");
	session.setAttribute("grade", "A");
%>
<a href="sessionView.jsp">세션값 확인하기</a>
</body>
</html>