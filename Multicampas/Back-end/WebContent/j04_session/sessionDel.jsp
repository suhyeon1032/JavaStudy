<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// session 삭제하기 -> 새로운 session이 할당됨
	
	session.invalidate(); // 지워짐
	
	response.sendRedirect("/webJSP/index.jsp");
%>
