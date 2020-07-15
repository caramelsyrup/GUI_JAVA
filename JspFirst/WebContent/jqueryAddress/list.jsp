<%@page import="com.address.AddressDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.address.Address"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" 
	  integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<%
	request.setCharacterEncoding("UTF-8");
	AddressDAO dao = AddressDAO.getInstance();
	ArrayList<Address> arr = null;
	String field="";
	String word="";
	if(request.getParameter(word)!=null){
		word = request.getParameter("word");
		field = request.getParameter("field");
	}
	arr = dao.addressList(field, word);
	int count = dao.getCount(field, word);
%>	  
<script type="text/javascript">
	function search(){
		if($("#word").val() == ""){
			alert("검색어를 입력하세요.");
			$("#word").focus();
			return false;
		}
		$("#searchfrm").submit();
	}
	
	function deleteAddress(num){
		if(confirm("정말로 삭제하시겠습니까?")){
			location.href="deletePro.jsp?num="+num;
		}
	}
	
</script>
<div>
	주소 보유 수 : <%=count %><br>
	<a href="insert.jsp">추가하기</a>
	<a href="list.jsp">전체보기</a>
</div>
</head>
<body>
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
<%
	for(int i=0; i<arr.size(); i++){
%>		
		<tbody>
			<tr>
				<td><%=arr.get(i).getNum() %></td>
				<td><a href="detail.jsp?num=<%=arr.get(i).getNum() %>"><%=arr.get(i).getName() %></a></td>
				<td><%=arr.get(i).getZipcode() %></td>
				<td><%=arr.get(i).getAddress() %></td>
				<td><%=arr.get(i).getTel() %></td>
				<td onclick="deleteAddress(<%=arr.get(i).getNum() %>)">삭제</td>
			</tr>
<%
	}
%>			
		</tbody>
		<tfoot>
			<tr>
				<form action="list.jsp" name="searchfrm" id="searchfrm">
					<td>
						<select name="field">
							<option value="name">이름</option>
							<option value="tel">전화번호</option>
						</select>
					</td>
					<td>
						<input type="text" name="word" id="word">
					</td>
					<td>
						<input type="button" value="검색" onclick="search()">
					</td>
				</form>
			</tr>
		</tfoot>
	</table>
</body>
</html>