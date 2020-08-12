<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ include file="../include/header.jsp" %>
<body>
<div id="main">
	<div class="container">
		<div class="row"> 					
			<!-- Content -->
			<div id="content">
			 	<form action="join.do" method="post">
					<section id="login">
							<h2 id="loginTitle">회원가입</h2>
							<p>
								<label>아이디</label>
								<input type="text" size="20" name="userid" id="userid">
								<input type="button" id="idChkBtn" value="중복검사"><br>
								<label>비밀번호</label>
								<input type="password" size="20" name="userpwd" id="userpwd"><br>
								<label>성명</label>
								<input type="text" size="20" name="username" id="username"><br>
								<label>주소</label>
								<input type="text" size="10" name="userzipcode" id="userzipcode"><br>
								<input type="text" size="50" name="useraddr" id="useraddr">
								<input type="button" id="addrBtn" value="주소검색"><br>
								<label>연락처</label>
								<input type="text" size="20" name="usertel" id="usertel"><br>
								<label>이메일주소</label>
								<input type="email" size="40" name="useremail" id="useremail"><br>
								<input type="submit" width="200" value="회원가입" id="loginbtn">
								<input type="reset"  value="취소" id="resetbtn">
							</p>
					</section>
				</form>	
			</div>					
		</div>
	</div>
</div>
<script type="text/javascript">
var exp = /^[0-9]{3}[0-9]{4}[0-9]{4}$/;

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
	if($("#username").val()==""){
		alert("이름을 입력하세요");
		$("#username").focus();
		return false;
	}
	if($("#usertel").val()==""){
		alert("전화번호를 입력하세요");
		$("#usertel").focus();
		return false;
	}
	if(!$("#usertel").val().match(exp)){
		alert("전화번호 양식을 맞춰주세요.");
		$("#usertel").focus();
		return false;
	}
	
	$("#loginbtn").submit();
});
</script>
</body>
</html>
<%@ include file="../include/footer.jsp"%>