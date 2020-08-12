<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>		
<!-- Content -->
<div id="content">
	<section>
		<header>
		<h2 style="padding-left: 200px;">주소검색</h2>
		</header>
		<label for="addrChk" style="font-size: 20px;padding-left: 200px; margin-right: 20px; font-weight: bold;">동 검색</label>
		<input type="text" id="addrChk" name="addrChk" size="20"><br>
		<input class="allbutton" type="button" id="addrChkF" value="주소검색" style="font-size: 20px; margin: 30px 0px 30px 300px;">
		<p id="area"></p>
	</section>
</div>
<div id="area"></div>					
<%@ include file="../include/footer.jsp"%>