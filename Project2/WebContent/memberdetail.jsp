<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>    
<div id="welcome">
	<h2>회원 상세 정보</h2>
</div>
<div id="content">
	<div id="two-columns">
		<div class="content">
			<div id="col1">
				<h2>${memberDetail.userid}님 가입정보</h2>
				<form action="memberupdate.do" id="memberUpdateform">
				<ul class="list-style1">
					<li>							
						<label>번호 : </label>
						${memberDetail.num}
					</li>
					<li>							
						<label>아이디 : </label>
						<input type="text" value="${memberDetail.userid}" readonly="readonly" name="upuserid" id ="upuserid" size=8>
					</li>
					<li>							
						<label>비밀번호 : </label>
						<input type="text" value="${memberDetail.userpwd}" name="upuserpwd" size=7>
					</li>
					<li>							
						<label>성명 : </label>
						<input type="text" value="${memberDetail.username}" name="upusername" size=5>
					</li>
					<li>							
						<label>연락처 : </label>
						<input type="text" value="${memberDetail.usertel}" name="upusertel" size=8>
						
					</li>
					<li>							
						<label>이메일 : </label>
						<input type="text" value="${memberDetail.useremail}" name="upuseremail">
						
					</li>
					<li>							
						<label>우편번호 : </label>
						<input type="text" value="${memberDetail.userzipcode}" name="upuserzipcode" size=4>
					</li>
					<li>						
						<label>주소 : </label>
						<input type="text" value="${memberDetail.useraddr}" name="upuseraddr" size=50>
					</li>
				</ul>
				<c:if test="${sessionScope.grade==1}">
					<input type="button" class="allbutton" value="회원목록" id="listmemberBtn">
				</c:if>
				<input type="button" class="allbutton" value="수정하기" id="updatememberBtn">
				<input type="button" class="allbutton" value="회원탈퇴" id="deletememberBtn">
				</form>
			</div>
			<div id="col2">
				<h2>${memberDetail.userid}님 예약 및 구매 정보</h2>
				<ul class="list-style2">
					<li class="first"><a href="#">Vestibulum luctus venenatis dui</a></li>
					<li><a href="#">Integer rutrum nisl in mi</a></li>
					<li><a href="#">Etiam malesuada rutrum enim</a></li>
					<li><a href="#">Aenean elementum facilisis ligula</a></li>
					<li><a href="#">Ut tincidunt elit vitae augue</a></li>
					<li><a href="#">Aenean elementum facilisis ligula</a></li>
					<li><a href="#">Aenean elementum facilisis ligula</a></li>
					<li><a href="#">Aenean elementum facilisis ligula</a></li>
					<li><a href="#">Ut tincidunt elit vitae augue</a></li>
					<li><a href="#">Sed quis odio sagittis leo vehicula</a></li>
				</ul>
				<p><a href="#" class="link-style">Read More</a></p>
			</div>
		</div>
	</div>
</div>
<%@ include file="../include/footer.jsp"%>