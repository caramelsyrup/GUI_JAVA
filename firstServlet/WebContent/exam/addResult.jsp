<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%

request.setCharacterEncoding("UTF-8");
int num1 = Integer.parseInt(request.getParameter("num1"));
int num2 = Integer.parseInt(request.getParameter("num2"));

%>
<script type="text/javascript">


</script>
</head>
<body>
	덧셈 결과 값 : <%=num1+num2 %>
</body>
</html>