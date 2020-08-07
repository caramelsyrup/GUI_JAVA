<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>Bootstrap Example</title>
  <style>
  h2{
  	color: orange;
  }
  h3{
  	color: purple;
  }
  #list thead tr {
	  text-align: center;
  }
  #list tbody tr {
  	text-align: center;
  }
  #del {
  	color: rgb(200,50,50);
  }
  </style>
  <% request.setCharacterEncoding("utf-8"); %>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
  <script src="/project/js/member.js"></script>
</head>
<body>
<nav class="navbar navbar-expand-sm bg-light">
  <ul class="navbar-nav">
<c:choose>
	<c:when test="${empty sessionScope.userId}">
	    <li class="nav-item">
	  	  <a class="nav-link" href="/project/member/login.me">로그인</a>
	    </li>
		<li class="nav-item">
      		<a class="nav-link" href="/project/member/insert.me">회원가입</a>
    	</li>
	</c:when>	    
  <c:otherwise>
	<li class="nav-item">
      <a class="nav-link" href="/project/member/logout.me">로그아웃</a>
    </li>
   	<li class="nav-item">
      <a class="nav-link" href="/project/member/view.me">정보변경</a>
    </li>
   	<li class="nav-item">
      <a class="nav-link" href="/project/member/delete.me">회원탈퇴</a>
    </li>
  </c:otherwise>
</c:choose>
    <li class="nav-item">
      <a class="nav-link" href="/project/board/board.me">게시판</a>
    </li>
  </ul>
 <div>
   	<c:if test="${not empty seesionScope.userId}">
		<span class="navbar-text" >
			${sessionScope.userId}님 반갑습니다.
		</span>
	</c:if>
</div>
</nav>

    
<div class="container">
  <h2>LOGIN form</h2>
  <form action="commentInsert" method="post">
    <div class="form-group">
      <label for="userId">UserId:</label>
      <input type="text" class="form-control" id="userId" placeholder="userId" name="userId">
    </div>
    <div class="form-group">
      <label for="pwd">Password:</label>
      <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pwd">
    </div>
    <div class="form-group form-check">
      <label class="form-check-label">
        <input class="form-check-input" type="checkbox" name="remember"> Remember me
      </label>
    </div>
    <button type="button" class="btn btn-primary" id="loginBtn">Submit</button>
    <button type="reset" class="btn btn-primary">Cancel</button>
  </form>
</div>
<script type="text/javascript">
$("#loginBtn").click(function(){
	if($("#userId").val()==""){
		alert("아이디를 입력하세요.");
		$("#userId").focus();
		return false;
	}
	if($("#pwd").val()==""){
		alert("암호를 입력하세요.");
		$("#pwd").focus();
		return false;
	}
	$.ajax({
		type:"post",
		url:"login.me",
		data:{"userId":$("#userId").val(),"pwd":$("#pwd").val()},
		success :function(value){
			if(value.trim()==-1){
				alert("회원아닙니다.");
				location.href="insert.me";
			}else if(value.trim()==0){
				alert("일반회원.");
				// 제이쿼리
//				$(location).attr("href","view.me");
				location.href="view.me";
			}else if(value.trim()==1){
				alert("관리자.");
				// 자바스크립트
				// get 방식으로 넘어감. get은 보통 조회 할때 쓰는 방식
				location.href="list.me";
			}else if(value.trim()==2){
				alert("암호가아닙니다.");
			}
		},
		error : function(e){
			alert("error : "+e);
		}
	});	// $.ajax
});	// loginBtn
</script>

<div class="jumbotron text-center" style="margin-bottom:0">
  <p>Footer</p>
</div>
</body>
</html>