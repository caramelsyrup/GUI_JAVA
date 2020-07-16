<%@page import="com.member.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.member.MemberDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가입회원 보기</title>
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
<%
	request.setCharacterEncoding("UTF-8");
	MemberDAOImpl dao = MemberDAOImpl.getinstance();
	ArrayList<MemberVO> arr = null;
	arr = dao.memberList();
%>    
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" 
	  integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<script type="text/javascript">

function deleteUser(userID){
	String userID = 
	if(confirm("정말 삭제 하시겠습니까?")){
		location.href = "deletePro.jsp?userID="+userID;
	}
}

</script>
</head>
<body>
<h1>회원관리명단</h1>
<div>
	<a href="memberForm.jsp">회원가입하기</a>
</div>
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col">아이디</th>
					<th scope="col">이름</th>
					<th scope="col">전화번호</th>
					<th scope="col">이메일</th>
					<th scope="col">관리자여부</th>
					<th scope="col">삭제</th>
				</tr>
			</thead>
			<tbody>
<%
				for(MemberVO vo : arr){
					String mode = vo.getAdmin()==0?"일반회원":"관리자";
%>
				<tr>
					<td><a href="detail.jsp?userID=<%=vo.getUserID()%>"><%=vo.getUserID()%></a></td>
					<td><%=vo.getUserName() %></td>
					<td><%=vo.getUserTel() %></td>
					<td><%=vo.getUserEmail() %></td>
					<td><%=mode %></td>
					<td onclick="deleteUser()">삭제</td>
				</tr>			
<%
				}
%>		
			</tbody>
			<tfoot>
				<tr>
				
				</tr>
			</tfoot>
		</table>
</body>
</html>