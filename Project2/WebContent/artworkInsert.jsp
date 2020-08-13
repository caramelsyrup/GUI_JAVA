<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<div id="welcome">
	<h2>작품 추가 페이지</h2>
</div>
<div id="one-column">
	<div id="area">
	<form action="artworkInsert.do" method="post" id="artowrkInsertform">
		<h3>작품 제목</h3>
		<input type="text" size="20" name="arttitle" id="arttitle" required="required">
		<h3>작가</h3>
		<input type="text" size="20" name="artmaker" id="artmaker" >
		<h3>작품 설명</h3>
		<input type="text" size="50" name="artdescription" id="artdescription" >
		<h3>파일이름</h3>
		<input type="text" size="20" name="afilename" id="afilename" required="required"><br>
		<input class="allbutton" type="button" value="작품추가" id="artworkInsertBtn">
		<input class="allbutton" type="reset" value="취소" id="reset">
	</form>
	</div>
</div>

<%@ include file="../include/footer.jsp"%>