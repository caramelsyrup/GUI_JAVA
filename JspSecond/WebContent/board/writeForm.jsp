<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글쓰기</title>
<style type="text/css">
	table tr td{
		border: 1px blue solid;
	}
</style>
</head>
<body>
	<form action="writePro.jsp" method="post">
		<table>
			<tr>
				<td>이름</td>
				<td><input type="text" name="writer" id="writer" size="10"></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="subject" id="subject" size="40"></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="email" name="email" id="email"> </td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="30px" cols="50px" name="content" id="content"></textarea> </td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="passwd" id="passwd" size="10"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="글쓰기">
					<input type="reset" value="취소">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>