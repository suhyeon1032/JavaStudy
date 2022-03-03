<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%!
	//드라이브 로딩
   public Connection getConnection(){
      Connection con = null;
      try{
         Class.forName("com.mysql.cj.jdbc.Driver");
         con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/demo","root","root1234");
      }catch(Exception e){
         System.out.println("error");
         e.printStackTrace();
      }
      return con;
   }
%>
<%
	//dept테이블의 deptno, dname을 선택한다.
	Connection conn = getConnection();
	String sql = "select deptno, dname from dept order by dname asc ";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	
	ResultSet rs = pstmt.executeQuery();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="<%=request.getContextPath()%>/j02_response_jdbc/empFormOk.jsp">
	사원번호 : <input type="text" name="empno"/><br/> 
	사원명 : <input type="text" name="ename"/><br/>
	부서코드 : 
		<select name="deptno">
			<%while(rs.next()){ %>
			<option value="<%=rs.getInt(1)%>"><%=rs.getString(2)%></option>
			<%} %>
		</select><br/>
	<input type="submit" value="사원등록"/><br/>
</form>
</body>
</html>
<%
	rs.close();
	pstmt.close();
	conn.close();
%>