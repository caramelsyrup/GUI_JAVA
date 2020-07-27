<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- param은 jstl을 이용함. 기본 문법은 <c: />의 형태 -->
<!-- adder페이지에서 입력된 num1 값을 ${param.num1}의 형식으로 값을 받아온다. ${}는 표현식 -->
첫번째 : ${param.num1}<br></br>
<!-- num2도 num1과 같다. -->
두번째 : ${param.num2}<br></br> 

<!-- 받아온 두 값으로 단순한 연산이 바로 가능하다. -->
결과 : ${param.num1+param.num2}<br></br>

<!-- no라는 변수에 param.num1을 저장 -->
<c:set var="no" value="${param.num1}" /><br></br>

<!-- no변수를 그대로 출력 -->
no : ${no}<br></br>
<c:out value="${no}"/><br>
<!-- choose와 when을 사용. 이것은 마치 자바의 if문과 동일 -->
<c:choose>

	<c:when test="${no % 2 == 0 }">
		짝수
	</c:when>
	<c:otherwise>
		홀수
	</c:otherwise>
</c:choose>

<hr>
<!-- c:if는 otherwise가 없기때문에, 조건 false일때도  따로 적어줘야함. -->
<c:if test="${no%2==0 }">
	짝수
</c:if>
<c:if test="${no%2==1 }">
	홀수
</c:if>
</body>
</html>