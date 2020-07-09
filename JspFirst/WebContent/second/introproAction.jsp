<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정보 받아서 출력</title>
<%
	request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("name");
	String[] program = request.getParameterValues("PROGRAM");
	String prgstr = "";
	for(int i=0; i<program.length; i++){
		prgstr += program[i]+" ";
	}
	
	String place[]	= request.getParameterValues("place");
	String plastr="";
	for(int i=0; i<place.length; i++){
		plastr += place[i]+" ";
	}
	
%>
</head>
<body>
성명 : <%=name %><br>
성별 : <%=request.getParameter("gender") %><br>
생일 : <%=request.getParameter("year") %>-
	  <%=request.getParameter("month") %>-
	  <%=request.getParameter("day") %>-
	  <%=request.getParameter("calendar") %><br>
주소 : <%=request.getParameter("address") %><br>
전화번호 : <%=request.getParameter("phoneNumber1") %>-
		<%=request.getParameter("phoneNumber2") %>-
		<%=request.getParameter("phoneNumber3") %><br>
프로그램 : <%=prgstr %><br>
여행지 : <%=plastr %><br>
메모 : <%=request.getParameter("memo") %><br>

</body>
</html>