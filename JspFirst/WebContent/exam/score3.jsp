<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">
	function test() {
		if(document.getElementById("name").value==""){
			alert("이름을 입력하세요");
			return;
		}
		if(document.getElementById("kor").value==""||isNaN(document.getElementById("kor").value)){
			alert("국어 입력하세요");
			return;
		}
		if(document.getElementById("math").value==""||isNaN(document.getElementById("math").value)){
			alert("수학 입력하세요");
			return;
		}
		if(document.getElementById("eng").value==""||isNaN(document.getElementById("eng").value)){
			alert("영어 입력하세요");
			return;
		}
//		score.submit();
		document.getElementById("sc").submit();
	}

</script>
<title>학생성적</title>
</head>
<body>
	<form action="scoreResult3.jsp" method="post" name="score" id="sc">
		이름 : <input type="text" name="name" id="name"><br>
		국어 : <input type="text" name="kor" id="kor"><br>
		영어 : <input type="text" name="eng" id="eng"><br>
		수학 : <input type="text" name="math" id="math"><br>
		<input type="button" value="전송" onclick="test()">
	</form>
</body>
</html>