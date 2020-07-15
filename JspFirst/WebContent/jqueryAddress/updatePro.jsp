<%@page import="com.address.AddressDAO"%>
<%@page import="com.address.Address"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="ad" class="com.address.Address"></jsp:useBean>
<jsp:setProperty property="*" name="ad"/>
<%
	request.setCharacterEncoding("UTF-8");
	AddressDAO dao = AddressDAO.getInstance();
	dao.addressUpdate(ad);
	response.sendRedirect("list.jsp");
%>