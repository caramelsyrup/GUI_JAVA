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
		getdata(1);

		$("#send").click(function(){
			var writter = $("#writter").val();
			var content = $("#content").val();
			var grade = $("input:radio[name=grade]:checked").val();
			var postString = "writter="+writter+"&content="+content+"&grade="+grade;	// 쿼리형식
			$.ajax({
				type:"post",
				url:"create.gb",
				data:postString,	// {"name":$("#name").val()} 의 형식은 JSON 방식의 데이터
				success:function(d){
					$("#result").html(d);
				},
				
				beforeSend:showRequest,	// url에 가기전에 먼저 처리하게 하는 함수
				
				error:function(e){
					alert("error : "+e);
				}
			});	//$.ajax
		});	// click
	});	// document
	
	function getdata(pageNum){
		$.get("list.gb",
				{"pageNum":pageNum},
					function(d){
				$("#result").html(d);
			}
		);
	}
	
	function showRequest(){
		if($("#writter").val()==""){
			alert("이름을 입력하세요.");
			$("#writter").focus();
			return false;
		}
		if($("input:radio[name=grade]:checked").length==0){
			alert("평가를 해주세요.");
			return false;
		}
		return true;
	}	// function showRequest
	
	function textCount(obj,target){
		var len = $("#"+obj.id).val().length;
		if(obj.size==len){
			alert("글자수 초과");
			return false;
		}
		$("#"+target).text(len);
	}
	
	function fview(){
		$.get("view.gb",
				{},
				function(){
					
				}
		);
	}
	
</script>
</head>
<body>
	<div>
		<form action="create.gb" method="post">
			<table>
				<tr>
					<td>
						<label for="writter">글쓴이</label>	
						<input id="writter" name="writter" type="text" maxlength="20" onkeyup="textCount(this,'writterCount')">
						*20 글자 이내 (<span id="writterCount" style="color: red">0</span>)
					</td>
				</tr>
				<tr>
					<td>
						<label for="content">내 용</label>
						<input id="content" name="content" type="text" maxlength="70" onkeyup="textCount(this,'contentCount')">
						*70 글자 이내 (<span id="contentCount" style="color: red">0</span>)
					</td>
				</tr>
				<tr>
					<td>
						<label for="grade">평가</label>
						<input id="grade" name="grade" type="radio" value="good">잘함
						<input id="grade" name="grade" type="radio" value="normal">보통
						<input id="grade" name="grade" type="radio" value="fail">노력
					</td>
				</tr>
				<tr>
					<td>
						<input type="submit" value="페이지 넘기기 전송">
						<input type="button" id="send" value="ajax방식 전송">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<br></br>
	<div id="result">
	</div>
</body>
</html>