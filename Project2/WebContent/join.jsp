<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<div id="welcome">
	<h2>회원 가입(join)</h2>
</div>
<div id="content">
<div id="one-column">
	<div id="area">
		<form action="join.do" method="post" id="joinform">
					<h4>아이디</h4>
					<input type="text" size="20" name="juserid" id="juserid">
					<input class="allbutton" type="button" id="idChkBtn" value="중복검사">

					<h4>비밀번호</h4>
					<input type="password" size="20" name="juserpwd" id="juserpwd">

					<h4>이름</h4>
					<input type="text" size="20" name="username" id="username">

					<h4>주소</h4>
					<input type="text" size="10" name="userzipcode" id="userzipcode"><br>
					<input type="text" size="50" name="useraddr" id="useraddr">
					<input class="allbutton" type="button" id="addrBtn" value="주소검색">

					<h4>연락처</h4>
					<input type="text" size="20" name="usertel" id="usertel">

					<h4>이메일주소</h4>
					<input type="email" size="40" name="useremail" id="useremail"><br>
					<input class="allbutton" type="button" width="200" value="회원가입" id="joinbtn">
					<input class="allbutton" type="reset"  value="취소" id="resetbtn">
		</form>	
	</div>
</div>
</div>
<%@ include file="../include/footer.jsp"%>