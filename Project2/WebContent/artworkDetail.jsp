<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<div id="welcome">
	<h2>작품 상세 설명</h2>
</div>
<div id="one-column">
	<div id="area">
	<form action="artworkDelete.do" method="get" id="artworkDeleteform">
	<input type="hidden" name="artidDelete" value="${artDetail.artid}">
		<h3>${artDetail.arttitle}</h3>
		<p>${artDetail.artmaker}</p>
		<p>${artDetail.artdescription}</p>
		<p>
			<input type="button" class="allbutton" id="artworkListBtn" value="목록">
			<c:if test="${sessionScope.userid=='admin'}">
				<input type="button" class="allbutton" id="artworkDeleteBtn" value="삭제하기">
			</c:if>	
		</p>
		<img src="<c:url value="/images/${artDetail.filename}"/>">
	</form>	
	</div>
</div>
<%@ include file="../include/footer.jsp"%>