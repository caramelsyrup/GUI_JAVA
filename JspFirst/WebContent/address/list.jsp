<%@page import="java.util.ArrayList"%>
<%@page import="com.address.Address"%>
<%@page import="com.address.AddressDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리스트화면</title>
<style>
	div.divCss{
	text-align: right;
	background-color: yellow;
	}
	a:hover {text-decoration: none;}
	a:link {text-decoration: none;}
	a:visited {text-decoration: none;}
</style>
<%
	AddressDAO dao = AddressDAO.getInstance();
	ArrayList<Address> address = dao.addressList();
%>
</head>
<body>
<div class="divCss">
	<a href="insert.jsp">추가하기</a>
</div>
<table border="1">
	<thead>
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>우편번호</th>
			<th>주소</th>
			<th>전화번호</th>
		</tr>
	</thead>
	<tbody>
<% 	
	for(int i=0; i<address.size();i++){
%>		
		<tr>
			<td><%=address.get(i).getNum()%></td>
			<td><a href="detail.jsp?num=<%=address.get(i).getNum() %>"><%=address.get(i).getName()%></a></td>
			<td><%=address.get(i).getZipcode()%></td>
			<td><%=address.get(i).getAddress()%></td>
			<td><%=address.get(i).getTel()%></td>
		</tr>
<%
	}
%>	
	</tbody>
</table>
</body>
</html>