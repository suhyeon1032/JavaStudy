<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 이전페이지에 있는 폼의 데이터를 서버로 가져오기 -->
<%
   //   post방식 전송일 때 request 객체에 한글을 utf-8로 세팅 후
   //            정보를 얻어온다.
   request.setCharacterEncoding("UTF-8");
   
   String username = request.getParameter("username");
   String userid = request.getParameter("userid");
   String userpwd = request.getParameter("userpwd");
   
   //   변수 1개에 여러개의 데이터 전송될 때는 배열로 전송을 한다.
   String hobby[] = request.getParameterValues("hobby");
   String interest[] = request.getParameterValues("interest");

   System.out.println("이름 = "+username);
   System.out.println("취미 = "+Arrays.toString(hobby));
   System.out.println("관심분야 = "+Arrays.toString(interest));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

username : <%=username %><br/>
userid : <%=userid %><br/>
userpwd : <%=userpwd %><br/>
hobby :
<%
   for(int i=0; i<hobby.length; i++){
%>
      <%=hobby[i] %>,
<%       
   }
%>
<br/>
interest : <%=Arrays.toString(interest) %>

<hr/>
<h1>request객체에 메소드</h1>
<ol>
   <%
      Enumeration<String> paramNames = request.getParameterNames();
      while(paramNames.hasMoreElements()){   //있으면 :true, 없으면 :false
   %>
         <li><%=paramNames.nextElement() %></li>
   <% 
      }
   %>
</ol>
<ul>
   <li> 접속자 컴퓨터의 ip : <%= request.getRemoteAddr() %></li>
   <li> 인코딩 코드 값 : <%= request.getCharacterEncoding() %></li>
   <li> contentType : <%=request.getContentType() %></li>
   <li> 전송방식 : <%=request.getMethod() %></li>
   <li> 프로토콜 : <%=request.getProtocol() %></li>
   <li> URI : <%=request.getRequestURI() %></li>
   <li> contextPath : <%=request.getContextPath() %></li>
   <li> serverName : <%=request.getServerName() %></li>
   <li> port : <%=request.getServerPort() %></li>
   <li> 절대주소 : <%=request.getServletContext().getRealPath("/") %></li>
</ul>

</body>
</html> 