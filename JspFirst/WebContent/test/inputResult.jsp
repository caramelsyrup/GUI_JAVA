<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자바스크립트 연습</title>
<%
	request.setCharacterEncoding("utf-8");
%>
<!-- StudentBean객체를 새로이 생성 -->
<jsp:useBean id="student" class="com.exam.StudentBean"/>
<jsp:setProperty property="*" name="student"/>
</head>
<body>
	이름 : <%=student.getName() %><br>
	학번 : <jsp:getProperty property="studentNum" name="student"/><br>
	성별 : <%=student.getGender() %><br>
	전공 : <%=student.getMajor() %><br>
	취미 : <%=student.hobby() %><br>
	
</body>
</html>