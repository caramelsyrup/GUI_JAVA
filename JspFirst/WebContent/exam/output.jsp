<%@page import="javax.swing.JOptionPane"%>
<%@page import="java.sql.Array"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생정보등록 확인</title>
</head>
<body>
	<h1>서버</h1>
	<%
		// 받아오는 정보가 깨지기 때문에, 해당 메서드를 통해서 인코딩
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		int num = Integer.parseInt(request.getParameter("studentNum"));
		String gender = request.getParameter("gender");
		String major = request.getParameter("major");

//		취미의 다중선택 출력.	
			String[] hobby = request.getParameterValues("hobby");
			String str ="";
			for(int i=0; i<hobby.length; i++){
				str+=hobby[i]+" ";
			}
	
		
	%>
	<hr>
	<table border="2">
		<caption>학생정보열람</caption>
		<colgroup>
			<col style="background-color: yellow;">		
			<col>
		</colgroup>
		<tr>
			<th>학번</th>
			<td><%=num%></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><%=name%></td>
		</tr>
		<tr>
			<th>성별</th>
			<td><%=gender%></td>
		</tr>
		<tr>
			<th>전공</th>
			<td><%=major%></td>
		</tr>
		<tr></tr>
	</table>
	이름 : <%=name%><br>
	학번 : <%=num%><br>
	성별 : <%=gender%><br>
	전공 : <%=major%><br>
	취미 : <%=str %><br>
	<hr>
	
</body>
</html>