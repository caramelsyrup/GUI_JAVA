<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="keywords" content="" />
<meta name="description" content="" />
<%request.setCharacterEncoding("utf-8"); %>
<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600" rel="stylesheet" type="text/css" />
<link href="<c:url value="/css/default.css"/>" rel="stylesheet" type="text/css" media="all" />
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
<script type="text/javascript" src="<c:url value="/js/member.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/artwork.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/events.js"/>"></script>
<title>Insert title here</title>
</head>
<body>
<div id="wrapper">
	<div id="header">
		<div id="logo">
			<h1><a href="main.do">대한민국 미술관</a></h1>
			<ul>
				<li><a href="board.do">공지</a></li>
				<c:choose>
					<c:when test="${empty sessionScope.userid}">
						<li><a href="join.do">회원 가입</a></li>
						<li><a href="login.do">로그인</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="logout.do">로그 아웃</a></li>
						<li><a href="memberDetail.do">나의 정보</a></li>
						<c:if test="${sessionScope.grade==1}">
							<li><a href="memberlist.do">회원 명단</a></li>
							<li><a href="eventslist.do">행사 목록</a></li>
							<li><a href="artworkInsertForm.do">작품 추가</a></li>
						</c:if>	
						<li>${sessionScope.userid}님 반갑습니다.</li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
	</div>
	<!-- end #header -->
	<div id="menu">
		<ul>
			<li class="current_page_item"><a href="main.do">홈</a></li>
			<li><a href="#">소개</a></li>
			<li><a href="artworkList.do">전시관</a></li>
			<li><a href="eventslist.do">행사</a></li>
			<li class="last"><a href="#">기념품샵</a></li>
		</ul>
	</div>
	<!-- end #menu -->
