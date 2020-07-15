<%@page import="com.address.AddressDAO"%>
<%@page import="com.address.Address" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	request.setCharacterEncoding("UTF-8");	
%>
<jsp:useBean id="address" class="com.address.Address"></jsp:useBean>
<jsp:setProperty property="*" name="address"/>
<%
	AddressDAO dao = AddressDAO.getInstance();
	dao.addressInsert(address);
	response.sendRedirect("list.jsp");
%>