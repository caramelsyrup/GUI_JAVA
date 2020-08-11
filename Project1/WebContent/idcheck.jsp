<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ include file="header.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디중복체크</title>
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
</head>
<body>
<div id="main">
	<div class="container">
		<div class="row"> 					
			<!-- Content -->
			<div id="content">
				<section>
					<header>
						<h2 style="padding-left: 200px;">아이디 중복 검사</h2>
					</header>
						<label for="usr" style="font-size: 20px;padding-left: 200px; margin-right: 20px; font-weight: bold;">아이디</label>
						<input type="text" id="usr" name="usr" size="20"><br>
						<input type="button" id="idChkF" value="중복확인" style="font-size: 20px; margin: 30px 0px 30px 300px;">
				</section>
			</div>					
		</div>
	</div>
</div>
</body>
</html>
<%@ include file="footer.jsp" %>