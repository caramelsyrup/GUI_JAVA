<%@page import="com.address.ZipcodeBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.address.AddressDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>우편번호검색창</title>
<style>
	a:hover {
	text-decoration: none; color: silver;
	}
	a:link {
	text-decoration: none; color: black;
	}
	a:visited {
	text-decoration: none; color: #000;
}
</style>
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
<% 
	request.setCharacterEncoding("UTF-8");
	String dong = request.getParameter("dong");
	
	AddressDAO dao = AddressDAO.getInstance();
	ArrayList<ZipcodeBean> zarr = dao.zipcodeRead(dong);
%>
<script type="text/javascript">
function dongCheck(){
	// jquery 이용.
	if($("#dong").val()==""){
		alert("동이름을 입력하세요");
		$("#dong").focus(); // 자연스레 커서가 id=dong에 생성.
		return false;
	}
	$("#frm").submit();	// frm으로 제출,이동
}

function send(zip,sido,gugun,don,bunji){
	var address = sido+" "+gugun+" "+don+" "+bunji;
	opener.document.enroll.zipcode.value=zip;
	opener.document.enroll.address.value=address;
	self.close();
}

</script>
</head>
<body>
	<form action="zipCheck.jsp" id="frm">
		<table border="1">
			<tr>
				<td colspan="5">동이름 입력 : <input type="text" name="dong" id="dong">
					<input type="button" value="검색" onclick="dongCheck()">
				</td>
			</tr>
			<%
				if(zarr.isEmpty()){
			%>		
				<tr>
					<td colspan="5">검색된 결과가 없습니다.</td>
				</tr>
			<%		
				}else{
			%>
				<tr>
					<td colspan="5">*검색 후, 아래 우편번호를 클릭하시면 자동으로 입력됩니다.</td>
				</tr>
				<tr>
					<th size="8">우편번호</th>
					<th>시도</th>
					<th>구군</th>
					<th>동</th>
					<th>번지</th>
				</tr>
			<%
				for(ZipcodeBean z : zarr){
					String zip = z.getZipcode();
					String sido = z.getSido();
					String gugun = z.getGugun();
					String don = z.getDong();
					String bunji = z.getBunji();
			%>	
				<tr>
					<td><a href="javascript:send('<%=zip%>','<%=sido%>','<%=gugun%>','<%=don%>','<%=bunji%>')">
					<%=zip %></a></td>
					<td><%=sido %></td>
					<td><%=gugun %></td>
					<td><%=don %></td>
					<td><%=bunji %></td>					
				</tr>
			<%					
				}
				}
			%>
		</table>		
	</form>
</body>
</html>