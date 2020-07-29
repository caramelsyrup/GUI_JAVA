<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주소록예제</title>

</head>
<body>
<h1>주소록 상세보기</h1>
<a href="list.ad">주소록가기</a>

<form action="update.ad" method="post" name="enroll" id="enroll">
	<table>
		<tr>
			<th align="left">번호</th>
			<td><input type="text" name="num" size="1" value="${detail.num}"></td>
		</tr>
		<tr>
			<th align="left">이름</th>
			<td><input type="text" name="name" id="name" value="${detail.name}"></td>
		</tr>
		<tr>
			<th align="left">우편번호</th>
			<td>
				<input type="text" name="zipcode" id="zipCode" size="10" value="${detail.zipcode}">
				<input type="button" value="검색"	 onclick="zipFinder()">
			</td>
		</tr>
		<tr>
			<th align="left">주소</th>
			<td><input type="text" name="address" id="address" size="45" value="${detail.address}"></td>
		</tr>
		<tr>
			<th align="left">전화번호</th>
			<td><input type="text" name="tel" id="tel" value="${detail.tel}"></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="수정" id="btn" >
				<input type="button" value="삭제" onclick="location.href='delete.ad?num=${detail.num}'">
				<input type="reset" value="취소" >
			</td>
		</tr>
	</table>
</form>
</body>
</html>