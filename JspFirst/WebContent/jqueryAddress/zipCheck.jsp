<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.js" 
integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" 
crossorigin="anonymous"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#send1").on("click",function(){
		// getJSON은 파싱까지 되어 있음.
		$.getJSON("zipCheckPro.jsp",{"dong":$("#dong").val()},
				function(data){
					var htmlStr = "<table>";
					$.each(data,function(key,val){
						htmlStr+="<tr>";
						htmlStr+="<td>"+val.zipcode+"</td>"
						htmlStr+="<td>"+val.sido+"</td>"
						htmlStr+="<td>"+val.gugun+"</td>"
						htmlStr+="<td>"+val.dong+"</td>"
						htmlStr+="<td>"+val.bunji+"</td>"
						htmlStr+="</tr>";
					})
					htmlStr+="</table>"
					$("#result").html(htmlStr);
				}	// function callback
		);	//$.getJSON
	});	//click
	
	$("#getsend").click(function(){
		// 단순 get 방식
		$.get("zipCheckPro.jsp",{"dong":$("#dong").val()},
				function(data){
					var htmlStr = "<table>";
					// 파싱을 먼저 한다.
					d=$.parseJSON(data);
					// 그다음 배열에 담겨있는 데이터를 차례대로 불러와서 htmlStr에 누적.
					for(var i=0; i<d.length;i++){
						htmlStr+="<tr>";
						htmlStr+="<td>"+d[i].zipcode+"</td>"
						htmlStr+="<td>"+d[i].sido+"</td>"
						htmlStr+="<td>"+d[i].gugun+"</td>"
						htmlStr+="<td>"+d[i].dong+"</td>"
						htmlStr+="<td>"+d[i].bunji+"</td>"
						htmlStr+="</tr>";
					}	// for
					htmlStr+="</table>"
					$("#result").html(htmlStr);
				}	// function
		);	// get
	});	// click
	
	$("#result").on("click","tr",function(){
		var address = $("td:eq(1)",this).text()+" "+$("td:eq(2)",this).text()+" "+
					  $("td:eq(3)",this).text()+" "+$("td:eq(4)",this).text();	
		$(opener.document).find("#zipcode").val($("td:eq(0)",this).text());
		$(opener.document).find("#address").val(address);
		self.close();
	});
});	//document
</script>
</head>
<body>
<table>
	<tr>
		<td>
			동이름 입력	<input type="text" name="dong" id="dong">
			<button id="send1">검색</button>
			<button id="getsend">get검색</button>
		</td>
	</tr>
</table>
<div id="result">
</div>
</body>
</html>