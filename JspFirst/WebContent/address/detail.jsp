<%@page import="com.address.AddressDAO"%>
<%@page import="com.address.Address" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정하기</title>
<%
	request.setCharacterEncoding("UTF-8");
	int num = Integer.parseInt(request.getParameter("num"));
	AddressDAO dao = AddressDAO.getInstance();
	Address address = dao.addressDetail(num);
%>
</head>
<body>
	<h1>상세보기&수정하기</h1>
<a href="list.jsp">주소록가기</a>
<!-- insertPro.jsp에서 DB에 값을 저장 할 수 있도록 유도 -->
<form action="updatePro.jsp" method="post" name="update" id="update">
<input type="hidden" name="num" value=<%=num %>>
	<table>
		<tr>
			<th align="left">이름</th>
			<td><input type="text" name="name" id="name" value=<%=address.getName() %>></td>
		</tr>
		<tr>
			<th align="left">우편번호</th>
			<td>
				<input type="text" name="zipcode" id="zipCode" size="10" value=<%=address.getZipcode() %>><button>검색</button>
			</td>
		</tr>
		<tr>
			<th align="left">주소</th>
			<td><input type="text" name="address" id="address" size="40" value=<%=address.getAddress() %>></td>
		</tr>
		<tr>
			<th align="left">전화번호</th>
			<td><input type="text" name="tel" id="tel" value=<%=address.getTel() %>></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="수정" id="btn" >
				<input type="button" value="삭제">
				<input type="reset" value="취소">
			</td>
		</tr>
	</table>
</form>
</body>
</html>