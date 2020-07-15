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
	$("button").click(function(){
		// html 함수는 ()에 테그를 쓸 수 있다.
		$("#displayArea").html("<b>내용바뀜</b>");
		// this는 자기 자신의 객체를 의미, 여기선 button을 의미한다.
		alert($(this).text());
		$(this).text("여기도 바뀔까?");
	});	// button
	$("#txtBtn").on("click",function(){
		// val()을 하면, 초기 설정된 값을 가져옴.
		alert($("#txt").val());
		// txt아이디에 변수 내용이 들어감.
		$("#txt").val("txt 내용 변경");
	});	// txtBtn
});	// document

</script>

</head>
<body>
	<div id="displayArea">이곳의 내용이 변경
	 
	</div>
	<button>표시</button><br>
	<input type="text" id="txt" value="초기값"><br>
	<input type="button" value="txt클릭" id="txtBtn">
</body>
</html>