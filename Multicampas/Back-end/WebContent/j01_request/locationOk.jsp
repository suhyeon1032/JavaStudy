<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String pageNum = request.getParameter("pageNum");
	String searchWord = request.getParameter("searchWord");
	
	System.out.println("페이지번호 ->"+ pageNum);
	System.out.println("검색어 ->"+ searchWord);
%>

페이지 번호 = <%=pageNum%><br>
검색어 = <%=searchWord%><br>