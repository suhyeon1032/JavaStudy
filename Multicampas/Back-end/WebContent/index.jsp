<!-- 지시부 : 페이지 상단표시 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Calendar, java.util.Scanner" %>
<%@ page import="java.io.BufferedReader" %>
<!-- jsp코드가 있던 곳은 sapce가 존재하기 때문에 space를 없앨 수 있다. -->
<%@ page trimDirectiveWhitespaces="true" %>
<%!
	// 선언부 : 변수 또는 메소드
	/*  
	
	*/
	String username="홍길동";
	public String gugudan(int dan){
		String r = "";
		for(int i=2; i<10; i++){
			r += dan+" * " + i + " = " + (dan*i) + "<br/>";
		}
		return r;
	}

%>
<!DOCTYPE html>
<html>
<head>
<link rel="shortcut icon" href="#">
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	h1{color:blue;}
</style>
<script type="text/javascript">
	document.write("자바스크립트 출력한 문자");
</script>
</head>
<body>
<h1>홈페이지</h1>
<ul>
	<li>
		<!-- session객체의 userid변수에 값이 있으면 로그인 상태
						userid변수에 값("", null)이 없으면 로그아웃상태로 처리
		 -->
		 <%if(session.getAttribute("userid") != null && !session.getAttribute("userid").equals("")){ %>
		 	<a href="/webJSP/j04_session/sessionDel.jsp">로그아웃</a>
		 <%}else{ %>
		 	<a href="/webJSP/j04_session/sessionSave.jsp">로그인</a>
		 <%} %>
	</li>
	<li><a href="<%=request.getContextPath()%>/j02_response_jdbc/empForm.jsp">사원등록</a></li>
</ul>
<%
	// 스크립트 릿
	// 변수선언
	// 계산
	// 객체생성
	int num = 2000;
	String tel = "010-1234-5678";
	
	// 내장객체 : request, response, session, out, application, 
	// out 내장객체 : client에게 보내기
	out.println("이름="+username);
	out.print("<br/>번호="+num);
	out.print("<br/>연락처="+tel);
%>
<br/><img src="img/05.jpg" width="100px;"/><br>
<hr>
이름=<%=username+"님"%>님<br/>
번호=<%=num+100 %><br/>
연락처=<%=tel %><br/>
<%
	out.print(gugudan(5));

	System.out.println(gugudan(8));
%>
<%=gugudan(7) %>

<%
	Calendar now = Calendar.getInstance();
	out.println("<p>"+now+"</p>");
%>
<ul>
	<%
	for(int i=1; i<10; i++){
		out.println("<li>"+i+"</li>");
	}
%>
</ul>
<ul>
	<%
	for(int i=1; i<10; i++){
		%>
			<li><%= i %></li>
		<%
	}
%>
</ul>

</body>
</html>