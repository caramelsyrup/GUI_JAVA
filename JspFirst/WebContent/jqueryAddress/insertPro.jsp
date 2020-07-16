<%@page import="com.jqueryAddress.JAddressDAO"%>
<%@page import="com.jqueryAddress.Address" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	request.setCharacterEncoding("UTF-8");	
%>
<jsp:useBean id="address" class="com.jqueryAddress.Address"></jsp:useBean>
<jsp:setProperty property="*" name="address"/>
<%
	JAddressDAO dao = JAddressDAO.getInstance();
	dao.addressInsert(address);
	response.sendRedirect("list.jsp");
%>