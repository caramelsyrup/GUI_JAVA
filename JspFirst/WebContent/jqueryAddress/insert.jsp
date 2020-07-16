<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
th{
	text-align: right;
}
</style>
<script src="https://code.jquery.com/jquery-3.5.1.js" 
integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" 
crossorigin="anonymous"></script>
<script>
$(function(){
	$("#searchZip").click(function(){
		window.open("zipCheck.jsp","","width=800 height=600");
	});
});
</script>
</head>
<body>
	<form action="insertPro.jsp" name="cfm" method="post">
	<a href="list.jsp">전체 리스트 보기</a>
			<h2>주소록 등록하기</h2>
			<table>
				<tr>
					<th><label for="name">이름</label></th>
					<td><input type="text" name="name" id="name" size="8"></td>
				</tr>
				<tr>
					<th><label for="zipcode">우편번호</label></th>
					<td><input type="text" name="zipcode" id="zipcode" size="10"><input type="button" id="searchZip" value="검색"></td>
				</tr>
				<tr>
					<th><label for="address">주소</label></th>
					<td><input type="text" name="address" id="address" size="40"></td>
				</tr>
				<tr>
					<th><label for="tel">전화번호</label></th>
					<td><input type="tel" name="tel" id="tel" size="15"></td>
				</tr>
				<tr>
					<td><input type="submit" value="등록"></td>
					<td><input type="reset" value="취소"></td>
				</tr>
			</table>
	</form>
</body>
</html>