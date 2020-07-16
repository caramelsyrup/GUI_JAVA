<%@page import="com.jqueryAddress.JAddressDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.jqueryAddress.Address"%>
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
	JAddressDAO dao = JAddressDAO.getInstance();
	String field="";
	String word="";
	ArrayList<Address> arr = dao.addressList();
	int count = dao.getCount();
%>	  
<script type="text/javascript">
// search 기능 메소드를 jquery 활용해서 할수 있도록. JSON 활용.
	$(document).ready(function(){
		$("#searchBtn").click(function(){
			$.getJSON("searchPro.jsp",{"field":$("#field").val(),"word":$("#word").val()},
					function(data){
						var htmlStr="";
						$.each(data,function(key,val){
							htmlStr+="<tr>";
							htmlStr+="<td>"+val.num+"</td>";
							htmlStr+="<td>"+val.name+"</td>";
							htmlStr+="<td>"+val.tel+"</td>";
							htmlStr+="<td>"+val.address+"</td>";
							htmlStr+="<td onclick=deleteAddress("+val.num+")>삭제</td>";
							htmlStr+="</tr>";
						})	// each	
						$("table tbody").html(htmlStr);
					}	//콜백함수
			);	//getJSON
		});	//click
	});	// document
	
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
						<select name="field" id="field">
							<option value="name">이름</option>
							<option value="tel">전화번호</option>
						</select>
					</td>
					<td>
						<input type="text" name="word" id="word">
					</td>
					<td>
						<input type="button" value="검색" id="searchBtn">
					</td>
				</form>
			</tr>
		</tfoot>
	</table>
</body>
</html>