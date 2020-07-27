<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>구구단</h1>
<table>
	<c:forEach begin="1" end="9" var="e">
		<c:forEach begin="1" end="9" var="d">
			<tbody>
				<tr>
					<td>${e} * ${d} = &nbsp; ${e*d}</td>
				</tr>
			</tbody>
		</c:forEach>
	</c:forEach>
</table>
</body>
</html>