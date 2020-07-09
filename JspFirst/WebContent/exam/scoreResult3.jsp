
<%@page import="com.exam.ScoreBean3"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<%
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		int kor = Integer.parseInt((request.getParameter("kor")));
		int eng = Integer.parseInt((request.getParameter("eng")));
		int math = Integer.parseInt((request.getParameter("math")));
		ScoreBean3 sb3 = new ScoreBean3(name,kor,eng,math);

	%>
</head>
<body>
	<!-- testResult2.jsp -->
	<hr>
	이름 : <%=sb3.getName() %><br>
	국어 : <%=sb3.getKor() %><br>
	영어 : <%=sb3.getEng() %><br>
	수학 : <%=sb3.getMath() %><br>	
	총점 : <%=sb3.getTotal() %><br>
	평균 : <%=sb3.getAvg() %><br>
	학점 : <%=sb3.getGrade() %><br>
</body>
</html>