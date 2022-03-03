<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


</head>
<body>

<!-- input, select, textarea,  -->
<form method="get" action="formOk.jsp">
   이름 : <input type="text" name="username"/><br/>
   아이디 : <input type="text" name="userid"/><br/>
   비밀번호 : <input type="password" name="userpwd"/><br/>
   취미 : <input type="checkbox" name="hobby" value="축구"/>축구
      <input type="checkbox" name="hobby" value="야구"/>야구
      <input type="checkbox" name="hobby" value="농구"/>농구
      <input type="checkbox" name="hobby" value="배구"/>배구
      <input type="checkbox" name="hobby" value="탁구"/>탁구<br/>
      
   관심분야 : 
   <select name="interest" multiple>
      <option value="컴퓨터">컴퓨터</option>
      <option value="영화">영화</option>
      <option value="쇼핑">쇼핑</option>
      <option value="여행">여행</option>
      <option value="운동">운동</option>
   </select><br/>
   <input type="submit" value="등록"/>
</form>


</body>
</html>