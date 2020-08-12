<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<div id="welcome">
	<h2>로그인(login)</h2>
</div>
<div id="one-column">
	<div id="area">
		<h3>아이디</h3>
		<input type="text" size="20" name="userid" id="userid" >
		<h3>비밀번호</h3>
		<input type="password" size="20" name="userpwd" id="userpwd"><br>
		<input class="allbutton" type="button" width="200" value="로그인" id="loginbtn">
		<input class="allbutton" type="button"  value="회원가입" id="joinbtn" onclick="location.href='join.do'">
	</div>
</div>
<%@ include file="../include/footer.jsp"%>