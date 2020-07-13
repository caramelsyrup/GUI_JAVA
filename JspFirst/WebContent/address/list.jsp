<%@page import="java.util.ArrayList"%>
<%@page import="com.address.Address"%>
<%@page import="com.address.AddressDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>리스트화면</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" 
	  integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<style>
	div.divCss{
	text-align: right;
	background-color: yellow;
	padding-right: 40px;
	}
	a:hover {text-decoration: none;}
	a:link {text-decoration: none;}
	a:visited {text-decoration: none;}
</style>
<%
	request.setCharacterEncoding("UTF-8");
	AddressDAO dao = AddressDAO.getInstance();
	ArrayList<Address> address = null;
	String word="";
	String field="";
	// null은 객체가 아직 생성이 되어지지 않은 상태. 공백은 객체는 생성되어 있지만, 현재 값이 없는 상태.
	if(request.getParameter("word") != null){
		word = request.getParameter("word");
		field = request.getParameter("field");
	}
	address = dao.addressList(field,word);
	int count = dao.getCount(field, word);
	
%>
<script type="text/javascript">
function searchCheck(){
	if($("#word").val() == ""){
		alert("검색어를 입력하세요");
		$("#word").focus();
		return false;
	}
	$("#searchFrm").submit();
}

function deleteFunction(no){
	if(confirm("정말 삭제 하시겠습니까?")){
		location.href="deletePro.jsp?num="+no;
	}
}
</script>

</head>
<body>
<div class="divCss">
	주소록 갯수 : <%=count %><br>
	<a href="insert.jsp">추가하기</a>	/	
	<a href="list.jsp">전체리스트</a>
</div>
<table border="1" class="table table-striped table-dark">
	<thead>
		<tr>
			<th scope="col">번호</th>
			<th scope="col">이름</th>
			<th scope="col">우편번호</th>
			<th scope="col">주소</th>
			<th scope="col">전화번호</th>
		</tr>
	</thead>
	<tbody>
<% 	
	for(int i=0; i<address.size();i++){
%>		
		<tr>
			<td scope="row"><%=address.get(i).getNum()%></td>
			<td><a href="detail.jsp?num=<%=address.get(i).getNum() %>"><%=address.get(i).getName()%></a></td>
			<td><%=address.get(i).getZipcode()%></td>
			<td><%=address.get(i).getAddress()%></td>
			<td><%=address.get(i).getTel()%></td>
			<td onclick="deleteFunction(<%=address.get(i).getNum() %>)">삭제</td>
		</tr>
<%
	}
%>	
	</tbody>
	<tfoot>
		<tr>
	 		<form action="list.jsp" name="searchFrm" id="searchFrm" >
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
					<input type="button" value="검색" onclick="searchCheck()" class="btn btn-warning">
				</td>
			</form>
		</tr>
	</tfoot>
</table>

</body>
</html>