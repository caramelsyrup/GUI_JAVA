package com.address.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.address.model.SAddressDAO;
import com.address.model.SAddressDTO;

/**
 * Servlet implementation class InsertAction
 */
@WebServlet("/address/insert.do")
public class InsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String zipcode = request.getParameter("zipcode");
		String address = request.getParameter("address");
		String tel = request.getParameter("tel");
		
		SAddressDTO sa = new SAddressDTO();
		sa.setAddress(address);
		sa.setName(name);
		sa.setTel(tel);
		sa.setZipcode(zipcode);
		
		SAddressDAO dao = SAddressDAO.getinstance();
		dao.insertAddress(sa);
		
		response.sendRedirect("list.do");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
