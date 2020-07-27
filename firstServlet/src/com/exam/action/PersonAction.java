package com.exam.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PersonAction
 */
@WebServlet("/exam/person2")
public class PersonAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		req.setCharacterEncoding("utf-8");
		String name = req.getParameter("name");
		String id = req.getParameter("id");
		String passwd = req.getParameter("password");
		String gender = req.getParameter("gender");
		String [] notice = req.getParameterValues("notice");
		String job = req.getParameter("job");
		
		Person person = new Person();
		person.setGender(gender);
		person.setId(id);
		person.setJob(job);
		person.setName(name);
		person.setNotice(notice);
		person.setPasswd(passwd);
		
		req.setAttribute("p", person);
		req.setAttribute("msg", "@Webservlet»ç¿ë");
		RequestDispatcher rd = req.getRequestDispatcher("personResult2.jsp");
		rd.forward(req, resp);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
