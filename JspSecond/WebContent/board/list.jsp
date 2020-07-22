<%@page import="com.board.BoardVO"%>
<%@page import="com.board.BoardDAO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>	    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
<%
	BoardDAO dao = BoardDAO.getinstance();
	String field = "", word="";
	ArrayList<BoardVO> arr = null;
	int count =0;
	if(request.getParameter("word")!=null){
		field = request.getParameter("field");
		word = request.getParameter("word");
		arr = dao.boardList(field,word);
		count = dao.boardCount(field, word);
	}else{
		arr = dao.boardList();
		count = dao.boardCount();
	}
%>    
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" 
	  integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body>
<h1>게시판</h1>
<div align="left">
	현재 게시글 수는 <span id="cntSpan"><%=count %></span>명 입니다.
	<a href=""></a>님 반갑습니다.
	<a href="writeForm.jsp">글쓰기</a>
	<a href="logout.jsp">로그아웃</a>
</div>
	<form action="list.jsp" name="search" method="get">
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col">번호</th>
					<th scope="col">제목</th>
					<th scope="col">작성자</th>
					<th scope="col">작성일</th>
					<th scope="col">조회수</th>
					<th scope="col">IP주소</th>
				</tr>
			</thead>
			<tbody>
<%
			for(BoardVO vo : arr){
%>
				<tr>
					<td><%=vo.getNum() %></td>
					<td><a href="boardView.jsp?num=<%=vo.getNum() %>"><%=vo.getSubject() %></a></td>
					<td><%=vo.getWriter() %></td>
					<td><%=vo.getReg_date() %></td>
					<td><%=vo.getreadcount() %></td>
					<td><%=vo.getIp() %></td>
				</tr>			
<%
				}
%>		
			</tbody>
			<tfoot>
				<tr>
					<td colspan="6" align="center">
						<select name="field" size="1">
							<option value="subject">제목</option>
							<option value="writer">작성자</option>
						</select>
						<input type="text" size="15" name="word">
						<input type="submit" value="검색">
					</td>
				</tr>
			</tfoot>
		</table>
	</form>
	<div align="center">
	
<%
	// 페이지 나누기, 한번에 5개의 페이지가 뜨고 블록은 3개씩 잡는다.
	int pageSize = 5;
	if(count>0){
		int pagecount = (count/pageSize)+(count%pageSize==0?0:1);
		int pageBlock = 3;
		int startPage = (int)((currentPage-1)/pageBlock)*pageBlock+1;
		int endPage = startPage+pageBlock-1;
		if(endPage > pagecount ){
			endPage = pagecount;
		}
		//이전
		
		// for
		
		//다음
	}
%>	
</div>
</body>
</html>