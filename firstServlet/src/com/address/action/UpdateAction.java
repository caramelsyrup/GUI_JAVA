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
 * Servlet implementation class UpdateAction
 */
@WebServlet("/address/update.do")
public class UpdateAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		SAddressDTO dto = new SAddressDTO();
		dto.setAddress(request.getParameter("address"));
		dto.setName(request.getParameter("name"));
		dto.setTel(request.getParameter("tel"));
		dto.setZipcode(request.getParameter("zipcode"));
		dto.setNum(Integer.parseInt(request.getParameter("num")));
		
		SAddressDAO dao = SAddressDAO.getinstance();
		dao.addressUpdate(dto);
		
		RequestDispatcher rd = request.getRequestDispatcher("list.do");
		rd.forward(request, response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
