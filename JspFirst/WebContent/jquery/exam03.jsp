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
$(document).ready(function(){
	$("#b1").click(function(){
		// 해당 파일의 데이터를 받아서 출력 할 수 있다. 제이순 또는 xml 형식 -> 라이브러리를 이용해서 데이터를 다룰 것
		$.get("data.txt",
				// status는 리턴이 성공,실패.
			  function(data,status){
				if(status=="success"){
					alert("성공");
				}
				var str = "데이터:"+data;
//				$("#result").text(str);
				$("#result").html(str);
			  }	// function
		);	//$.get
	});	// click
	
	$("#b2").click(function(){
		// parsing까지 하는 함수, 여기서는 txt파일이지만, 실전에서는 DB에서 찾아와야함.
		$.getJSON("data.txt",function(data){
			var htmlStr="";
			// data.txt의 내용을 객체로 인식
			alert(data.length);
			// each를 써서 키 값과 벨류 값 찾음. java의 for-each문과 동일기능.
			$.each(data,function(key,val){
				htmlStr+="회원번호:"+val.memberNumber+"<br>"+"번호:"+val.irum+"<br>"+"이미지:"+val.picture+"<br>";
			}) // each
			$("#result").html(htmlStr);
		}); // $.getJSON
	});	// click
});	//document

</script>
</head>
<body>

<button id="b1">결과</button>
<button id="b2">결과2</button>

<div id="result"></div>

</body>
</html>