<%@page import="com.sun.corba.se.impl.orbutil.RepIdDelegator"%>
<%@page import="com.address.AddressDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	
%>
<jsp:useBean id="ad" class="com.address.Address"/>
<jsp:setProperty property="*" name="ad"/>
<%
	AddressDAO dao = AddressDAO.getInstance();
	dao.addressUpdate(ad);
	response.sendRedirect("list.jsp");
%>