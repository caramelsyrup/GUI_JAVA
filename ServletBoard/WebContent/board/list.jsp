<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.1/css/bootstrap.min.css" integrity="sha384-VCmXjywReHh4PwowAiWNagnWcLhlEJLA5buUprzK8rxFgeH0kww/aWY76TfkUoSX" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

</head>
<a href="#">글쓰기</a>
<body>
	<table class="table table-dark">
		<tr>
			<th scope="col">번호</th>
			<th scope="col">작성자</th>
			<th scope="col">제목</th>
			<th scope="col">작성일</th>
			<th scope="col">조회수</th>
		</tr>
		<c:forEach items="${list}" var="b">
		<tr>
			<td>${b.num}</td>
			<td>${b.writter}</td>
			<td><a href="detail?num=${b.num}">${b.subject}</a></td>
			<td>${b.reg_date}</td>
			<td>${b.readcount}</td>
		</tr>
		</c:forEach>
	</table>
	<div id="page" align="center">
		<c:if test="${pb.startPage>pb.pageBlock}">
			<a href="javascript:getdata(${pb.startPage-pb.pageBlock})">[이전]</a>
		</c:if>
		<c:forEach begin="${pb.startPage}" end="${pb.endPage}" var="i">
			<c:if test="${i==pb.currentPage}">
				<c:out value="${i}"/>
			</c:if>
			<c:if test="${i!=pb.currentPage}">
				<a href="javascript:getdata(${i})">${i}</a>
			</c:if>
		</c:forEach>
		<c:if test="${pb.endPage<pb.totalpage}">
			<a href="javascript:getdata(${pb.endPage+1})">[다음]</a>
		</c:if>
	</div>
	<div ></div>
</body>
</html>