<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주소록</title>
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>

</head>
<body>
<div align="right">
	<a href="insertForm.ad">회원등록</a> / 주소록 갯수 : <span id="cntSpan">${count}</span>
</div>	
	<table>
		<thead style="text-align: center; color: purple; font: bold;">
			<tr>
				<td>번호</td>
				<td>이름</td>
				<td>주소</td>
				<td>전화번호</td>
				<td>우편번호</td>
			</tr>
		</thead>
		<tbody style="text-align: center;">
			<c:forEach items="${listArr}" var="addr">
				<tr>
					<td style="color: red;">${addr.num}</td>
					<td style="color: orange;"><a href="detail.ad?num=${addr.num}">${addr.name}</a></td>
					<td style="color: blue;">${addr.address}</td>
					<td style="color: yellow;">${addr.tel}</td>
					<td style="color: green;">${addr.zipcode}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<select name="field" id="field">
		<option value="name">이름</option>
		<option value="tel">전화</option>
	</select>
	<input type="text" name="word" id="word">
	<input type="button" value="검색" id="searchBtn">
	<script>
		$("#searchBtn").click(function(){
			if($("#word").val()==""){
				alert("검색어 입력하세요.");
				$("#word").focus();
				return false;
			}
			$.getJSON("search.ad",{"field":$("#field").val(),"word":$("#word").val()},
					function(data){
//						alert(data.Sarr);
						var htmlStr = "";
						$.each(data.Sarr,function(key,val){
							htmlStr+="<tr>";
							htmlStr+="<td>"+val.num+"</td>";
							htmlStr+="<td>"+val.name+"</td>";
							htmlStr+="<td>"+val.address+"</td>";
							htmlStr+="<td>"+val.tel+"</td>";
							htmlStr+="<td>"+val.zipcode+"</td>";
							htmlStr+="</tr>";
						})
						$("table tbody").html(htmlStr);
						$("#cntSpan").text(data.Scount.count);
						
					}	// callback함수
			)	// getJSON
		});	// searchBtn
	</script>
</body>
</html>