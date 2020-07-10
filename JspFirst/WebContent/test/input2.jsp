<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생정보등록</title>
<!-- <script type="text/javascript" src="../js/jquery-3.5.1.min.js"></script>  -->
<script
  src="https://code.jquery.com/jquery-3.5.1.js"
  integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
  crossorigin="anonymous">
 </script>
<script type="text/javascript">
// 버튼과  함수를 바로 연결하는 방식.
/*	$(document).ready(function(){
		$("#btn").click(function(){
			alert("test");
			});
	});
*/
// 반드시 id가 설정되어 있어야 한다.
$(function(){
//	$("#btn").click(function(){	 click명령어
	$("#btn").on("click",function(){	// on명령어 둘다 같은 기능.
		alert("testtest");
	
		if($("#name").val()==""){
			alert("이름을 입력하세요");
			return false;
		}	//if
		if($("#studentNum").val()==""){
			alert("학번을 입력하세요");
			return false;
		}	//if
		if($("#studentNum").val()==""){
			alert("학번을 입력하세요");
			return false;
		}	//if
		if($("input[name='hobby']:checked").length==0){
			alert("취미를 입력하세요");
			return false;
		}	//if
		$("#frm").submit();
	}); // click
}); // function


</script>
</head>
<body>
	<form action="inputResult.jsp" method="post" name="frm" id="frm">	<!-- post는 주소창에 정보를 비공개전환 -->
		이름 : <input type="text" name="name" id="name"><br>
		학번 : <input type="text" name="studentNum" id="studentNum"><br>
		성별 : 
<!--    
		<input type="radio" name="gender" value="man" checked="checked">남자
		<input type="radio" name="gender" value="woman">여자<br>
 -->		
 		<input type="radio" name="gender" value="man" checked="checked" id="man">
 		<label for="man">남자</label>
 		<input type="radio" name="gender" value="woman" checked="checked" id="woman">
 		<label for="woman">여자</label><br>
		전공 : <select name="major" size="2" title="전공" multiple="multiple">
				<option value="국문학과" selected="selected">국문학과</option>
				<option value="영문학과">영문학과</option>
				<option value="수학과">수학과</option>
				<option value="식품공학과">식품공학과</option>
				<option value="생활스포츠과학과">생활스포츠과학과</option>
			 </select><br>
		취미<br>
		<input type="checkbox" name="hobby" value="운동">운동
		<input type="checkbox" name="hobby" value="운동1">운동1
		<input type="checkbox" name="hobby" value="운동2">운동2
		<input type="checkbox" name="hobby" value="운동3">운동3<br>

<!-- 		<input type="submit" value="보내기">	 -->
		<input type="button" value="보내기" id="btn">
		<input type="reset" value="취소">
	</form>

</body>
</html>