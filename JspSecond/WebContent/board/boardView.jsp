<%@page import="com.board.BoardVO"%>
<%@page import="com.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 상세 보기</title>
<%
int num = Integer.parseInt(request.getParameter("num"));
BoardDAO dao = BoardDAO.getinstance();
BoardVO board = dao.boardView(num);
%>

<script>
function del(){
	if(confirm("정말 삭제 할까요?")){
		location.href="deletePro.jsp?num=<%=num%>";
	}
}
</script>

</head>
<body>
<h2>글 내용 보기</h2>
<table>
	<tr>
		<td>글번호</td>
		<td><%=board.getNum() %></td>
		<td>조회수</td>
		<td><%=board.getreadcount() %></td>
	</tr>
	<tr>
		<td>작성자</td>
		<td><%=board.getWriter() %></td>
		<td>작성일</td>
		<td><%=board.getReg_date() %></td>
	</tr>
	<tr>
		<td>글제목</td>
		<td colspan="3"><%=board.getSubject() %></td>
	</tr>
	<tr>
		<td>글내용</td>
		<td colspan="3"><%=board.getContent() %></td>
	</tr>
	<tr>
		<td colspan="4">
			<input type="button" value="글수정" onclick="location.href='updateForm.jsp?num=<%=num %>'">
			<input type="button" value="글삭제" onclick="del()">
			<input type="button" value="답글쓰기">
			<input type="button" value="글목록" onclick="location.href='list.jsp'">
		</td>
	</tr>
</table>

</body>
</html>