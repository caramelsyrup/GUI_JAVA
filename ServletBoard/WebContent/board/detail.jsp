<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.1/css/bootstrap.min.css" integrity="sha384-VCmXjywReHh4PwowAiWNagnWcLhlEJLA5buUprzK8rxFgeH0kww/aWY76TfkUoSX" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$.getJSON("commentList",
				{num:$("#num").val()},
					function(d){
//						alert(d.carr.length);
						var htmlStr="";
						$.each(d.carr,function(key,val){
							htmlStr += val.userid+" ";
							htmlStr += val.msg+" ";
							htmlStr += val.regdate+"<br>";
						});
						$("#commentResult").html(htmlStr);
					}
	);
	
	$("#commentBtn").on("click",function(){
		$.ajax({
			type:"get",
			url:"commentInsert",
			data:{"msg":$("#msg").val(),"num":$("#num").val()},
			success:function(d){
				if(d.trim()==1){
					alert("로그인하세요.");
					location.href="login.jsp";
				}else{
					var htmlStr="";
					d = JSON.parse(d);
					$.each(d.carr,function(key,val){
						htmlStr += val.userid+" ";
						htmlStr += val.msg+" ";
						htmlStr += val.regdate+"<br>";
					});
					$("#commentResult").html(htmlStr);
				}
			},
			error:function(e){
				alert("error : "+e);
			}
		});
	});
});
</script>
</head>
<body>
<h2>글내용 보기</h2>
<input type="hidden" id="num" value="${board.num}">
<table class="table table-dark">
		<tr>
			<th>번호</th>
			<td>${board.num}</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${board.writter}</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${board.subject}</td>
		</tr>
		<tr>
			<th >내용</th>
			<td>${board.content}</td>
		</tr>
		<tr>
			<th >작성일</th>
			<td>${board.reg_date}</td>
		</tr>
		<tr>
			<th >조회수</th>
			<td>${board.readcount}</td>
		</tr>
		<tr>
			<td><input type="button" value="수정"></td>
			<td><input type="button" value="삭제"></td>
		</tr>	
</table>
<br></br>
<div id="commentResult"></div>
<br></br>
<div align="center">
	<textarea rows="5" cols="50" id="msg"></textarea>
	<input type="button" value="comment" id="commentBtn">
</div>		
</body>
</html>