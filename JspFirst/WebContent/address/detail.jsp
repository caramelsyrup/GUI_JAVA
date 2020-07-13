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
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
<script type="text/javascript">
// 위에서 int num이 정의가 되어야 이용가능 메소드
 function del(){
	if(confirm("정말 삭제할까요?")){
		// true 확인
		// 위에서 num 변수에 저장된 값을 같이 넘기면서 페이지 이동.
		location.href="deletePro.jsp?num=<%=num%>";
	}
}
// 매개변수를 이용한 삭제 메소드
function dels(no){
	if(confirm("정말 삭제할까요?")){
		location.href="deletePro.jsp?num="+no;
	}
}

// jquery를 이용한 메소드
// DOM 순서, HTML에서 가장 최상단은 document이다. 순서가 document - html 순
// $(document).ready(function(){
	$(function(){	
	$("#deleteBtn").click(function(){
		if(confirm("정말 삭제할까요?")){
			$(location).attr("href","deletePro.jsp?num=<%=num%>");
		}
	});
});

function zipFinder(){
	window.open("zipCheck.jsp","","width=700 height=400");
}	
	
</script>
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
				<input type="text" name="zipcode" id="zipCode" size="10" value=<%=address.getZipcode() %>>
				<input type="button" value="검색" onclick="zipFinder()">
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
				<input type="button" value="삭제" onclick="del()">
				<input type="button" value="매개변수삭제" onclick="dels(<%=num%>)">
				<input type="button" value="jquery삭제" id="deleteBtn">
				<input type="reset" value="취소">
			</td>
		</tr>
	</table>
</form>
</body>
</html>