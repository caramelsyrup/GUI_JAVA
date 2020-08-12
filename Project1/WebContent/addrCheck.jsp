<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ include file="../include/header.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주소검색창</title>
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
</head>
<body>
<div id="main">
	<div class="container">
		<div class="row"> 					
			<!-- Content -->
			<div id="content">
				<section>
					<header>
						<h2 style="padding-left: 200px;">주소검색창</h2>
					</header>
						<label for="addrChk" style="font-size: 20px;padding-left: 200px; margin-right: 20px; font-weight: bold;">동 검색</label>
						<input type="text" id="addrChk" name="addrChk" size="20"><br>
						<input type="button" id="addrChkF" value="주소검색" style="font-size: 20px; margin: 30px 0px 30px 300px;">
						<p id="area"></p>
				</section>
			</div>					
		</div>
	</div>
</div>
<script type="text/javascript">

	// 빈칸일떄
	$("#addrChkF").click(function(){
		if($("#addrChk").val()==""){
			alert("동 주소를 입력하세요.");
			$("#addrChk").focus();
			return false;
		}
	// 기입한 주소 정보를 검색하여, 결과 값을 출력
	$.post("addrCheck.do",{"addrChk":$("#addrChk").val()},
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
	
	// 출력값 영역을 클릭하면, 주소에 자동 입력
	$("#area").on("click","tr",function(){
		var address=$("td:eq(1)",this).text()+" "+$("td:eq(2)",this).text()+" "+$("td:eq(3)",this).text()+" "+$("td:eq(4)",this).text();
		$(opener.document).find("#userzipcode").val($("td:eq(0)",this).text());
		$(opener.document).find("#useraddr").val(address);
		self.close();
	});
	
	
	
});
</script>
</body>
</html>
<%@ include file="../include/footer.jsp" %>