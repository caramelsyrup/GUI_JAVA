<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<div id="welcome">
	<h2>미술관 행사</h2>
</div>
<div id="one-column">
	<div id="content">
		<c:if test="${sessionScope.grade==1}">
			<input type="button" class="allbutton" value="행사추가" id="eventsinsertBtn">
		</c:if>
		<c:forEach items="${eventlist}" var="event">
			<a href="eventsDetail.do?eventnum=${event.eventnum}"><img src="<c:url value="/images/${event.filename}"/>"></a>
		</c:forEach>	
	</div>
</div>
<%@ include file="../include/footer.jsp"%>