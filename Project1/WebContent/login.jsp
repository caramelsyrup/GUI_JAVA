<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ include file="header.jsp" %>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
<div id="main">
	<div class="container">
		<div class="row"> 					
			<!-- Content -->
			<div id="content">
			<form method="post" action="main.do">
				<section id="login">
						<h2 id="loginTitle">로그인</h2>
						<p>
							<label>아이디</label>
							<input type="text" size="20" name="userid" id="userid" ><br>
							<label>비밀번호</label>
							<input type="password" size="20" name="userpwd" id="userpwd"><br>
							<input type="button" width="200" value="로그인" id="loginbtn">
							<input type="button"  value="회원가입" id="joinbtn" onclick="location.href='join.do'">
						</p>
				</section>
			</form>	
			</div>					
		</div>
	</div>
</div>
<script>
$("#loginbtn").click(function(){
	if($("#userid").val()==""){
		alert("아이디를 입력하세요.");
		$("#userid").focus();
		return false;
	}
	if($("#userpwd").val()==""){
		alert("비밀번호를 입력하세요.");
		$("#userpwd").focus();
		return false;
	}
	
})
</script>
</body>
</html>
<%@ include file="footer.jsp"%>