<%@page import="com.address.AddressDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import ="com.address.Address" %>
<%
	request.setCharacterEncoding("UTF-8");
	int num = Integer.parseInt(request.getParameter("num"));
	AddressDAO dao = AddressDAO.getInstance();
	Address add = dao.addressDetail(num);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
<script>
	function del(){
		if(confirm("정말 삭제할까요?")){
			location.href="deletePro.jsp?num=<%=num%>";
		}
	}
	
	function zipFinder(){
		window.open("zipCheck.jsp","width=800 height=400");
	}
</script>
</head>
<body>
	<h2>상세보기 & 수정하기</h2>
	<form action="updatePro.jsp" method="post" name="cfm">
		<input type="hidden" name="num" value="<%=num %>">
			<table>
				<tr>
					<th><label for="name">이름</label></th>
					<td><input type="text" name="name" id="name" size="8" value="<%=add.getName() %>"></td>
				</tr>
				<tr>
					<th><label for="zipcode">우편번호</label></th>
					<td>
						<input type="text" name="zipcode" id="zipcode" size="10" value="<%=add.getZipcode() %>">
						<input type="button" id="searchZip" value="검색" onclick="zipFinder()">
					</td>
				</tr>
				<tr>
					<th><label for="address">주소</label></th>
					<td><input type="text" name="address" id="address" size="40" value=<%=add.getAddress() %>></td>
				</tr>
				<tr>
					<th><label for="tel">전화번호</label></th>
					<td><input type="tel" name="tel" id="tel" size="15" value="<%=add.getTel() %>"></td>
				</tr>
				<tr>
					<td><input type="submit" value="수정"></td>
					<td><input type="button" value="삭제" onclick="del()"></td>
				</tr>
			</table>
	</form>		
</body>
</html>