<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<div id="welcome">
<h2>작품 전시관</h2>
</div>
<div id="one-column">
	<div id="area">
		<c:forEach items="${artlist}" var="art">
			<a href="artworkDetail.do?artid=${art.artid}"><img src="<c:url value="/images/${art.filename}"/>"></a>
		</c:forEach>	
	</div>
</div>

<%@ include file="../include/footer.jsp"%>