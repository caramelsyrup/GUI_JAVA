<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#send").click(function(){
		if($("#dong").val()==""){
			alert('동이름 입력하세요.');
			$("#dong").focus();
			return false;
		}	// if
		$.post("zip.do",{"dong":$("#dong").val()},
				function(data){
					data = JSON.parse(data);
					var htmlStr="";
					htmlStr +="<table>";
					for(var i=0; i<data.jarr.length; i++){
						htmlStr+="<tr>";
						htmlStr+="<td>"+data.jarr[i].zipcode+"</td>";
						htmlStr+="<td>"+data.jarr[i].sido+"</td>";
						htmlStr+="<td>"+data.jarr[i].gugun+"</td>";
						htmlStr+="<td>"+data.jarr[i].dong+"</td>";
						htmlStr+="<td>"+data.jarr[i].bunji+"</td>";
						htmlStr+="</tr>";
					}
					htmlStr+="</table>";
					$("#area").html(htmlStr);
				}	// 콜백function
		);	// post
		$("#area").on("click","tr",function(){
			var address=$("td:eq(1)",this).text()+" "+$("td:eq(2)",this).text()+" "+$("td:eq(3)",this).text()+" "+$("td:eq(4)",this).text();
			$(opener.document).find("#zipCode").val($("td:eq(0)",this).text());
			$(opener.document).find("#address").val(address);
			self.close();
		})
	});	// click
}); // document.function

	

</script>
</head>
<body>
	<table border="1">
		<tr>
			<td colspan="5">동이름 입력 : 
				<input type="text" name="dong" id="dong">
				<input type="button" value="검색" id="send">
			</td>
		</tr>
	</table>
	<div id="area"></div>		
</body>
</html>