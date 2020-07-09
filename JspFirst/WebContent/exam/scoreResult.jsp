<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>SERVER</h1>
	%를 이용해서 java 문법을 구현할 수 있도록 한다.<br>
	request내장 객체의 getParameter를 이용해서 <br>
	test.jsp의 설정된 name의 값들을 받아서 변수에 저장.<br>
	출력한다<br>
	<%
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		String kor	= request.getParameter("kor");
		String eng	= request.getParameter("eng");
		String math = request.getParameter("math");
		int korScore = Integer.parseInt(request.getParameter("kor"));
		int engScore = Integer.parseInt(request.getParameter("eng"));
		int mathScore = Integer.parseInt(request.getParameter("math"));
		int totalScore = (korScore+engScore+mathScore);
		int avgScore = totalScore/3;
		String grade ="";
	%>
	결과<br>	
	이름 : <% out.println(name); %> <br>
	주소 : <% out.println(addr); %> <br>
	<hr>
	이름 : <%=name %><br>
	국어 : <%=kor %><br>
	영어 : <%=eng %><br>
	수학 : <%=math %><br>	
	총점 : <%=totalScore %><br>
	평균 : <%=avgScore %><br>
	학점 : <%
	/*		
			if(avgScore>=90) {out.print("A학점");}
			else if(avgScore>=80) {out.print("B학점");}
			else if(avgScore>=70){out.print("C학점");}
		    else{out.print("F학점");}
	*/
			switch(avgScore/10){
			case 10:
			case 9:	grade ="A"; break;
			case 8:	grade ="B"; break;
			case 7:	grade ="C"; break;
			default : grade ="F";
			}
			out.print(grade);
		  %>
</body>
</html>