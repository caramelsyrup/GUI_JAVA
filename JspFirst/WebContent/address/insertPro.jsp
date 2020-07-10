<%@page import="com.address.AddressDAO"%>
<%@page import="com.address.Address"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 화면에 넣을 부분이 없기에, HTML을 쓸 필요가 없다. -->
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="address" class="com.address.Address"/>
<jsp:setProperty property="*" name="address"/>
<%
	AddressDAO dao = AddressDAO.getInstance();
	dao.addressInsert(address);
	// 내용을 추가한 뒤에 바로 list파일 열기.
	response.sendRedirect("list.jsp");
%>