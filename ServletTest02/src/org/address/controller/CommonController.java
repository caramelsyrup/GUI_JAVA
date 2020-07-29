package org.address.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.ad")
public class CommonController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String requestURI = req.getRequestURI();
		String contextPath	=	req.getContextPath();
		String command = requestURI.substring(contextPath.length());
		
		if(command.equals("/list.ad")) {
			new AddressListAction().execute(req, resp);
		}else if(command.equals("/update.ad")) {
			new AddressUpdateAction().execute(req, resp);
		}else if(command.equals("/insertForm.ad")) {
			new AddressInsertFormAction().execute(req, resp);
		}else if(command.equals("/insert.ad")) {
			new AddressInsertAction().execute(req, resp);
		}else if(command.equals("/delete.ad")) {
			new AddressDeleteAction().execute(req, resp);
		}else if(command.equals("/search.ad")) {
			new AddressSearchAction().execute(req, resp);
		}else if(command.equals("/detail.ad")) {
			new AddressDetailAction().execute(req, resp);
		}else if(command.equals("/zipform.ad")) {
			new AddressZipformAction().execute(req, resp);
		}else if(command.equals("/zip.ad")) {
			new AddressZipAction().execute(req, resp);
		}
	}
}
