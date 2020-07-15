<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
<%
request.setCharacterEncoding("UTF-8");
%>
<script type="text/javascript">
// 특정 영역에다가 결과값을 출력 시킬 의도, ajax 사용.
$(document).ready(function(){
	$("#postBtn").click(function(){
		// 비동기적 방식, callback 
		// 총 구성이     $.post("결과를 처리할 페이지" , {키:밸류}형식의 데이터 , function(data)의 콜백함수);
		// 키는 해당 데이터의 id 값
		$.post("process.jsp",{"id":$("#id").val(),"pwd":document.getElementById("pwd").value,"method":"post"},
			function(data){	// 콜백 함수
			// html 함수로 테그를 설정.
				$("#postresult").html(data);
			}	// function 콜백함수
		);	// $.post
	});	 // click
	
	$("#getBtn").click(function(){
		$.get("process.jsp",{"id":$("#id").val(),"pwd":$("#pwd").val(),"method":"get"},
			function(ret){
				$("#getresult").html(ret);
			}	// function
		);	// $.get
	}); // click
	
	$("#loadBtn").click(function(){
		// load 함수
		$("#loadresult").load("process.jsp",{"id":$("#id").val(),"pwd":$("#pwd").val(),"method":"load"}
				
/*			function(data){
				$()
			}	// function
*/			
		); // load
	});	// click
	
	$("#ajaxBtn").click(function(){
		$.ajax({
			type:"post", url:"process.jsp" , data:{"id":$("#id").val(),"pwd":$("#pwd").val(),"method":"ajax"},
			success:function(d){
				$("#ajaxresult").html(d);
			},
			error:function(e){
				alert("error : "+e);
			}
		});
	});
	
}); // document
</script>
</head>
<body>

id : <input type="text" id="id" name="id"><br>
pwd : <input type="password" id="pwd" name="pwd"><br> 
<input type="button" value="post전송" id="postBtn"><br>
<input type="button" value="get전송" id="getBtn"><br>
<input type="button" value="load전송" id="loadBtn"><br>
<input type="button" value="ajax전송" id="ajaxBtn"><br>
<div id="postresult"></div>
<div id="getresult"></div>
<div id="loadresult"></div>
<div id="ajaxresult"></div>
</body>
</html>