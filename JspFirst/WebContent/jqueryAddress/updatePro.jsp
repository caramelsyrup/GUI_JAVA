<%@page import="com.jqueryAddress.JAddressDAO"%>
<%@page import="com.jqueryAddress.Address"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="address" class="com.jqueryAddress.Address"></jsp:useBean>
<jsp:setProperty property="*" name="address"/>
<%
	request.setCharacterEncoding("UTF-8");
	JAddressDAO dao = JAddressDAO.getInstance();
	dao.addressUpdate(address);
	response.sendRedirect("list.jsp");
%>