package com.exam.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PersonServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		String name = req.getParameter("name");
		String id = req.getParameter("id");
		String passwd = req.getParameter("password");
		String gender = req.getParameter("gender");
		String [] notice = req.getParameterValues("notice");
		String job = req.getParameter("job");
		
		req.setAttribute("name", name);
		req.setAttribute("id", id);
		req.setAttribute("gender", gender);
		req.setAttribute("notice",notice );
		req.setAttribute("job", job);
		
		RequestDispatcher rd = req.getRequestDispatcher("personResult.jsp");
		rd.forward(req, resp);
		
		
	}
}
