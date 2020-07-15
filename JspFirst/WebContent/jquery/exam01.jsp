<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
request.setCharacterEncoding("UTF-8");
String id = request.getParameter("id");
String pwd = request.getParameter("pwd");

// 비동기 방식, 현재 페이지에서 로그인 정보가 띄워지고, 다른 페이지로 넘어가지 않음. jquery와 ajax을 이용

%>
</head>
<body>
<form action="exam01Result.jsp" method="post" name="cfm">
id : <input type="text" id="id" name="id"><br>
pwd : <input type="password" id="pwd" name="pwd"><br> 
<input type="submit" value="전송">
</form>

</body>
</html>