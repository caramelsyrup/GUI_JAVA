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
	<h2>${count} 개입니다.</h2>
	<table>
		<tr>
			<th>이름</th>
			<th>우편번호</th>
			<th>주소</th>
			<th>전화번호</th>
		</tr>
		<c:forEach items="${arr}" var="a">
		<input type="hidden" value="${a.num}" name="num"/>
		<tr>
			<td>
				${a.name}
			</td>
			<td>
				${a.zipcode}
			</td>
			<td>
				${a.address}
			</td>
			<td>
				${a.tel}
			</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>