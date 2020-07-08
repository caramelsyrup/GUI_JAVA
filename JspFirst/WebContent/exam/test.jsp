<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예제</title>
</head>
<body>
	form태그로 testResult.jsp로 넘어간다.<br>
	<form action="testResult.jsp">
		input 태그로 text를 입력 받을 수 있도록 하고, <br>
		name을 설정해서 해당 text가 다음 페이지에서 받도록.<br>	
		Name : <input type="text" name="name"><br>
		Address : <input type="text"  name="addr"><br>
		input 태그로 전송할 수 있는 화면을 만든다.<br>
		<input type="submit" value="전송">
	</form>
</body>
</html>