<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<div id="area">
	<!-- Content -->
	<div id="content">
		<section>
			<header>
			<h2 style="padding-left: 200px;">아이디 중복 검사</h2>
			</header>
			<label for="usr" style="font-size: 20px;padding-left: 200px; margin-right: 20px; font-weight: bold;">아이디</label>
			<input type="text" id="usr" name="usr" size="20"><br>
			<input class="allbutton" type="button" id="idChkF" value="중복확인" style="font-size: 20px; margin: 30px 0px 30px 300px;">
		</section>
	</div>
</div>								
<%@ include file="../include/footer.jsp"%>