<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
</head>
<body>
	<div>
		<form action="insert" method="post">
			<table>
				<tr>
					<td>
						<label for="writter">글쓴이</label>	
						<input id="writter" name="writter" type="text" maxlength="20" >
					</td>
				</tr>
				<tr>
					<td>
						<label for="subject">제 목</label>
						<input id="subject" name="subject" type="text" maxlength="50" >
					</td>
				</tr>
				<tr>
					<td>
						<label for="content">내 용</label>
						<textarea id="content" name="content" maxlength="70"></textarea>
					</td>
				</tr>
				<tr>
					<td>
						<input type="submit" value="페이지 넘기기 전송">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>