<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주소록</title>
</head>
<body>
	<table>
		<thead style="text-align: center; color: purple; font: bold;">
			<tr>
				<td>번호</td>
				<td>이름</td>
				<td>주소</td>
				<td>전화번호</td>
				<td>우편번호</td>
			</tr>
		</thead>
		<tbody style="text-align: center;">
			<c:forEach items="${listArr}" var="addr">
				<tr>
					<td style="color: red;">${addr.num}</td>
					<td style="color: orange;">${addr.name}</td>
					<td style="color: blue;">${addr.address}</td>
					<td style="color: yellow;">${addr.tel}</td>
					<td style="color: green;">${addr.zipcode}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>