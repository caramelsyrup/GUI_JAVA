<%@page import="com.jqueryAddress.JAddressDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	int num = Integer.parseInt(request.getParameter("num"));
	JAddressDAO dao = JAddressDAO.getInstance();
	dao.addressDelete(num);
	response.sendRedirect("list.jsp");
%>