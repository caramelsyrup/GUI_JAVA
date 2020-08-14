<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<div id="welcome">
	<h2>회원 명단</h2>
</div>
<div id="content">
<table>
  <tr>
    <th>번호</th>
    <th>아이디</th>
    <th>이름</th>
    <th>연락처</th>
    <th>이메일</th>
  </tr>
<c:forEach items="${memberlist}" var="m">	  
  <tr>
    <td>${m.num}</td>
    <td><a href="memberDetail.do?usernum=${m.num}">${m.userid}</a></td>
    <td>${m.username}</td>
    <td>${m.usertel}</td>
    <td>${m.useremail}</td>
  </tr>
</c:forEach>  
</table>
</div>
<%@ include file="../include/footer.jsp"%>