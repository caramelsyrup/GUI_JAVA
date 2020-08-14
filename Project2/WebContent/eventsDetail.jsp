<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<div id="welcome">
	<h2>행사 정보</h2>
</div>
<div id="one-column">
	<div id="area">
	<c:choose>
		<c:when test="${sessionScope.grade==1}">
			<form action="eventsUpdate.do" method="post" id="eventsInsertform" enctype="multipart/form-data">
				<h3>행사 제목</h3>
				<input type="text" size="20" name="eventname" id="eventname" required="required">
				<h3>행사 주최</h3>
				<input type="text" size="20" name="eventhost" id="eventhost" >
				<h3>행사 개최 날짜</h3>
				<input type="text" size="20" name="eventsche" id="eventsche" placeholder="YY-MM-DD HH24:MI">
				<h3>행사 장소</h3>
				<input type="text" size="50" name="eventlocation" id="eventlocation">
				<h3>행사 내용</h3>
				<input type="text" size="50" name="eventdescip" id="eventdescip">
				<h3>포스터파일</h3>
				<input type="file" size="20" name="efilename" id="efilename"><br>
				<input class="allbutton" type="button" value="작품추가" id="eventsInsertBtn">
				<input class="allbutton" type="reset" value="취소" id="reset">
				<input class="allbutton" type="button" value="행사목록" id="eventsListBtn">
			</form>
		</c:when>
		<c:otherwise>
			<form>
				<p>
					<input class="allbutton" type="button" value="행사목록" id="eventsListBtn">
					<input class="allbutton" type="button" value="참석하기" id="reservationeventsBtn">
				</p>
				<h3>${event.eventname}</h3>
				<h3>${event.eventhost}</h3>
				<h4>${event.eventlocation}</h4>
				<p>${event.eventdescip}</p>
				<img src="<c:url value="/images/${event.filename}"/>">
			</form>
		</c:otherwise>
	</c:choose>
	</div>
</div>

<%@ include file="../include/footer.jsp"%>