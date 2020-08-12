<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
		<title></title>
		<%request.setCharacterEncoding("utf-8"); %>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		<link href='http://fonts.googleapis.com/css?family=Arimo:400,700' rel='stylesheet' type='text/css'>
		<!--[if lte IE 8]><script src="js/html5shiv.js"></script><![endif]-->
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
		<script src="js/skel.min.js"></script>
		<script src="js/skel-panels.min.js"></script>
		<script src="js/init.js"></script>
		<script src="js/member.js"></script>
		<noscript>
			<link rel="stylesheet" href="css/skel-noscript.css" />
			<link rel="stylesheet" href="css/style.css" />
			<link rel="stylesheet" href="css/style-desktop.css" />
		</noscript>
		<!--[if lte IE 8]><link rel="stylesheet" href="css/ie/v8.css" /><![endif]-->
		<!--[if lte IE 9]><link rel="stylesheet" href="css/ie/v9.css" /><![endif]-->
	</head>
<body class="no-sidebar">
<body>
	<!-- Header -->
	<div id="header">
		<div class="container"> 				
			<!-- Logo -->
			<div id="logo">
				<h1><a href="main.jsp">대한민국 미술관</a></h1>
				<span>
				<c:choose>
					<c:when test="${empty seesionScope.userid}">
						<a href="login.do">로그인</a> <a href="join.do">회원 가입</a>
					</c:when>
					<c:otherwise>
						<a href="#">${sessionScope.userid}</a>님 반갑습니다.
						<a href="#">로그 아웃</a>
						<a href="#">나의 정보</a>
						<a href="#">회원 탈퇴</a>
					</c:otherwise>
				</c:choose>
				<a href="board.do">공지</a>
				</span>
			</div>
			<!-- Nav -->
			<nav id="nav">
				<ul>
					<li><a href="main.jsp">메인</a></li>
					<li><a href="left-sidebar.html">전시관</a></li>
					<li><a href="right-sidebar.html">행사</a></li>
					<li><a href="no-sidebar.html">기념품샵</a></li>

				</ul>
			</nav>
		</div>
	</div>
</body>
</html>