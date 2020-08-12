<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<div id="welcome">
	<h2>회원 가입(join)</h2>
</div>
<div id="one-column">
	<div id="area">
		<form action="join.do" method="post">
			<table>
			<tr>
				<th>
					<label>아이디</label>
				</th>
				<td>
					<input type="text" size="20" name="juserid" id="juserid">
				</td>
				<td>
					<input type="button" id="idChkBtn" value="중복검사">
				</td>
			</tr>
			<tr>
				<th>
					<label>비밀번호</label>
				</th>
				<td>
					<input type="password" size="20" name="juserpwd" id="juserpwd">
				</td>
			</tr>
			<tr>
				<th>
					<label>성명</label>
				</th>
				<td>
					<input type="text" size="20" name="username" id="username">
				</td>
			</tr>
			<tr>
				<th>
					<label>주소</label>
				</th>
				<td>
					<input type="text" size="10" name="userzipcode" id="userzipcode">
					<input type="text" size="50" name="useraddr" id="useraddr">
					
				</td>
				<td>
					<input type="button" id="addrBtn" value="주소검색">
				</td>
			</tr>
			<tr>
				<th>
					<label>연락처</label>
				</th>
				<td>
					<input type="text" size="20" name="usertel" id="usertel">
				</td>
			</tr>
			<tr>
				<th>
					<label>이메일주소</label>
				</th>
				<td>
					<input type="email" size="40" name="useremail" id="useremail">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input class="allbutton" type="submit" width="200" value="회원가입" id="joinbtn">
				</td>
				<td colspan="2">
					<input class="allbutton" type="reset"  value="취소" id="resetbtn">
				</td>
			</tr>
			</table>
		</form>	
	</div>
</div>

<%@ include file="../include/footer.jsp"%>